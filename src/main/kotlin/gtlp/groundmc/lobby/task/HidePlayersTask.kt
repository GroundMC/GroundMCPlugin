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
        val onlinePlayers = transaction {
            Users.select { Users.id inList Bukkit.getOnlinePlayers().map { it.uniqueId } }.toList()
        }.associateBy { Bukkit.getPlayer(it[Users.id]) }
        onlinePlayers.forEach { player, status ->
            when (status[Users.hiddenStatus]) {
                VisibilityStates.ALL -> {
                    Bukkit.getOnlinePlayers().forEach { player.showPlayer(LobbyMain.instance, it) }
                }
                VisibilityStates.NONE -> {
                    Bukkit.getOnlinePlayers().forEach { player.hidePlayer(LobbyMain.instance, it) }
                }
                VisibilityStates.FRIENDS -> {
                    onlinePlayers.forEach {
                        if (Relationships.areFriends(status[Users.id], it.value[Users.id])) {
                            player.showPlayer(LobbyMain.instance, it.key)
                        } else {
                            player.hidePlayer(LobbyMain.instance, it.key)
                        }
                    }
                }
            }
        }

        val vanishedPlayers = onlinePlayers.filter { it.value[Users.vanishStatus] }
        for (player in vanishedPlayers) {
            onlinePlayers.forEach {
                it.key.hidePlayer(LobbyMain.instance, player.key)
            }
        }
    }
}
