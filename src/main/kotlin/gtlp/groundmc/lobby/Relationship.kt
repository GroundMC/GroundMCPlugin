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
