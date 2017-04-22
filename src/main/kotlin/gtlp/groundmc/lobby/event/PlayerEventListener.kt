package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.*
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.*
import org.bukkit.inventory.meta.SkullMeta
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

    @EventHandler
    fun onPlayerChangeWorld(event: PlayerChangedWorldEvent) {
        if (event.from == LobbyMain.hubLocation.get().world) {
            event.player.inventory.contents = LobbyMain.lobbyInventoryMap[event.player]?.originalContents
        } else if (event.player.world == LobbyMain.hubLocation.get().world) {
            LobbyMain.lobbyInventoryMap[event.player]?.originalContents = event.player.inventory.contents.clone()
            addItemsToInventory(event.player)
        }
    }

    @EventHandler
    fun onPlayerLogin(event: PlayerJoinEvent) {
        LobbyMain.lobbyInventoryMap[event.player] = LobbyInventoryHolder.forPlayer(event.player)
        LobbyMain.lobbyInventoryMap[event.player]?.originalContents = event.player.inventory.contents.clone()

        if (event.player.world == LobbyMain.hubLocation.get().world) {
            event.player.inventory.contents
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

    private fun addItemsToInventory(player: Player) {
        transaction {
            if (Users.select { Users.id.eq(player.uniqueId) }.count() == 0) {
                Users.insert {
                    it[Users.id] = player.uniqueId
                    it[Users.lastName] = player.name
                }
            }
            val inventory = player.inventory
            inventory.clear()
            inventory.setItem(0, Items.COMPASS_ITEM.item.clone())

            if (player.hasPermission(Permission.SILENT.id) || player.hasPermission(Permission.ADMIN.id)) {
                val silentItem = NBTItemExt(Items.SILENT_ITEM.item.clone())
                val silent = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.silentStatus]
                silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off")
                silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    silentItem.addEnchantment(Enchantment.LUCK)
                }
                inventory.setItem(1, silentItem.item)
            }

            if (player.hasPermission(Permission.HIDE_PLAYERS.id) || player.hasPermission(Permission.ADMIN.id)) {
                val nbtItem = Items.HIDE_PLAYERS_ITEM.clone()
                val hideState = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.hiddenStatus]
                LobbyMain.lobbyInventoryMap[player]!!.hidePlayerInventory.contents.filterNotNull().first { NBTItemExt(it).getInteger(NBTIdentifier.HIDE_STATE) == hideState.ordinal }.apply {
                    this.itemMeta = NBTItemExt(this).addEnchantment(Enchantment.LUCK).item.itemMeta
                    nbtItem.displayName = itemMeta.displayName
                    nbtItem.addEnchantment(Enchantment.LUCK)

                }
                inventory.setItem(2, nbtItem.item)
            }
            inventory.setItem(5, Items.FRIENDS_ITEM.clone().apply {
                val skullMeta = Bukkit.getItemFactory().asMetaFor(item.itemMeta, this.item) as SkullMeta
                skullMeta.owner = player.name
                item.itemMeta = skullMeta

            }.item)
            if (!player.hasPermission(Permission.ADMIN.id)) {
                player.gameMode = GameMode.ADVENTURE
            } else {
                player.gameMode = GameMode.CREATIVE
            }
        }
    }

    @EventHandler
    fun onPlayerLogout(event: PlayerQuitEvent) {
        event.player.inventory.contents = LobbyMain.lobbyInventoryMap[event.player]?.originalContents
        LobbyMain.lobbyInventoryMap.remove(event.player)
        LobbyMain.SILENCED_PLAYERS.remove(event.player)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        val nbtItem = NBTItemExt(event.itemDrop.itemStack)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun filterChat(event: AsyncPlayerChatEvent) {
        if (event.isCancelled) {
            return
        }
        event.recipients.removeAll(LobbyMain.SILENCED_PLAYERS)
        event.recipients.add(event.player)
    }

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

    @EventHandler
    fun launchPlayerForward(event: PlayerInteractEvent) {
        if (event.clickedBlock != null) {
            if (event.clickedBlock.type == Material.GOLD_PLATE && event.player.world == LobbyMain.hubLocation.get().world && event.action == Action.PHYSICAL) {
                event.player.velocity = event.player.location.getDirectionXZ().setY(0.5).multiply(3)
                event.isCancelled = true
            }
        }
    }

    fun Location.getDirectionXZ(): Vector {
        val vector = Vector()

        val rotX = this.yaw.toDouble()

        vector.y = 0.0

        vector.x = -Math.sin(Math.toRadians(rotX))
        vector.z = Math.cos(Math.toRadians(rotX))

        return vector.normalize()
    }
}
