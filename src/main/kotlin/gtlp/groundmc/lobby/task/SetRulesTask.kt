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

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import org.bukkit.Difficulty
import org.bukkit.Location

/**
 * Task to set the rules.
 * Should only be executed once.
 */
object SetRulesTask : ITask {
    override val delay = 0L
    override val period = 0L

    override fun run() {
        (Meta[Config.HUB_LOCATION] as Location).world.apply {
            difficulty = Difficulty.PEACEFUL
            setGameRuleValue("doDaylightCycle", "false")
            setGameRuleValue("doEntityDrops", "false")
            setGameRuleValue("doFireTick", "false")
            setGameRuleValue("doMobLoot", "false")
            setGameRuleValue("doMobSpawning", "false")
            setGameRuleValue("doTileDrops", "false")
            setGameRuleValue("doWeatherCycle", "false")
            setGameRuleValue("mobGriefing", "false")
            setGameRuleValue("randomTickSpeed", "0")
            setGameRuleValue("showDeathMessages", "false")
            setGameRuleValue("reducedDebugInfo", "true")
            setGameRuleValue("doWeatherCycle", "false")
        }

    }
}
