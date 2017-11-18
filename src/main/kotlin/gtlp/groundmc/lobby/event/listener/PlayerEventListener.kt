package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.event.PlayerChangeLocaleEvent
import gtlp.groundmc.lobby.inventory.HidePlayerInventory
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import gtlp.groundmc.lobby.util.copy
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.*
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.util.Vector
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.joda.time.DateTime
import org.joda.time.Instant

/**
 * Listener to affect [Player]s directly.
 */
class PlayerEventListener : Listener {

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

        if (player.hasPermission(Permission.SILENT.id) || player.hasPermission(Permission.ADMIN.id)) {
            val silentItem = Items.SILENT_ITEM
            silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off", player.locale)
            silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
            if (silent) {
                silentItem.addEnchantment(Enchantment.LUCK)
            }
            inventory.setItem(1, silentItem.item)
        }

        if (player.hasPermission(Permission.HIDE_PLAYERS.id) || player.hasPermission(Permission.ADMIN.id)) {
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
        if (event.from == LobbyMain.hubLocation.get().world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        } else if (event.player.world == LobbyMain.hubLocation.get().world) {
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
        if (event.player.world == LobbyMain.hubLocation.get().world) {
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

        if (event.player.world == LobbyMain.hubLocation.get().world) {
            addItemsToInventory(event.player)
        }

        event.player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).baseValue = 16.0

        val playerRow = Users.getPlayer(event.player)
        if (playerRow[Users.lastDailyCoinsDate].plusDays(1).isBeforeNow) {
            event.player.sendMessage(I18n.getString("event.dailyCoins", event.player.locale)?.format(LobbyMain.dailyCoins))
            event.player.playSound(event.player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
            transaction {
                Users.update({ Users.id eq event.player.uniqueId }) {
                    it[Users.lastName] = event.player.name
                    it[Users.coins] = playerRow[Users.coins] + LobbyMain.dailyCoins
                    it[Users.lastDailyCoinsDate] = DateTime.now()
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
        if (event.player.world == LobbyMain.hubLocation.get().world) {
            event.player.inventory.contents = LobbyMain.originalInventories[event.player]
        }
        LobbyMain.originalInventories.remove(event.player)
        LobbyMain.SILENCED_PLAYERS.remove(event.player)
    }

    /**
     * Prevents players dropping items with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        val nbtItem = NBTItemExt(event.itemDrop.itemStack)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)!!) {
            event.isCancelled = true
        }
    }

    /**
     * Filters the recipients of a chat message by removing all players that
     * want a silent chat.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun filterChat(event: AsyncPlayerChatEvent) {
        if (event.isCancelled) {
            return
        }
        event.recipients.removeAll(LobbyMain.SILENCED_PLAYERS)
        event.recipients.add(event.player)
    }

    /**
     * Slows down the chat by cancelling fast chat messages.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun slowChat(event: AsyncPlayerChatEvent) {
        if (LobbyMain.instance.get().config.getBoolean("slowchat.enabled")) {
            val key = "lastChatMsg"
            if (event.player.hasMetadata(key) && (Instant.now() - event.player.getMetadata(key).first { it.owningPlugin == LobbyMain.instance.get() }.asLong()) < Instant(LobbyMain.instance.get().config.getLong("slowchat.timeout"))) {
                event.isCancelled = true
                event.player.sendMessage(I18n.getString("too_many_messages", event.player.locale))
                LobbyMain.logger.finest("${event.player} sent messages too quickly!")
            } else {
                event.player.setMetadata(key, FixedMetadataValue(LobbyMain.instance.get(), Instant().millis))
            }
        }
    }

    /**
     * Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory].
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun hidePlayers(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX)!! && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                event.isCancelled = true
                event.player.openInventory(HidePlayerInventory.create(event.player))
            }
        }
    }

    /**
     * Updates the chat silence setting.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun silentChat(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX)!! && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                event.isCancelled = true
                if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)!!) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                    nbtItem.displayName = I18n.getString("silentitem.off", event.player.locale)
                    nbtItem.removeEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.locale))
                    transaction {
                        Users.update({ Users.id eq event.player.uniqueId }) {
                            it[Users.silentStatus] = false
                        }
                    }
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    nbtItem.displayName = I18n.getString("silentitem.on", event.player.locale)
                    nbtItem.addEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.locale))
                    transaction {
                        Users.update({ Users.id eq event.player.uniqueId }) {
                            it[Users.silentStatus] = true
                        }
                    }
                }
                event.player.inventory.setItem(1, nbtItem.item)
            }
        }
    }

    /**
     * Opens the inventory that matches the item.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun openInventory(event: PlayerInteractEvent) {
        when (event.item) {
            Items.COMPASS_ITEM.item -> {
                event.player.openInventory(LobbyInventory.create(event.player))
                event.isCancelled = true
            }
            Items.HIDE_PLAYERS_ITEM.item -> {
                event.player.openInventory(HidePlayerInventory.create(event.player))
                event.isCancelled = true
            }
        }
    }

    /**
     * Launches a player forward when stepping on a golden pressure plate.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun launchPlayerForward(event: PlayerInteractEvent) {
        if (event.clickedBlock != null) {
            if (event.clickedBlock.type.name in LobbyMain.instance.get().config.getList("jumppads.material") && event.player.world == LobbyMain.hubLocation.get().world && event.action == Action.PHYSICAL) {
                event.player.velocity = event.player.location.getDirectionXZ().multiply(LobbyMain.instance.get().config.getDouble("jumppads.multiplier")).setY(LobbyMain.instance.get().config.getDouble("jumppads.y"))
                event.isCancelled = true
            }
        }
    }

    /**
     * Prevents players from picking up items when they are in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventItemPickup(event: EntityPickupItemEvent) {
        if (event.player.world == LobbyMain.hubLocation.get().world) {
            event.isCancelled = true
        }
    }

    /**
     * Calculates a normalized vector based on the [Location.yaw] on the XZ-plane.
     *
     * @return a vector pointing in the direction of [Location.yaw] with a length of 1.
     */
    private fun Location.getDirectionXZ(): Vector {
        val vector = Vector()

        val rotX = this.yaw.toDouble()

        vector.y = 0.0

        vector.x = -Math.sin(Math.toRadians(rotX))
        vector.z = Math.cos(Math.toRadians(rotX))

        return vector.normalize()
    }
}
