package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import org.bukkit.Bukkit
import org.bukkit.Location

/**
 * Task to apply effects to players in the lobby world.
 */
object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 20L

    override fun run() {
        Bukkit.getOnlinePlayers().filter { it.world == (Meta[Config.HUB_LOCATION] as Location).world }.forEach {
            it.health = 20.0
            it.saturation = 20.0f
        }
    }
}
