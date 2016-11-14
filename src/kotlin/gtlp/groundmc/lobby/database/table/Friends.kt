package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.jetbrains.exposed.sql.Table

/**
 * Table to hold players' settings and friends
 */
object Friends : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
}