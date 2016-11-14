package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Friends
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.VisibilityStates
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.Effect
import org.bukkit.Location
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * Created by Marv1 on 14.11.2016.
 */
class InventoryClickEventListener : Listener {
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
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (event.whoClicked.world == LobbyMain.hubWorld) {
            if (event.currentItem == Items.COMPASS_ITEM.item) {
                event.isCancelled = true
                event.whoClicked.openInventory(LobbyMain.lobbyInventoryMap[event.whoClicked]?.lobbyInventory)
                return
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
                            gtlp.groundmc.lobby.database.table.Friends.update({ Friends.id.eq(event.whoClicked.uniqueId) }) {
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
}