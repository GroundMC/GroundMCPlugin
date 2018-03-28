package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.VisibilityStates
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
            val onlinePlayers =
                    Users.getAll(Bukkit.getOnlinePlayers().map { it.uniqueId })
                            .mapKeys { Bukkit.getPlayer(it.key) }
            onlinePlayers.filterNot { it.value[Users.vanishStatus] }
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
                    .forEach { player, _ ->
                        onlinePlayers.forEach {
                            it.key.hidePlayer(LobbyMain.instance, player)
                        }
                    }
        }
    }
}
