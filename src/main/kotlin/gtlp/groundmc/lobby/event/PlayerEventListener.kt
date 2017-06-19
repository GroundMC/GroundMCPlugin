package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.task.RecreateItemsTask.addItemsToInventory
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.*
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.util.Vector
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.joda.time.DateTime
import org.joda.time.Instant

/**
 * Listener to affect [Player]s directly.
 */
class PlayerEventListener : Listener {

    /**
     * Saves and restores a player's inventory when travelling between the lobby
     * world and another world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun onPlayerChangeWorld(event: PlayerChangedWorldEvent) {
        if (event.from == LobbyMain.hubLocation.get().world) {
            event.player.inventory.contents = LobbyMain.lobbyInventoryMap[event.player]?.originalContents
        } else if (event.player.world == LobbyMain.hubLocation.get().world) {
            LobbyMain.lobbyInventoryMap[event.player]?.originalContents = event.player.inventory.contents.clone()
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
        LobbyMain.lobbyInventoryMap[event.player] = LobbyInventoryHolder.forPlayer(event.player)

        if (event.player.world == LobbyMain.hubLocation.get().world) {
            addItemsToInventory(event.player)
        }

        event.player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).baseValue = 16.0

        val playerRow = Users.getPlayer(event.player)
        if (playerRow[Users.lastDailyCoinsDate].plusDays(1).isBeforeNow) {
            event.player.sendMessage(I18n.getString("event.dailyCoins", event.player.spigot().locale)?.format(LobbyMain.dailyCoins))
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
            event.player.inventory.contents = LobbyMain.lobbyInventoryMap[event.player]?.originalContents
        }
        LobbyMain.lobbyInventoryMap.remove(event.player)
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
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
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
                event.player.sendMessage(I18n.getString("too_many_messages", event.player.spigot().locale))
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
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                event.isCancelled = true
                val inventoryView = event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
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
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                event.isCancelled = true
                if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                    nbtItem.displayName = I18n.getString("silentitem.off", event.player.spigot().locale)
                    nbtItem.removeEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.spigot().locale))
                    transaction {
                        Users.update({ Users.id eq event.player.uniqueId }) {
                            it[Users.silentStatus] = false
                        }
                    }
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    nbtItem.displayName = I18n.getString("silentitem.on", event.player.spigot().locale)
                    nbtItem.addEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.spigot().locale))
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
                event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.lobbyInventory)
                event.isCancelled = true
            }
            Items.HIDE_PLAYERS_ITEM.item -> {
                event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
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
     * Calculates a normalized vector based on the [Location.yaw] on the XZ-plane.
     *
     * @return a vector pointing in the direction of [Location.yaw] with a length of 1.
     */
    fun Location.getDirectionXZ(): Vector {
        val vector = Vector()

        val rotX = this.yaw.toDouble()

        vector.y = 0.0

        vector.x = -Math.sin(Math.toRadians(rotX))
        vector.z = Math.cos(Math.toRadians(rotX))

        return vector.normalize()
    }
}
