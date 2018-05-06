package net.groundmc.lobby.task

import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Task to update players and their change in the visibility state.
 */
object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        transaction {
            val players = Bukkit.getOnlinePlayers()
            val onlinePlayers =
                    Users.getAll(players.map { it.uniqueId })
                            .mapKeys { Bukkit.getPlayer(it.key) }
            onlinePlayers.forEach { player, status ->
                when (status[Users.vanishStatus]) {
                    true -> players.forEach {
                        it.hidePlayer(LobbyMain.instance, player)
                    }
                    false -> when (status[Users.hiddenStatus]) {
                        VisibilityStates.ALL -> {
                            players.forEach { player.showPlayer(LobbyMain.instance, it) }
                        }
                        VisibilityStates.NONE -> {
                            players.forEach { player.hidePlayer(LobbyMain.instance, it) }
                        }
                        VisibilityStates.FRIENDS -> {
                            players.forEach {
                                when (Relationships.areFriends(player, it)) {
                                    true -> player.showPlayer(LobbyMain.instance, it)
                                    false -> player.hidePlayer(LobbyMain.instance, it)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
