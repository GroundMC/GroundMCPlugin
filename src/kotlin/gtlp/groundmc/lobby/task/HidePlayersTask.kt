package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enum.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object HidePlayersTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        transaction {
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] == VisibilityStates.ALL }) {
                Bukkit.getServer().onlinePlayers.forEach { player.showPlayer(it) }
            }
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] in setOf(VisibilityStates.NONE) }) {
                Bukkit.getServer().onlinePlayers.forEach { player.hidePlayer(it) }
            }
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(it.uniqueId) }.first()[Users.hiddenStatus] == VisibilityStates.FRIENDS }) {
                Bukkit.getServer().onlinePlayers.forEach {
                    if (Relationships.areRelated(player, it)) {
                        player.showPlayer(it)
                    } else {
                        player.hidePlayer(it)
                    }
                }
            }
            Bukkit.getServer().onlinePlayers.forEach {
                for (resultRow in Users.select { Users.vanishStatus eq true }) {
                    it.hidePlayer(Bukkit.getPlayer(resultRow[Users.id]))
                }
            }
        }
    }
}