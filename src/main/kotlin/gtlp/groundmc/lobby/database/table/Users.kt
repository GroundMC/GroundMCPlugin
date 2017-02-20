package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
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
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val lastName = text("last_name").default("<no name>")
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
    val vanishStatus = bool("vanish_status").default(false)
    val coins = long("coins").default(0)
    val lastDailyCoinsDate = date("lastDailyCoins").default(DateTime.parse("1970-01-01"))

    fun getPlayer(player: Player): ResultRow {
        return transaction {
            return@transaction Users.select(Users.id eq player.uniqueId).first()
        }
    }

    fun getPlayer(uuid: UUID): ResultRow {
        return transaction {
            return@transaction Users.select(Users.id eq uuid).first()
        }
    }

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