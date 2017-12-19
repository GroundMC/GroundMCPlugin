package gtlp.groundmc.lobby.task

import com.google.common.collect.ImmutableList
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
            Users.select { Users.id inList ImmutableList.copyOf(Bukkit.getOnlinePlayers().map { it.uniqueId }) }.toList()
        }
        onlinePlayers.forEach { player ->
            when (player[Users.hiddenStatus]) {
                VisibilityStates.ALL -> {
                    onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).showPlayer(LobbyMain.instance, Bukkit.getPlayer(it[Users.id])) }
                }

                VisibilityStates.NONE -> {
                    onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).hidePlayer(LobbyMain.instance, Bukkit.getPlayer(it[Users.id])) }
                }
                VisibilityStates.FRIENDS -> {
                    onlinePlayers.forEach {
                        if (Relationships.areFriends(player[Users.id], it[Users.id])) {
                            Bukkit.getPlayer(player[Users.id]).showPlayer(LobbyMain.instance, Bukkit.getPlayer(it[Users.id]))
                        } else {
                            Bukkit.getPlayer(player[Users.id]).hidePlayer(LobbyMain.instance, Bukkit.getPlayer(it[Users.id]))
                        }
                    }
                }
            }
        }

        val vanishedPlayers = transaction {
            Users.select { Users.vanishStatus eq true }.toList()
        }
        for (player in vanishedPlayers) {
            onlinePlayers.forEach {
                Bukkit.getPlayer(it[Users.id])?.hidePlayer(LobbyMain.instance, Bukkit.getPlayer(player[Users.id]))
            }
        }
    }
}
