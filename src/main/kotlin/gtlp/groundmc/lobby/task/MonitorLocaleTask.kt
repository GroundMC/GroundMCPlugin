package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.event.PlayerChangeLocaleEvent
import gtlp.groundmc.lobby.util.I18nUtils
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

object MonitorLocaleTask : ITask {
    override val delay = 10L
    override val period = 40L

    private val playerLocaleMap = mutableMapOf<Player, Locale>().withDefault { Locale.ENGLISH }

    override fun run() {
        Bukkit.getServer().onlinePlayers.forEach {
            val locale = I18nUtils.getLocaleFromCommandSender(it)
            if (locale != playerLocaleMap[it]) {
                playerLocaleMap[it] = locale
                Bukkit.getServer().pluginManager.callEvent(PlayerChangeLocaleEvent(it))
            }
        }
    }
}
