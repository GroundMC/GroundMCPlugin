package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.database.table.Friends
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.Permission
import gtlp.groundmc.lobby.enum.VisibilityStates
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.*
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PotionSplashEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

internal class LobbyEventListener : Listener {

    @EventHandler
    fun preventDamage(event: EntityDamageEvent) {
        if (event.entity.world == LobbyMain.hubWorld) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun removePotionEffects(event: PotionSplashEvent) {
        if (event.entity.world == LobbyMain.hubWorld) {
            // Remove players from affectedEntities
            event.affectedEntities.filter { it is Player }.forEach { event.setIntensity(it, -1.0) }
        }
    }

    @EventHandler
    fun onPlayerLogin(event: PlayerJoinEvent) {
        transaction {
            LobbyMain.lobbyInventoryMap[event.player] = LobbyInventoryHolder.forPlayer(event.player)
            if (Friends.select { Friends.id.eq(event.player.uniqueId) }.count() == 0) {
                Friends.insert {
                    it[Friends.id] = event.player.uniqueId
                    it[Friends.friends] = Friends.prepareFriendList(arrayOf(event.player.uniqueId))
                }
            }
            val inventory = event.player.inventory
            inventory.setItem(0, COMPASS_ITEM.item.clone())
            if (event.player.hasPermission(Permission.SILENT.toString())) {
                val silentItem = NBTItemExt(SILENT_ITEM.item.clone())
                val silent = Friends.select { Friends.id.eq(event.player.uniqueId) }.first()[Friends.silentStatus]
                silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off")
                silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    silentItem.addEnchantment(Enchantment.LUCK)
                }
                inventory.setItem(1, silentItem.item)
            }
            if (event.player.hasPermission(Permission.HIDE_PLAYERS.toString())) {
                val nbtItem = HIDE_PLAYERS_ITEM.clone()
                val hideState = Friends.select { Friends.id.eq(event.player.uniqueId) }.first()[Friends.hiddenStatus]
                LobbyMain.lobbyInventoryMap[event.player]!!.hidePlayerInventory.contents.filterNotNull().first { NBTItemExt(it).getInteger(NBTIdentifier.HIDE_STATE) == hideState.ordinal }.apply {
                    this.itemMeta = NBTItemExt(this).addEnchantment(Enchantment.LUCK).item.itemMeta
                    nbtItem.displayName = itemMeta.displayName
                    nbtItem.addEnchantment(Enchantment.LUCK)

                }
                inventory.setItem(2, nbtItem.item)
            }
            if (!event.player.hasPermission(Permission.ADMIN.toString())) {
                event.player.gameMode = GameMode.ADVENTURE
            } else {
                event.player.gameMode = GameMode.CREATIVE
            }
        }
    }

    @EventHandler
    fun onPlayerLogout(event: PlayerQuitEvent) {
        LobbyMain.lobbyInventoryMap.remove(event.player)
    }

    @EventHandler
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (event.whoClicked.world == LobbyMain.hubWorld) {
            if (event.currentItem == COMPASS_ITEM.item) {
                event.isCancelled = true
                event.whoClicked.openInventory(LobbyMain.lobbyInventoryMap[event.whoClicked]?.lobbyInventory)
                return
            }
        }
    }

    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        if (event.clickedInventory == LobbyMain.lobbyInventoryMap[event.whoClicked]?.lobbyInventory) {
            event.isCancelled = true
            if (event.currentItem != null) {
                val nbtItem = NBTItemExt(event.currentItem)
                if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
                    if (nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                        if (event.whoClicked.teleport(Location(Bukkit.getWorld(nbtItem.getString(NBTIdentifier.LOC_WORLD)), nbtItem.getDouble(NBTIdentifier.LOC_X), nbtItem.getDouble(NBTIdentifier.LOC_Y), nbtItem.getDouble(NBTIdentifier.LOC_Z)), PlayerTeleportEvent.TeleportCause.PLUGIN)) {
                            event.whoClicked.world.spigot().playEffect(event.whoClicked.location, Effect.PORTAL_TRAVEL)
                            event.whoClicked.world.spigot().playEffect(event.whoClicked.location, Effect.LARGE_SMOKE, 0, 0, 1f, 1f, 1f, 0.1f, 100, 1)
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun openInventory(event: PlayerInteractEvent) {
        when (event.item) {
            COMPASS_ITEM.item -> event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.lobbyInventory)
            HIDE_PLAYERS_ITEM.item -> event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
        }
    }

    @EventHandler
    fun silentChat(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                    nbtItem.displayName = I18n.getString("silentitem.off", event.player.spigot().locale)
                    nbtItem.removeEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.spigot().locale))
                    transaction {
                        Friends.update({ Friends.id eq event.player.uniqueId }) {
                            it[Friends.silentStatus] = false
                        }
                    }
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    nbtItem.displayName = I18n.getString("silentitem.on", event.player.spigot().locale)
                    nbtItem.addEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.spigot().locale))
                    transaction {
                        Friends.update({ Friends.id eq event.player.uniqueId }) {
                            it[Friends.silentStatus] = true
                        }
                    }
                }
                event.player.inventory.setItem(1, nbtItem.item)
            }
        }
    }

    @EventHandler
    fun hidePlayers(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                val inventoryView = event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
            }
        }
    }

    @EventHandler
    fun selectHideState(event: InventoryClickEvent) {
        if (event.clickedInventory == LobbyMain.lobbyInventoryMap[event.whoClicked]?.hidePlayerInventory) {
            event.isCancelled = true
            if (event.currentItem != null) {
                val nbtItem = NBTItemExt(event.currentItem)
                if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
                    if (nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                        event.clickedInventory.contents.filterNotNull().forEach { itemstack -> itemstack.removeEnchantment(Enchantment.LUCK) }
                        nbtItem.addEnchantment(Enchantment.LUCK)
                        event.currentItem = nbtItem.item
                        event.whoClicked.inventory.setItem(2, event.whoClicked.inventory.getItem(2).apply {
                            val blazeRod = NBTItemExt(this)
                            blazeRod.displayName = nbtItem.displayName
                            this.itemMeta = blazeRod.item.itemMeta
                        })
                        transaction {
                            Friends.update({ Friends.id.eq(event.whoClicked.uniqueId) }) {
                                it[hiddenStatus] = VisibilityStates.values()[nbtItem.getInteger(NBTIdentifier.HIDE_STATE)]
                            }
                        }
                        event.whoClicked.sendMessage(nbtItem.displayName)
                        event.view.close()
                    }
                }
            }
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

    @EventHandler
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        val nbtItem = NBTItemExt(event.itemDrop.itemStack)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        val nbtItem = NBTItemExt(event.itemInHand)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

    companion object {
        private val COMPASS_ITEM: NBTItemExt
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.COMPASS))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
                nbtItem.displayName = ChatColor.RED.toString() + "Lobby"
                return nbtItem
            }
        private val SILENT_ITEM: NBTItemExt
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.TNT))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
                nbtItem.displayName = I18n.getString("silentitem.off")
                return nbtItem
            }
        private val HIDE_PLAYERS_ITEM: NBTItemExt
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.BLAZE_ROD))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                nbtItem.setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
                nbtItem.addEnchantment(Enchantment.LUCK)
                nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
                nbtItem.displayName = I18n.getString("visibility.all")
                return nbtItem
            }

    }

}
