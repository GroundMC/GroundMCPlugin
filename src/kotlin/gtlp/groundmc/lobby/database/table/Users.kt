package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime

/**
 * Table to hold players' settings and friends
 */
object Users : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
    val vanishStatus = bool("vanish_status").default(false)
    val coins = long("coins").default(0)
    val lastDailyCoinsDate = date("lastDailyCoins").default(DateTime.parse("1970-01-01"))
}