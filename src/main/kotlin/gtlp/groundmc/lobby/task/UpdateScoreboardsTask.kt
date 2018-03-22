/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.database.table.Statistics
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
                lines += ChatColor.GOLD.toString() + I18n.getString("play_time", it.locale)
                lines += ChatColor.WHITE.toString() + DurationFormatUtils.formatDuration(
                        (Statistics.getStatistic(it, Statistic.PLAY_ONE_TICK)
                                ?: 0) * 50L,
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
