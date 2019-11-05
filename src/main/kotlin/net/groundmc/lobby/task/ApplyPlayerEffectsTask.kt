package net.groundmc.lobby.task

import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.Config
import org.bukkit.Bukkit
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * Task to apply effects to players in the lobby world.
 */
object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 40L

    override fun run() {
        val players = Bukkit.getOnlinePlayers().filter { it.world == Meta[Config.HUB_LOCATION]?.world }
        players.forEach {
            it.health = 20.0
            it.saturation = 20.0f
            it.foodLevel = 20
            it.exhaustion = 0.0f
            it.activePotionEffects.forEach { effect -> it.removePotionEffect(effect.type) }
        }
        transaction(LobbyMain.instance.database) {
            players.forEach { player ->
                Users.update({ Users.id eq player.uniqueId }) {
                    it[lastLocation] = player.location
                }
            }
            commit()
            Users.invalidateAll(players)
        }
    }
}
