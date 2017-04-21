package gtlp.groundmc.lobby.task

import com.google.common.collect.ImmutableList
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        val onlinePlayers = transaction {
            return@transaction mutableListOf<ResultRow>().apply {
                addAll(Users.select { Users.id inList ImmutableList.copyOf(Bukkit.getOnlinePlayers().map { it.uniqueId }) }.groupBy(Users.id))
            }
        }
        onlinePlayers.forEach { player ->
            when (player[Users.hiddenStatus]) {
                VisibilityStates.ALL -> {
                    onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).showPlayer(Bukkit.getPlayer(it[Users.id])) }
                }

                VisibilityStates.NONE -> {
                    onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).hidePlayer(Bukkit.getPlayer(it[Users.id])) }
                }
                VisibilityStates.FRIENDS -> {
                    onlinePlayers.forEach {
                        if (Relationships.areFriends(player[Users.id], it[Users.id])) {
                            Bukkit.getPlayer(player[Users.id]).showPlayer(Bukkit.getPlayer(it[Users.id]))
                        } else {
                            Bukkit.getPlayer(player[Users.id]).hidePlayer(Bukkit.getPlayer(it[Users.id]))
                        }
                    }
                }
            }
        }

        val vanishedPlayers = transaction {
            return@transaction mutableListOf<ResultRow>().apply {
                addAll(Users.select { Users.vanishStatus eq true })
            }
        }
        for (player in vanishedPlayers) {
            onlinePlayers.forEach {
                Bukkit.getPlayer(it[Users.id]).hidePlayer(Bukkit.getPlayer(player[Users.id]))
            }
        }
    }
}