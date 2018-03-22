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
     * Queries the database for the [ResultRow] of the [player] based on [Player.getUniqueId]
     *
     * @param player the player to query the database for
     * @return a row that contains all the columns defined in this class
     */
    fun getPlayer(player: Player) = transaction {
        return@transaction Users.select(Users.id eq player.uniqueId).first()
    }

    /**
     * Queries the database for the [ResultRow] of a player based on the [UUID]
     *
     * @param uuid the id to query the database for
     * @return a row that contains all the columns defined in this class
     */
    fun getPlayer(uuid: UUID) = transaction {
        return@transaction Users.select(Users.id eq uuid).first()
    }

    /**
     * Queries the database for a [ResultRow] by the last name of a player
     *
     * @param name the name to query the database for
     * @return the row that contains all the columns defined in this class or
     * `null`, if there is no player with the given [name]
     */
    fun byName(name: String) = try {
        transaction {
            return@transaction select { lastName eq name }.first()
        }
    } catch (ex: NoSuchElementException) {
        null
    }
}
