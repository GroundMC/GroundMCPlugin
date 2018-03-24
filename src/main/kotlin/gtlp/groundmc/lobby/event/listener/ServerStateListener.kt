

package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.util.*
import kotlinx.coroutines.experimental.async
import me.BukkitPVP.PointsAPI.PointsAPI
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerLocaleChangeEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.scoreboard.Team
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.joda.time.DateTime

/**
 * Listener to affect [Player]s directly.
 */
object ServerStateListener : Listener {

    /**
     * Generates and adds items to a player's inventory according to their permissions.
     *
     * @param player the player to generate the items for
     */
    private fun addItemsToInventory(player: Player) {
        var silent = false
        var hideState = VisibilityStates.ALL
        transaction {
            silent = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.silentStatus]
            hideState = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.hiddenStatus]
        }
        val inventory = player.inventory
        inventory.clear()

        inventory.setItem(0, Items.COMPASS_ITEM.item)

        if (player.hasPermission(Permission.SILENT)) {
            inventory.setItem(1, Items.SILENT_ITEM.apply {
                displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off", player.locale)
                setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    addEnchantment(Enchantment.LUCK)
                }
            }.item)
        }
        if (player.hasPermission(Permission.HIDE_PLAYERS)) {
            inventory.setItem(2, Items.HIDE_PLAYERS_ITEM.apply {
                displayName = I18n.getString(when (hideState) {
                    VisibilityStates.ALL -> "visibility.all"
                    VisibilityStates.NONE -> "visibility.none"
                    VisibilityStates.FRIENDS -> "visibility.friends"
                }, player.locale)
            }.item)
        }
        inventory.setItem(4, Items.FRIENDS_ITEM.apply {
            val newMeta = (meta as SkullMeta)
            newMeta.owningPlayer = player
            meta = newMeta
        }.item)
        if (Bukkit.getPluginManager().isPluginEnabled("CloudNetAPI")) {
            inventory.setItem(7, Items.LOBBY_CHOOSE_ITEM.item)
        }
    }

    /**
     * Saves and restores a player's inventory when travelling between the lobby
     * world and another world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun onPlayerChangeWorld(event: PlayerChangedWorldEvent) {
        if (event.from == (Meta[Config.HUB_LOCATION] as Location).world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        } else if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world) {
            LobbyMain.originalInventories[event.player] = event.player.inventory.copy()
            addItemsToInventory(event.player)
        }
    }

    /**
     * Handles changes in a player's locale.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun onPlayerChangeLocale(event: PlayerLocaleChangeEvent) {
        LobbyMain.logger.entering(ServerStateListener::class, "onPlayerChangeLocale")
        if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world) {
            addItemsToInventory(event.player)
        }
        LobbyMain.logger.exiting(ServerStateListener::class, "onPlayerChangeLocale")
    }

    /**
     * Handles a player joining the server.
     * Removes any message that should be sent on joining the server.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerLogin(event: PlayerJoinEvent) {
        LobbyMain.logger.entering(ServerStateListener::class, "onPlayerLogin")
        LobbyMain.logger.fine("Player joined: $event")
        event.joinMessage = null
        async {
            transaction {
                if (Users.select { Users.id eq event.player.uniqueId }.count() == 0) {
                    Users.insert {
                        it[id] = event.player.uniqueId
                        it[lastName] = event.player.name
                    }
                }
            }
        }

        LobbyMain.originalInventories[event.player] = event.player.inventory.copy()

        if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world) {
            addItemsToInventory(event.player)
        }

        event.player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).baseValue = 16.0

        async {
            addDailyBonus(event.player)
        }
        createScoreboard(event.player)
        LobbyMain.logger.exiting(ServerStateListener::class, "onPlayerLogin")
    }

    /**
     * Copies the content, teams and options from the player's scoreboard
     * to a new one.
     * This is done, so that every player has its own scoreboard
     *
     * @param player the player to create the scoreboard for */
    private fun createScoreboard(player: Player) {
        val oldBoard = player.scoreboard
        player.scoreboard = Bukkit.getScoreboardManager().newScoreboard
        oldBoard.teams.forEach {
            player.scoreboard.registerNewTeam(it.name).apply {
                this.color = it.color
                this.displayName = it.displayName
                this.prefix = it.prefix
                this.suffix = it.suffix
                this.setAllowFriendlyFire(it.allowFriendlyFire())
                this.setCanSeeFriendlyInvisibles(it.canSeeFriendlyInvisibles())
                it.entries.forEach(this::addEntry)
                Team.Option.values().forEach { option ->
                    this.setOption(option, it.getOption(option))
                }
            }
        }
    }

    /**
     * Adds the daily bonus coins to the balance of [player], if eligible.
     *
     * @param player the player to add the bonus for
     */
    private fun addDailyBonus(player: Player) {
        val playerRow = Users.getPlayer(player)
        if (playerRow[Users.lastDailyCoinsDate].plusDays(1).isBeforeNow) {
            player.sendMessage(I18n.getString("event.dailyCoins", player.locale)?.format(Meta[Config.COINS_DAILY]))
            player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
            transaction {
                Users.update({ Users.id eq player.uniqueId }) {
                    it[lastName] = player.name
                    PointsAPI.setPoints(player, PointsAPI.getPoints(player) + Meta[Config.COINS_DAILY] as Int)
                    it[lastDailyCoinsDate] = DateTime.now()
                }
            }
        }
    }

    /**
     * Cleans up when a player leaves the server.
     * Removes any message that should be sent on joining the server.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerLogout(event: PlayerQuitEvent) {
        LobbyMain.logger.entering(ServerStateListener::class, "onPlayerLogout")
        LobbyMain.logger.fine("Player left: $event")
        event.quitMessage = null
        if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        }
        LobbyMain.originalInventories.remove(event.player)
        LobbyMain.SILENCED_PLAYERS.remove(event.player)
        LobbyMain.logger.exiting(ServerStateListener::class, "onPlayerLogout")
    }
}
