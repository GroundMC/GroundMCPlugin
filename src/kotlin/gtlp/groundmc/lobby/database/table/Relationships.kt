package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.enum.RelationshipLevel
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Table holding relationships between players, including more information
 */
object Relationships : Table() {
    private val userId1 = uuid("user1").references(Friends.id).index()
    private val userId2 = uuid("user2").references(Friends.id).index()
    private val initiatorId = uuid("initUser").references(Friends.id)
    private val since = datetime("since")
    private val relationshipLevel = enumeration("level", RelationshipLevel::class.java).default(RelationshipLevel.FRIEND)

    fun addRelationship(player: Player, friend: Player, relationshipLevel: RelationshipLevel = RelationshipLevel.FRIEND): String {
        return addRelationship(Relationship(player, friend, level = relationshipLevel))
    }

    fun addRelationship(relationship: Relationship): String {
        transaction {
            val reachedRelationLimit = Relationships.select { userId1.eq(relationship.user1.uniqueId).or(userId2.eq(relationship.user1.uniqueId)) }.having { relationshipLevel.eq(relationship.level) }.count() >= relationship.level.limit
            if (!areRelated(relationship.user1, relationship.user2)) {
                if (reachedRelationLimit) {
                    return@transaction I18n.getString("relationship.limit", relationship.user1.spigot().locale)
                } else {
                    Relationships.insert {
                        it[userId1] = relationship.user1.uniqueId
                        it[userId2] = relationship.user2.uniqueId
                        it[initiatorId] = relationship.user1.uniqueId
                        it[since] = relationship.since
                        it[relationshipLevel] = relationship.level
                    }
                    commit()
                    return@transaction I18n.getString("relationship.success", relationship.user1.spigot().locale)
                }
            } else {
                return@transaction I18n.getString("relationship.exists", relationship.user1.spigot().locale)
            }
        }
        return I18n.getString("unknown_error", relationship.user1.spigot().locale)
    }

    fun updateRelationship() {
        //TODO
    }

    fun areRelated(player: Player, friend: Player): Boolean {
        return Relationships.select {
            userId1.eq(player.uniqueId).and(userId2.eq(friend.uniqueId))
                    .or(userId1.eq(friend.uniqueId).and(userId2.eq(player.uniqueId)))
        }.count() > 0
    }
}