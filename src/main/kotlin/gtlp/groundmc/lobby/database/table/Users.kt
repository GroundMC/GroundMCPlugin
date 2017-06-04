package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enums.VisibilityStates
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.util.*

/**
 * Table to hold players' settings and more data
 */
object Users : Table() {
    /**
     * The [UUID] of the player
     */
    val id = uuid("playerId").primaryKey().uniqueIndex()

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
     * The amount of coins this player has
     */
    val coins = long("coins").default(0)

    /**
     * The last date at which the player has received daily coins (does not accumulate)
     */
    val lastDailyCoinsDate = date("lastDailyCoins").default(DateTime.parse("1970-01-01"))

    /**
     * Queries the database for the [ResultRow] of the [player] based on [Player.getUniqueId]
     *
     * @param player the player to query the database for
     * @return a row that contains all the columns defined in this class
     */
    fun getPlayer(player: Player): ResultRow {
        return transaction {
            return@transaction Users.select(Users.id eq player.uniqueId).first()
        }
    }

    /**
     * Queries the database for the [ResultRow] of a player based on the [UUID]
     *
     * @param uuid the id to query the database for
     * @return a row that contains all the columns defined in this class
     */
    fun getPlayer(uuid: UUID): ResultRow {
        return transaction {
            return@transaction Users.select(Users.id eq uuid).first()
        }
    }

    /**
     * Queries the database for a [ResultRow] by the last name of a player
     *
     * @param name the name to query the database for
     * @return the row that contains all the columns defined in this class or
     * `null`, if there is no player with the given [name]
     */
    fun byName(name: String): ResultRow? {
        try {
            return transaction {
                return@transaction select { lastName eq name }.first()
            }
        } catch (ex: NoSuchElementException) {
            return null
        }
    }
}
