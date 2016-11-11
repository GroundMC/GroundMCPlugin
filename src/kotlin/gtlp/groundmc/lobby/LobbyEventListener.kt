package gtlp.groundmc.lobby

import de.tr7zw.itemnbtapi.NBTItem
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.GMCType
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.Permission
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
                val nbtItem = NBTItem(event.currentItem)
                if (nbtItem.hasKey(LobbyMain.NBT_PREFIX)) {
                    if (nbtItem.getInteger(LobbyMain.NBT_TYPE) == GMCType.TP.ordinal) {
                        if (event.whoClicked.teleport(Location(Bukkit.getWorld(nbtItem.getString(LobbyMain.NBT_LOC_WORLD)), nbtItem.getDouble(LobbyMain.NBT_LOC_X), nbtItem.getDouble(LobbyMain.NBT_LOC_Y), nbtItem.getDouble(LobbyMain.NBT_LOC_Z)), PlayerTeleportEvent.TeleportCause.PLUGIN)) {
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
            val nbtItem = NBTItem(event.item)
            if (nbtItem.hasKey(LobbyMain.NBT_PREFIX) && nbtItem.getInteger(LobbyMain.NBT_TYPE) == GMCType.SILENT.ordinal) {
                val meta: ItemMeta
                if (nbtItem.getBoolean(LobbyMain.NBT_SILENT_STATE)) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(LobbyMain.NBT_SILENT_STATE, false)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("silentitem.off", event.player.spigot().locale)
                    meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.spigot().locale))
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(LobbyMain.NBT_SILENT_STATE, true)
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
            val nbtItem = NBTItem(event.item)
            if (nbtItem.hasKey(LobbyMain.NBT_PREFIX) && nbtItem.getInteger(LobbyMain.NBT_TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                val meta: ItemMeta
                if (nbtItem.getBoolean(LobbyMain.NBT_HIDE_STATE)) {
                    nbtItem.setBoolean(LobbyMain.NBT_HIDE_STATE, false)
                    meta = nbtItem.item.itemMeta
                    meta.displayName = I18n.getString("hideitem.off", event.player.spigot().locale)
                    meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)
                    event.player.sendMessage(I18n.getString("hidemsg.off", event.player.spigot().locale))
                } else {
                    nbtItem.setBoolean(LobbyMain.NBT_HIDE_STATE, true)
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
        val nbtItem = NBTItem(event.itemDrop.itemStack)
        if (nbtItem.hasKey(LobbyMain.NBT_PREFIX)) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        val nbtItem = NBTItem(event.itemInHand)
        if (nbtItem.hasKey(LobbyMain.NBT_PREFIX)) {
            event.isCancelled = true
        }
    }

    companion object {
        private val COMPASS_ITEM: ItemStack
            get() {
                val nbtItem = NBTItem(ItemStack(Material.COMPASS))
                nbtItem.setBoolean(LobbyMain.NBT_PREFIX, true)
                val meta = nbtItem.item.itemMeta
                meta.displayName = ChatColor.RED.toString() + "Lobby"
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }
        private val SILENT_ITEM: ItemStack
            get() {
                val nbtItem = NBTItem(ItemStack(Material.TNT))
                nbtItem.setBoolean(LobbyMain.NBT_PREFIX, true)
                nbtItem.setInteger(LobbyMain.NBT_TYPE, GMCType.SILENT.ordinal)
                nbtItem.setBoolean(LobbyMain.NBT_SILENT_STATE, false)
                val meta = nbtItem.item.itemMeta
                meta.displayName = I18n.getString("silentitem.off")
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }
        private val HIDE_PLAYERS_ITEM: ItemStack
            get() {
                val nbtItem = NBTItem(ItemStack(Material.TNT))
                nbtItem.setBoolean(LobbyMain.NBT_PREFIX, true)
                nbtItem.setInteger(LobbyMain.NBT_TYPE, GMCType.HIDE_PLAYERS.ordinal)
                nbtItem.setBoolean(LobbyMain.NBT_HIDE_STATE, false)
                val meta = nbtItem.item.itemMeta
                meta.displayName = I18n.getString("hideitem.off")
                nbtItem.item.itemMeta = meta
                return nbtItem.item
            }

    }

}
