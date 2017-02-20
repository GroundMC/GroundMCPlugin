package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.database.table.Users
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.joda.time.DateTime
import java.util.*

/**
 * Class holding a relationship
 */
class Relationship constructor(val user1: OfflinePlayer, val user2: OfflinePlayer, val since: DateTime = DateTime.now()) {

    constructor(user1Name: String, user2Name: String, since: DateTime = DateTime.now()) : this(Users.byName(user1Name)!![Users.id], Users.byName(user2Name)!![Users.id], since)
    constructor(user1Id: UUID, user2Id: UUID, since: DateTime = DateTime.now()) : this(Bukkit.getOfflinePlayer(user1Id), Bukkit.getOfflinePlayer(user2Id), since)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Relationship

        if (user1 != other.user1) return false
        if (user2 != other.user2) return false
        if (since != other.since) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user1.hashCode()
        result = 31 * result + user2.hashCode()
        result = 31 * result + since.hashCode()
        return result
    }

    override fun toString(): String {
        return "Relationship(user1=$user1, user2=$user2, since=$since)"
    }
}