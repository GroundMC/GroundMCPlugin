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

package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.database.table.Relationships
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object FriendsOverviewInventory {
    internal const val TITLE = "Friends"

    fun create(player: Player) = Bukkit.createInventory(player, 4 * 9, TITLE)
            .apply {
                Relationships.getRelationships(player).forEach {
                    addItem(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort()).apply {
                        (itemMeta as SkullMeta).owningPlayer = it.user2
                    })
                }
            }!!
}
