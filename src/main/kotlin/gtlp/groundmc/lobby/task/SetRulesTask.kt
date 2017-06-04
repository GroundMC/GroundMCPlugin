package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.LobbyMain

/**
 * Task to set the rules.
 * Should only be executed once.
 */
object SetRulesTask : ITask {
    override val delay = 0L
    override val period = 0L

    override fun run() {
        LobbyMain.hubLocation.get().world.apply {
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
        }

    }
}
