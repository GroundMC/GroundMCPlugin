/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.NBTItemExt
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
        if (event.clickedInventory != null && event.clickedInventory.title == LobbyInventory.TITLE) {
            event.isCancelled = true
            if (event.currentItem == null) {
                return
            }
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                if (player.teleport(nbtItem.getObject(NBTIdentifier.TP_LOC, Location::class), PlayerTeleportEvent.TeleportCause.PLUGIN)) {
                    player.playSound(player.location, Sound.BLOCK_PORTAL_TRAVEL, 1.0f, 1.0f)
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
                event.inventory.title != LobbyInventory.TEMPLATE_INVENTORY.title) {
            event.result = Event.Result.DENY
        }
    }

    /**
     * Opens the [gtlp.groundmc.lobby.inventory.LobbyInventory]
     * when clicking on [Items.COMPASS_ITEM] in an inventory in the lobby world.
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun openLobbyInventory(event: InventoryClickEvent) {
        if (event.currentItem == Items.COMPASS_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(LobbyInventory.create(event.whoClicked))
        }
    }

    /**
     * Opens the [gtlp.groundmc.lobby.inventory.LobbyInventory]
     * when clicking with [Items.COMPASS_ITEM] in the lobby world.
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun openLobbyInventory(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)) {
            event.isCancelled = true
            if (event.item == Items.COMPASS_ITEM.item) {
                event.player.openInventory(LobbyInventory.create(event.player))
            }
        }
    }

}
