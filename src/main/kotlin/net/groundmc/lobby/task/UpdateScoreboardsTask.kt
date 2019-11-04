package net.groundmc.lobby.task

import me.BukkitPVP.PointsAPI.PointsAPI
import net.groundmc.lobby.database.table.Events
import net.groundmc.lobby.database.table.Statistics
import net.groundmc.lobby.i18n.I18NStrings
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
        if (Bukkit.getOnlinePlayers().isEmpty()) {
            return
        }
        val events = Events.getCurrentEventTitles()
        Bukkit.getOnlinePlayers().forEach {
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
                lines += ChatColor.GOLD.toString() + I18NStrings.PLAY_TIME.get(it)
                lines += ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        (Statistics.getStatistic(it, Statistic.PLAY_ONE_TICK)
                                ?: 0) * 50L,
                        "HH'h':mm'm'")
                lines += ChatColor.YELLOW.toString() + I18NStrings.COMMAND_COINS_CURRENCY.get(it)
                lines += ChatColor.WHITE.toString() + PointsAPI.getPoints(it)
                lines += "${ChatColor.DARK_AQUA}Events!"
                if (events.isNotEmpty()) {
                    lines += ChatColor.GREEN.toString() + I18NStrings.EVENT_YES.get(it)
                    lines.addAll(events)
                } else {
                    lines += ChatColor.RED.toString() + I18NStrings.EVENT_NO.get(it)
                }
                lines += ChatColor.STRIKETHROUGH.toString() + "-".repeat(max(10, lines.maxBy { line -> line.length }?.length
                        ?: 0))

                if (lines.size != scoreboard.entries.size) {
                    scoreboard.entries.forEach(scoreboard::resetScores)
                }

                // Constraint: Entries are designed to be unique,
                // no two entries can exist with the same name,
                // one would overwrite the score of the other
                val oldEntries = scoreboard.entries
                        .map(this::getScore)
                        .associateBy { score -> score.score }

                lines.asReversed().forEachIndexed { index, line ->
                    val oldEntry = oldEntries[index]?.entry
                    if (oldEntry != line) {
                        if (oldEntry != null) {
                            scoreboard.resetScores(oldEntry)
                        }
                        getScore(line).score = index
                    }
                }
            }
        }
    }
}
