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

package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.database.table.Users
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.joda.time.DateTime
import java.io.Serializable
import java.util.*

/**
 * Class holding a relationship
 */
data class Relationship constructor(
        /**
         * The first user of this relationship.
         * Usually the initiator.
         */
        val user1: OfflinePlayer,

        /**
         * The second user of this relationship.
         */
        val user2: OfflinePlayer,

        /**
         * The time at which this relationship was created.
         */
        val since: DateTime = DateTime.now()
) : Serializable {

    /**
     * The constructor to create a [Relationship] out of two usernames.
     */
    constructor(user1Name: String, user2Name: String, since: DateTime = DateTime.now()) : this(Users.byName(user1Name)!![Users.id], Users.byName(user2Name)!![Users.id], since)

    /**
     * The constructor to create a [Relationship] out of two users' [UUID]s.
     */
    constructor(user1Id: UUID, user2Id: UUID, since: DateTime = DateTime.now()) : this(Bukkit.getOfflinePlayer(user1Id), Bukkit.getOfflinePlayer(user2Id), since)

}
