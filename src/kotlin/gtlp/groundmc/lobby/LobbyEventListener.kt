package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.*
import org.bukkit.*
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

internal class LobbyEventListener : Listener {

    @EventHandler
    fun preventDamage(event: EntityDamageEvent) {
        if (event.entity.world == LobbyMain.hubWorld) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerLogin(event: PlayerJoinEvent) {
        LobbyMain.inventoryMap[event.player] = LobbyInventory.cloneInventory(LobbyMain.TEMPLATE_INVENTORY, event.player)
        val inventory = event.player.inventory
        inventory.setItem(0, COMPASS_ITEM.clone())
        if (event.player.hasPermission(Permission.SILENT.toString())) {
            inventory.setItem(1, SILENT_ITEM.clone())
        }
        if (event.player.hasPermission(Permission.HIDE_PLAYERS.toString())) {
            inventory.setItem(2, HIDE_PLAYERS_ITEM.clone())
        }
    }

    @EventHandler
    fun onPlayerLogout(event: PlayerQuitEvent) {
        LobbyMain.inventoryMap.remove(event.player)
    }

    @EventHandler
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (event.whoClicked.world == LobbyMain.hubWorld) {
            if (event.currentItem == COMPASS_ITEM) {
                event.isCancelled = true
                event.whoClicked.openInventory(LobbyMain.inventoryMap[event.whoClicked])
                return
            }
        }
    }

    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        if (event.clickedInventory == LobbyMain.inventoryMap[event.whoClicked]) {
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
    fun openLobbyInventory(event: PlayerInteractEvent) {
        if (event.item == COMPASS_ITEM) {
            event.player.openInventory(LobbyMain.inventoryMap[event.player])
        }
    }

    @EventHandler
    fun silentChat(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                val meta: ItemMeta
                if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("silentitem.off", event.player.spigot().locale)
                    meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.spigot().locale))
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("silentitem.on", event.player.spigot().locale)
                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.spigot().locale))
                }
                nbtItem.item.itemMeta = meta
                event.player.inventory.setItem(1, nbtItem.item)
            }
        }
    }

    @EventHandler
    fun hidePlayers(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                val meta: ItemMeta
                if (nbtItem.getBoolean(NBTIdentifier.HIDE_STATE)) {
                    nbtItem.setBoolean(NBTIdentifier.HIDE_STATE, false)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("hideitem.off", event.player.spigot().locale)
                    meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)
                    event.player.sendMessage(I18n.getString("hidemsg.off", event.player.spigot().locale))
                } else {
                    nbtItem.setBoolean(NBTIdentifier.HIDE_STATE, true)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("hideitem.on", event.player.spigot().locale)
                    meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true)
                    event.player.sendMessage(I18n.getString("hidemsg.on", event.player.spigot().locale))
                }
                nbtItem.item.itemMeta = meta
                event.player.inventory.setItem(1, nbtItem.item)
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
        private val COMPASS_ITEM: ItemStack
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.COMPASS))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                val meta = nbtItem.item.itemMeta
                meta.displayName = ChatColor.RED.toString() + "Lobby"
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }
        private val SILENT_ITEM: ItemStack
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.TNT))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                val meta = nbtItem.item.itemMeta
                meta.displayName = I18n.getString("silentitem.off")
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }
        private val HIDE_PLAYERS_ITEM: ItemStack
            get() {
                val nbtItem = NBTItemExt(ItemStack(Material.BLAZE_ROD))
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                nbtItem.setBoolean(NBTIdentifier.HIDE_STATE, false)
                val meta = nbtItem.item.itemMeta
                meta.displayName = I18n.getString("hideitem.off")
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }

    }

}
