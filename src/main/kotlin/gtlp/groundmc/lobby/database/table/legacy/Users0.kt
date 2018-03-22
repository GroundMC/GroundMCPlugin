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
