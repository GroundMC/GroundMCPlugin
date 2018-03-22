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
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.FriendsOverviewInventory
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent


@Suppress("unused")
object FriendsOverviewListener : Listener {

    @EventHandler
    fun openFriendsOverview(event: InventoryClickEvent) {
        if (event.currentItem == Items.FRIENDS_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(FriendsOverviewInventory.create(event.whoClicked as Player))
        }
    }

    @EventHandler
    fun openFriendsOverview(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)) {
            event.isCancelled = true
            if (event.item == Items.FRIENDS_ITEM.item) {
                event.player.openInventory(FriendsOverviewInventory.create(event.player))
            }
        }
    }
}
