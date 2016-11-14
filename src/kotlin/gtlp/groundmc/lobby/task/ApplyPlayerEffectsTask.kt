package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.Bukkit
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object ApplyPlayerEffectsTask : Runnable {
    override fun run() {
        Bukkit.getServer().onlinePlayers.filter { it.world == LobbyMain.hubWorld }.forEach {
            it.addPotionEffect(PotionEffect(PotionEffectType.REGENERATION, 200, 1, false, false), true)
            it.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, 200, 1, false, false), true)
        }
    }
}