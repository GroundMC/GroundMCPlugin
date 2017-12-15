package gtlp.groundmc.lobby.database.table.legacy

import gtlp.groundmc.lobby.enums.VisibilityStates
import org.jetbrains.exposed.sql.Table
import org.joda.time.DateTime
import java.util.*

/**
 * Table to hold players' settings and more data
 */
object Users0 : Table("Users") {
    /**
     * The [UUID] of the player
     */
    val id = uuid("playerId").primaryKey()

    /**
     * The last name with which this player has been seen
     */
    val lastName = text("last_name")

    /**
     * Whether the chat is silent for this player or not
     */
    val silentStatus = bool("silent_status").default(false)

    /**
     * One of the [VisibilityStates] visibility settings
     */
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)

    /**
     * Whether this player is vanished or not
     */
    val vanishStatus = bool("vanish_status").default(false)

    /**
     * The last date at which the player has received daily coins (does not accumulate)
     */
    val lastDailyCoinsDate = date("lastDailyCoins").default(DateTime.parse("1970-01-01"))

    /**
     * The amount of coins this player has
     */
    val coins = integer("coins").default(0)
}
