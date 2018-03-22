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

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.bridge.CloudServer
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

object LobbyChooser {

    const val TITLE = "Running lobbies"

    fun create(player: Player) = Bukkit.createInventory(player, 3 * 9, TITLE)
            .apply {
                val servers =
                        CloudAPI.getInstance().getServers(CloudServer.getInstance().groupData.name)
                servers.sortedBy { it.serviceId.id }.forEachIndexed { index, serverInfo ->
                    val material = when (serverInfo.serviceId.id) {
                        CloudServer.getInstance().serverProcessMeta.serviceId.id -> Material.GLOWSTONE_DUST
                        else -> Material.SUGAR
                    }
                    setItem(index, NBTItemExt(ItemStack(material)).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        setInteger(NBTIdentifier.TYPE, GMCType.CHOOSE_LOBBY.ordinal)
                        setString(NBTIdentifier.TP_LOC, serverInfo.serviceId.serverId)
                        lore = listOf("Online: ${serverInfo.players.size}/${serverInfo.maxPlayers}")
                        addEnchantment(Enchantment.LUCK)
                        addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        displayName = serverInfo.serviceId.serverId
                    }.item)
                }
            }!!
}
