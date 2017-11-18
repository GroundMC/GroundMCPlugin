package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.event.PlayerChangeLocaleEvent
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.copy
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChangedWorldEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
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

        inventory.setItem(0, Items.COMPASS_ITEM.clone().item)

        if (player.hasPermission(Permission.SILENT.id)) {
            val silentItem = Items.SILENT_ITEM
            silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off", player.locale)
            silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
            if (silent) {
                silentItem.addEnchantment(Enchantment.LUCK)
            }
            inventory.setItem(1, silentItem.item)
        }

        if (player.hasPermission(Permission.HIDE_PLAYERS.id)) {
            val nbtItem = Items.HIDE_PLAYERS_ITEM.apply {
                displayName = I18n.getString(when (hideState) {
                    VisibilityStates.ALL -> "visibility.all"
                    VisibilityStates.NONE -> "visibility.none"
                    VisibilityStates.FRIENDS -> "visibility.friends"
                }, player.locale)
            }
            inventory.setItem(2, nbtItem.item)
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
        if (event.from == LobbyMain.hubLocation.world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        } else if (event.player.world == LobbyMain.hubLocation.world) {
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
    fun onPlayerChangeLocale(event: PlayerChangeLocaleEvent) {
        if (event.player.world == LobbyMain.hubLocation.world) {
            addItemsToInventory(event.player)
        }
    }

    /**
     * Handles a player joining the server.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerLogin(event: PlayerJoinEvent) {
        transaction {
            if (Users.select { Users.id eq event.player.uniqueId }.count() == 0) {
                Users.insert {
                    it[id] = event.player.uniqueId
                    it[lastName] = event.player.name
                }
            }
        }
        LobbyMain.originalInventories[event.player] = event.player.inventory.copy()

        if (event.player.world == LobbyMain.hubLocation.world) {
            addItemsToInventory(event.player)
        }

        event.player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).baseValue = 16.0

        addDailyBonus(event.player)
    }

    /**
     * Adds the daily bonus coins to the balance of [player], if eligible.
     *
     * @param player the player to add the bonus for
     */
    private fun addDailyBonus(player: Player) {
        val playerRow = Users.getPlayer(player)
        if (playerRow[Users.lastDailyCoinsDate].plusDays(1).isBeforeNow) {
            player.sendMessage(I18n.getString("player.dailyCoins", player.locale)?.format(LobbyMain.dailyCoins))
            player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
            transaction {
                Users.update({ Users.id eq player.uniqueId }) {
                    it[lastName] = player.name
                    it[coins] = playerRow[coins] + LobbyMain.dailyCoins
                    it[lastDailyCoinsDate] = DateTime.now()
                }
            }
        }
    }

    /**
     * Cleans up when a player leaves the server.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerLogout(event: PlayerQuitEvent) {
        if (event.player.world == LobbyMain.hubLocation.world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        }
        LobbyMain.originalInventories.remove(event.player)
        LobbyMain.SILENCED_PLAYERS.remove(event.player)
    }
}
