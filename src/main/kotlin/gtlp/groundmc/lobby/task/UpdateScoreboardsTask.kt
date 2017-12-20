package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.aggregateStatistic
import me.BukkitPVP.PointsAPI.PointsAPI
import org.apache.commons.lang.time.DurationFormatUtils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Statistic
import org.bukkit.scoreboard.DisplaySlot

/**
 * Task to regularly update the player's scoreboard with information about their
 * play time, owned coins and currently active events.
 */
object UpdateScoreboardsTask : ITask {
    override val delay = 20L
    override val period = 20L

    override fun run() {
        val events = Events.getCurrentEventTitles()
        Bukkit.getServer().onlinePlayers.forEach {
            val scoreboard = Bukkit.getScoreboardManager().newScoreboard
            scoreboard.registerNewObjective("1", "dummy").apply {
                displaySlot = DisplaySlot.SIDEBAR
                displayName = "${ChatColor.GRAY}${it.displayName}"

                val lines = mutableListOf<String>()
                lines += ChatColor.GOLD.toString() + I18n.getString("play_time", it.locale)
                lines += ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        (it.aggregateStatistic(Statistic.PLAY_ONE_TICK) ?: 0) * 50L,
                        "HH'h':mm'm'")
                lines += ChatColor.YELLOW.toString() + I18n.getString("command.coins.currency", it.locale)
                lines += ChatColor.WHITE.toString() + PointsAPI.getPoints(it)
                lines += "${ChatColor.DARK_AQUA}Events!"
                if (events.isNotEmpty()) {
                    lines += ChatColor.GREEN.toString() + I18n.getString("event.yes", it.locale)
                    lines.addAll(events)
                } else {
                    lines += ChatColor.RED.toString() + I18n.getString("event.no", it.locale)
                }
                lines += "-".repeat(12)

                var score = 0
                lines.asReversed().forEach {
                    getScore(it).score = score++
                }

            }
            it.scoreboard = scoreboard
        }
    }
}