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

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.util.hasPermission
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent

/**
 * This [Listener] cancels any world interaction in the lobby or with items
 * that are designed to be used in the lobby.
 *
 * Interactions include dropping items, placing blocks or picking up items.
 */
object PreventWorldInteractionListener : Listener {

    /**
     * Prevents players to place blocks with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        if (NBTIdentifier.itemHasPrefix(event.itemInHand)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents players dropping items with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        if (NBTIdentifier.itemHasPrefix(event.itemDrop.itemStack)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents non-admin players from picking up items when they are in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventItemPickup(event: EntityPickupItemEvent) {
        if (event.entity.world == (Meta[Config.HUB_LOCATION] as Location).world
                && !event.entity.hasPermission(Permission.ADMIN)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents non-admin players from breaking blocks in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventBlockBreaking(event: BlockBreakEvent) {
        if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world
                && !event.player.hasPermission(Permission.ADMIN)) {
            event.isCancelled = true
        }
    }
}
