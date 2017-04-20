package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerTeleportEvent
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * Listener to handle events that occur in a [org.bukkit.entity.Player]'s [org.bukkit.inventory.Inventory]
 */
class InventoryClickEventListener : Listener {

    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        if (event.clickedInventory == LobbyMain.lobbyInventoryMap[player]?.lobbyInventory) {
            event.isCancelled = true
            if (event.currentItem != null) {
                val nbtItem = NBTItemExt(event.currentItem)
                if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
                    if (nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                        if (player.teleport(nbtItem.getObject(NBTIdentifier.TP_LOC, Location::class), PlayerTeleportEvent.TeleportCause.PLUGIN)) {
                            val location = player.location
                            player.playSound(location, Sound.BLOCK_PORTAL_TRAVEL, 1.0f, 1.0f)
                            player.spawnParticle(Particle.PORTAL, location, 100)
                            player.spawnParticle(Particle.SMOKE_LARGE, location, 1000, 0.1, 0.1, 0.1)
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (event.whoClicked.world == LobbyMain.hubLocation.get().world) {
            if (event.currentItem != null && NBTItemExt(event.currentItem).getBoolean(NBTIdentifier.PREFIX)) {
                event.result = Event.Result.DENY
                when {
                    event.currentItem == Items.COMPASS_ITEM.item -> {
                        event.whoClicked.openInventory(LobbyMain.lobbyInventoryMap[event.whoClicked]?.lobbyInventory)
                    }
                }
            }
        }
    }

    @EventHandler
    fun selectHideState(event: InventoryClickEvent) {
        if (event.clickedInventory == LobbyMain.lobbyInventoryMap[event.whoClicked]?.hidePlayerInventory) {
            event.result = Event.Result.DENY
            if (event.currentItem != null) {
                val nbtItem = NBTItemExt(event.currentItem)
                if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
                    if (nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                        event.clickedInventory.contents.filterNotNull().forEach { itemstack -> itemstack.removeEnchantment(Enchantment.LUCK) }
                        nbtItem.addEnchantment(Enchantment.LUCK)
                        event.currentItem = nbtItem.item
                        event.whoClicked.inventory.setItem(2, NBTItemExt(event.whoClicked.inventory.getItem(2)).apply {
                            this.displayName = nbtItem.displayName
                        }.item)
                        transaction {
                            Users.update({ Users.id.eq(event.whoClicked.uniqueId) }) {
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