package gtlp.groundmc.lobby.task

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
                getScore("${ChatColor.GOLD}Spielzeit").score = 5
                getScore(ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        it.getStatistic(Statistic.PLAY_ONE_TICK) * 50L,
                        "HH:mm")).score = 4
                getScore("${ChatColor.WHITE}Coming Soon!").score = 3
                getScore("${ChatColor.DARK_AQUA}Event!").score = 2
                getScore("${ChatColor.GREEN}JA!").score = 1
            }
            it.scoreboard = scoreboard
        }
    }
}

