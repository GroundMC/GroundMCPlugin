package net.groundmc.lobby.task

import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import org.bukkit.Bukkit

/**
 * Task to apply effects to players in the lobby world.
 */
object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 20L

    override fun run() {
        Bukkit.getOnlinePlayers().filter { it.world == Meta[Config.HUB_LOCATION]?.world }.forEach {
            it.health = 20.0
            it.saturation = 20.0f
            it.foodLevel = 20
            it.exhaustion = 0.0f
            it.activePotionEffects.forEach { effect -> it.removePotionEffect(effect.type) }
        }
    }
}
