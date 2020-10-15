package net.groundmc.lobby.task

import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.VisibilityStates
import org.bukkit.Bukkit

/**
 * Task to update players and their change in the visibility state.
 */
object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        val players = Bukkit.getOnlinePlayers()

        Users.getAll(players.map { it.uniqueId })
                .mapKeys { Bukkit.getPlayer(it.key) }
                .forEach { (player, status) ->
                    if (status[Users.vanishStatus]) {
                        players.forEach {
                            it.hidePlayer(LobbyMain.instance, player)
                        }
                    } else when (status[Users.hiddenStatus]) {
                        VisibilityStates.ALL -> {
                            players.forEach { player.showPlayer(LobbyMain.instance, it) }
                        }
                        VisibilityStates.NONE -> {
                            players.forEach { player.hidePlayer(LobbyMain.instance, it) }
                        }
                        VisibilityStates.FRIENDS -> {
                            players.forEach {
                                if (Relationships.areFriends(player, it)) {
                                    player.showPlayer(LobbyMain.instance, it)
                                } else {
                                    player.hidePlayer(LobbyMain.instance, it)
                                }
                            }
                        }
                    }
                }
    }
}
