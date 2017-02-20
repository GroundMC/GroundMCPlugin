package gtlp.groundmc.lobby.task

import com.google.common.collect.ImmutableList
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enum.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        transaction {
            val onlinePlayers = Users.select { Users.id inList ImmutableList.copyOf(Bukkit.getOnlinePlayers().map { it.uniqueId }) }.groupBy(Users.id)
            onlinePlayers.filter { it[Users.hiddenStatus] == VisibilityStates.ALL }.forEach { player -> onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).showPlayer(Bukkit.getPlayer(it[Users.id])) } }
            onlinePlayers.filter { it[Users.hiddenStatus] == VisibilityStates.NONE }.forEach { player -> onlinePlayers.forEach { Bukkit.getPlayer(player[Users.id]).hidePlayer(Bukkit.getPlayer(it[Users.id])) } }
            onlinePlayers.filter { it[Users.hiddenStatus] == VisibilityStates.FRIENDS }.forEach { player ->
                onlinePlayers.forEach {
                    if (Relationships.areRelated(player[Users.id], it[Users.id])) {
                        Bukkit.getPlayer(player[Users.id]).showPlayer(Bukkit.getPlayer(it[Users.id]))
                    } else {
                        Bukkit.getPlayer(player[Users.id]).hidePlayer(Bukkit.getPlayer(it[Users.id]))
                    }
                }
            }
            for (player in Users.select { Users.vanishStatus eq true }) {
                onlinePlayers.forEach {
                    Bukkit.getPlayer(it[Users.id]).hidePlayer(Bukkit.getPlayer(player[Users.id]))
                }
            }
        }
    }
}