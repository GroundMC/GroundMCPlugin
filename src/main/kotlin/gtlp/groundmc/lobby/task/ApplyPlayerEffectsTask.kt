package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.Bukkit

object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 20L

    override fun run() {
        Bukkit.getOnlinePlayers().filter { it.world == LobbyMain.hubLocation.get().world }.forEach {
            it.health = 20.0
            it.saturation = 20.0f
        }
    }
}