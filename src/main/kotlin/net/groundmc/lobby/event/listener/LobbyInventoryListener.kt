package net.groundmc.lobby.event.listener

import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.inventory.LobbyInventory
import net.groundmc.lobby.objects.Items
import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerTeleportEvent

/**
 * Listener to handle events that occur in a [org.bukkit.entity.Player]'s [org.bukkit.inventory.Inventory]
 */
object LobbyInventoryListener : Listener {

    /**
     * Handles an [InventoryClickEvent] and teleports a player to the location defined
     * in the item that the player clicked on, if it is compatible.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        if (event.currentItem != null
                && event.clickedInventory != null
                && event.clickedInventory.title == LobbyInventory.TITLE) {
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                event.result = Event.Result.DENY
                if (player.teleport(nbtItem.getObject(NBTIdentifier.TP_LOC, Location::class), PlayerTeleportEvent.TeleportCause.PLUGIN)) {
                    player.playSound(player.location, Sound.BLOCK_PORTAL_TRAVEL, 0.5f, 1.0f)
                    player.spawnParticle(Particle.PORTAL, player.location, 100)
                    player.spawnParticle(Particle.SMOKE_LARGE, player.location, 1000, 0.1, 0.1, 0.1)
                }
            }
        }
    }

    /**
     * Denies default actions when clicking on items with the [NBTIdentifier.PREFIX].
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem) &&
                event.inventory.title == LobbyInventory.TITLE) {
            event.result = Event.Result.DENY
        }
    }

    /**
     * Opens the [net.groundmc.lobby.inventory.LobbyInventory]
     * when clicking on [Items.COMPASS_ITEM] in an inventory in the lobby world.
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun openLobbyInventory(event: InventoryClickEvent) {
        if (event.currentItem == Items.COMPASS_ITEM.item) {
            event.result = Event.Result.DENY
            Bukkit.getScheduler().runTask(net.groundmc.lobby.LobbyMain.instance, {
                event.whoClicked.openInventory(LobbyInventory.create(event.whoClicked))
            })
        }
    }

    /**
     * Opens the [net.groundmc.lobby.inventory.LobbyInventory]
     * when clicking with [Items.COMPASS_ITEM] in the lobby world.
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun openLobbyInventory(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)
                && event.item == Items.COMPASS_ITEM.item) {
            event.isCancelled = true
            Bukkit.getScheduler().runTask(net.groundmc.lobby.LobbyMain.instance, {
                event.player.openInventory(LobbyInventory.create(event.player))
            })
        }
    }
}
