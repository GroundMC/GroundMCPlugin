package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.database.table.queryStatistic
import gtlp.groundmc.lobby.util.I18n
import me.BukkitPVP.PointsAPI.PointsAPI
import org.apache.commons.lang.time.DurationFormatUtils
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Statistic
import org.bukkit.scoreboard.DisplaySlot
import kotlin.math.max

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
            val scoreboard = it.scoreboard
            var objective = scoreboard.getObjective("1")
            if (objective == null) {
                objective = scoreboard.registerNewObjective("1", "dummy")
            }
            objective.apply {
                if (displaySlot != DisplaySlot.SIDEBAR) {
                    displaySlot = DisplaySlot.SIDEBAR
                }
                val newDisplayName = "${ChatColor.GRAY}${it.displayName}"
                if (displayName != newDisplayName) {
                    displayName = newDisplayName
                }

                val lines = mutableListOf<String>()
                lines += ChatColor.GOLD.toString() + I18n.getString("play_time", it.locale)
                lines += ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        (it.queryStatistic(Statistic.PLAY_ONE_TICK) ?: 0) * 50L,
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
                lines += ChatColor.STRIKETHROUGH.toString() + "-".repeat(max(10, lines.map { s -> s.length }.sortedDescending().first()))

                if (lines.size != scoreboard.entries.size) {
                    scoreboard.entries.forEach(scoreboard::resetScores)
                }

                // Constraint: Entries are designed to be unique,
                // no two entries can exist with the same name,
                // one would overwrite the score of the other
                val oldEntries = scoreboard.entries.map {
                    scoreboard.getScores(it).first { it.objective == objective }
                }.associate { it.score to it }

                val newLines = lines.asReversed().withIndex()

                newLines.forEach {
                    val oldEntry = oldEntries[it.index]?.entry
                    if (oldEntry != it.value) {
                        if (oldEntry != null) {
                            scoreboard.resetScores(oldEntry)
                        }
                        getScore(it.value).score = it.index
                    }
                }
            }
        }
    }
}
