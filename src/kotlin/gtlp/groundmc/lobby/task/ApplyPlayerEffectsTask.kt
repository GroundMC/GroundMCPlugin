package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.Bukkit

object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 20L

    override fun run() {
        Bukkit.getServer().onlinePlayers.filter { it.world == LobbyMain.hubWorld }.forEach {
            it.health = 20.0
            it.saturation = 20.0f
        }
    }
}