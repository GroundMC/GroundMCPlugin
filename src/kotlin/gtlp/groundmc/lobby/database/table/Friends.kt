package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.jetbrains.exposed.sql.Table

/**
 * Created by Marvin on 11.11.2016.
 */
object Friends : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java)
    val friends = blob("friends")
}