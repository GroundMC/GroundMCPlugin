package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.util.I18n
import org.apache.commons.lang.time.DurationFormatUtils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Statistic
import org.bukkit.scoreboard.DisplaySlot

object UpdateScoreboardsTask : ITask {
    override val delay = 20L
    override val period = 20L

    override fun run() {
        Bukkit.getServer().onlinePlayers.forEach {
            val scoreboard = Bukkit.getScoreboardManager().newScoreboard
            scoreboard.registerNewObjective("1", "dummy").apply {
                displaySlot = DisplaySlot.SIDEBAR
                displayName = "${ChatColor.GRAY}${it.displayName}"

                val lines = mutableListOf<String>()
                lines += ChatColor.GOLD.toString() + I18n.getString("play_time", it.locale)
                lines += ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        it.getStatistic(Statistic.PLAY_ONE_TICK) * 50L,
                        "HH:mm")
                lines += ChatColor.WHITE.toString() + I18n.getString("command.coins.currency", it.locale)
                lines += ChatColor.YELLOW.toString() + Users.getPlayer(it)[Users.coins]
                lines += "${ChatColor.DARK_AQUA}Events!"
                lines += "${ChatColor.GREEN}JA!"
                Events.getCurrentEventTitles().forEach { lines += it }

                var score = 0
                lines.asReversed().forEach {
                    getScore(it).score = score++
                }

            }
            it.scoreboard = scoreboard
        }
    }
}

