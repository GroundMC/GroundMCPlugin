package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Friends
import gtlp.groundmc.lobby.enum.VisibilityStates
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Created by Marv1 on 14.11.2016.
 */
object HidePlayersTask : Runnable {
    override fun run() {
        transaction {
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(it.uniqueId) }.first()[Friends.hiddenStatus] == VisibilityStates.ALL }) {
                Bukkit.getServer().onlinePlayers.forEach { player.showPlayer(it) }
            }
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(it.uniqueId) }.first()[Friends.hiddenStatus] in setOf(VisibilityStates.NONE) }) {
                Bukkit.getServer().onlinePlayers.forEach { player.hidePlayer(it) }
            }
            for (player in Bukkit.getServer().onlinePlayers.filter { gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(it.uniqueId) }.first()[Friends.hiddenStatus] == VisibilityStates.FRIENDS }) {
                Bukkit.getServer().onlinePlayers.forEach {
                    if (Friends.areFriends(player, it)) {
                        player.showPlayer(it)
                    } else {
                        player.hidePlayer(it)
                    }
                }
            }
        }
    }
}