package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.enum.RelationshipLevel
import org.bukkit.entity.Player
import org.joda.time.DateTime

/**
 * Class holding a relationship
 */
class Relationship(val user1: Player, val user2: Player, val since: DateTime = DateTime.now(), val level: RelationshipLevel = RelationshipLevel.KNOWN) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Relationship

        if (user1 != other.user1) return false
        if (user2 != other.user2) return false
        if (since != other.since) return false
        if (level != other.level) return false

        return true
    }

    override fun hashCode(): Int {
        var result = user1.hashCode()
        result = 31 * result + user2.hashCode()
        result = 31 * result + since.hashCode()
        result = 31 * result + level.hashCode()
        return result
    }
}