package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.enum.RelationshipLevel
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

/**
 * Table holding relationships between players, including more information
 */
object Relationships : Table() {
    private val userId1 = uuid("user1").references(Users.id).index()
    private val userId2 = uuid("user2").references(Users.id)
    private val since = datetime("since")
    private val relationshipLevel = enumeration("level", RelationshipLevel::class.java).default(RelationshipLevel.FRIEND)

    fun addRelationship(player: Player, friend: Player, relationshipLevel: RelationshipLevel = RelationshipLevel.FRIEND): String {
        return addRelationship(Relationship(player, friend, level = relationshipLevel))
    }

    fun addRelationship(relationship: Relationship): String {
        return transaction {
            val reachedRelationLimit = select { userId1.eq(relationship.user1.uniqueId).or(userId2.eq(relationship.user1.uniqueId)) }.having { relationshipLevel.eq(relationship.level) }.count() >= relationship.level.limit
            if (!areRelated(relationship.user1, relationship.user2)) {
                if (reachedRelationLimit) {
                    return@transaction I18n.getString("relationship.limit", relationship.user1.spigot().locale)
                } else {
                    insert {
                        it[userId1] = relationship.user1.uniqueId
                        it[userId2] = relationship.user2.uniqueId
                        it[since] = relationship.since
                        it[relationshipLevel] = relationship.level
                    }
                    insert {
                        it[userId1] = relationship.user2.uniqueId
                        it[userId2] = relationship.user1.uniqueId
                        it[since] = relationship.since
                        it[relationshipLevel] = relationship.level
                    }
                    return@transaction I18n.getString("relationship.success", relationship.user1.spigot().locale)
                }
            } else {
                return@transaction I18n.getString("relationship.exists", relationship.user1.spigot().locale)
            }
        }
    }

    fun updateRelationshipLevel(player: Player, friend: Player, newLevel: RelationshipLevel) {
        if (areRelated(player, friend)) {
            transaction {
                val oldLevel = select((userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId)).first()[relationshipLevel]
                update({ (userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId) }) {
                    it[relationshipLevel] = newLevel
                }
                player.sendMessage("Updated relationship from ${oldLevel.name} to ${newLevel.name}")
            }
        } else {
            player.sendMessage("You are not related to ${friend.name}")
        }
    }

    fun areRelated(player: Player, friend: Player): Boolean {
        return transaction {
            return@transaction select {
                userId1.eq(player.uniqueId).and(userId2.eq(friend.uniqueId))
            }.any()
        }
    }

    fun areRelated(player: UUID, friend: UUID): Boolean {
        return transaction {
            return@transaction select {
                userId1.eq(player).and(userId2.eq(friend))
            }.any()
        }
    }

    fun getRelationships(player: Player): Map<RelationshipLevel, Relationship> {
        return transaction {
            val friendsField = select(userId1 eq player.uniqueId)
            return@transaction mutableMapOf<RelationshipLevel, Relationship>().apply {
                for (relationship in friendsField) {
                    put(relationship[relationshipLevel], Relationship(Bukkit.getPlayer(relationship[userId1]), Bukkit.getPlayer(relationship[userId2]), relationship[since], relationship[relationshipLevel]))
                }
            }
        }
    }

}