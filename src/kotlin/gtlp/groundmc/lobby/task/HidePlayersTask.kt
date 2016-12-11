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
            val onlinePlayers = ImmutableList.copyOf(Bukkit.getServer().onlinePlayers)
            for (player in onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] == VisibilityStates.ALL }) {
                onlinePlayers.forEach { player.showPlayer(it) }
            }
            for (player in onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] in setOf(VisibilityStates.NONE) }) {
                onlinePlayers.forEach { player.hidePlayer(it) }
            }
            for (player in onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] == VisibilityStates.FRIENDS }) {
                onlinePlayers.forEach {
                    if (Relationships.areRelated(player, it)) {
                        player.showPlayer(it)
                    } else {
                        player.hidePlayer(it)
                    }
                }
            }
            onlinePlayers.forEach {
                for (resultRow in Users.select { Users.vanishStatus eq true }) {
                    it.hidePlayer(Bukkit.getPlayer(resultRow[Users.id]))
                }
            }
        }
    }
}