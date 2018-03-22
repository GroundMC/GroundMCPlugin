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

package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Task to update players and their change in the visibility state.
 */
object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        transaction {
            val onlinePlayers =
                    Users.select { Users.id inList Bukkit.getOnlinePlayers().map { it.uniqueId } }.toList()
                            .associateBy { Bukkit.getPlayer(it[Users.id]) }
            onlinePlayers.filter { !it.value[Users.vanishStatus] }
                    .forEach { player, status ->
                        when (status[Users.hiddenStatus]) {
                            VisibilityStates.ALL -> {
                                Bukkit.getOnlinePlayers().forEach { player.showPlayer(LobbyMain.instance, it) }
                            }
                            VisibilityStates.NONE -> {
                                Bukkit.getOnlinePlayers().forEach { player.hidePlayer(LobbyMain.instance, it) }
                            }
                            VisibilityStates.FRIENDS -> {
                                val friends = Relationships.getOnlineFriends(player)
                                val nonFriends = Relationships.getOnlineNonFriends(player)
                                friends.forEach {
                                    player.showPlayer(LobbyMain.instance, it)
                                }
                                nonFriends.forEach {
                                    player.hidePlayer(LobbyMain.instance, it)
                                }
                            }
                        }
                    }

            onlinePlayers.filter { it.value[Users.vanishStatus] }
                    .forEach { player ->
                        onlinePlayers.forEach {
                            it.key.hidePlayer(LobbyMain.instance, player.key)
                        }
                    }
        }
    }
}
