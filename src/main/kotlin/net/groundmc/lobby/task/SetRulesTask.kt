package net.groundmc.lobby.task

import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
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
