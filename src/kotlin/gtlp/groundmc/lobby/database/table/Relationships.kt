package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.OfflinePlayer
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

    /**
     * Adds a relationship between [player] and [friend]
     *
     * @param player the player that initiated the relationship
     * @param friend the friend to add the relationship to
     *
     * @see addRelationship
     */
    fun addRelationship(player: Player, friend: Player) {
        addRelationship(Relationship(player, friend))
    }

    /**
     * Adds a relationship between [Relationship.user1] and [Relationship.user2]
     *
     * @param relationship the relationship to add
     *
     * @see addRelationship
     */
    fun addRelationship(relationship: Relationship) {
        return transaction {
            if (!areRelated(relationship.user1, relationship.user2)) {

                insert {
                    it[userId1] = relationship.user1.uniqueId
                    it[userId2] = relationship.user2.uniqueId
                    it[since] = relationship.since
                }
                insert {
                    it[userId1] = relationship.user2.uniqueId
                    it[userId2] = relationship.user1.uniqueId
                    it[since] = relationship.since
                }
                if (relationship.user1 is Player) {
                    relationship.user1.sendMessage(I18n.getString("relationship.success", relationship.user1.spigot().locale))
                }
            } else if (relationship.user1 is Player) {
                relationship.user1.sendMessage(I18n.getString("relationship.exists", relationship.user1.spigot().locale))
            }
        }
    }

    /**
     * Queries the database for a relationship between [player] and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the possible friend of [player]
     *
     * @return whether there exists a relationship between [player] and [friend]
     */
    fun areRelated(player: OfflinePlayer, friend: OfflinePlayer): Boolean {
        return transaction {
            return@transaction select {
                userId1.eq(player.uniqueId).and(userId2.eq(friend.uniqueId))
            }.any()
        }
    }

    /**
     * Queries the database for a relationship between [player] and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the possible friend of [player]
     *
     * @return whether there exists a relationship between [player] and [friend]
     *
     * @see areRelated
     */
    fun areRelated(player: UUID, friend: UUID): Boolean {
        return transaction {
            return@transaction select {
                userId1.eq(player).and(userId2.eq(friend))
            }.any()
        }
    }

    /**
     * Queries the database for a relationships of [player]
     *
     * @param player the player to query the relationships for
     *
     * @return a list of relationships of [player]
     */
    fun getRelationships(player: Player): List<Relationship> {
        return transaction {
            val friendsField = select(userId1 eq player.uniqueId)
            return@transaction mutableListOf<Relationship>().apply {
                for (relationship in friendsField) {
                    add(Relationship(relationship[userId1], relationship[userId2], relationship[since]))
                }
            }
        }
    }


    /**
     * Gets the relationship between [player]  and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the friend to get the relationship for
     *
     * @return a [Relationship] object holding the relationship between [player] and [friend], if any, otherwise null
     */
    fun getRelationship(player: OfflinePlayer, friend: OfflinePlayer): Relationship? {
        return transaction {
            val relationship = select((userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId))
            if (relationship.any()) {
                return@transaction Relationship(player, friend, relationship.first()[since])
            }
            return@transaction null
        }
    }

    /**
     * Gets the relationship between [player]  and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the friend to get the relationship for
     *
     * @return a [Relationship] object holding the relationship between [player] and [friend], if any, otherwise null
     */
    fun getRelationship(player: UUID, friend: UUID): Relationship? {
        return transaction {
            val relationship = select((userId1 eq player) and (userId2 eq friend))
            if (relationship.any()) {
                return@transaction Relationship(player, friend, relationship.first()[since])
            }
            return@transaction null
        }
    }

    /**
     * Removes a relationship between [player] and [friend]
     *
     * @param player the player that initiated the relationship removal
     * @param friend the friend to remove the relationship of
     */
    fun removeRelationship(player: Player, friend: OfflinePlayer) {
        transaction {
            val relationship = select((userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId))
            if (relationship.any()) {
                deleteWhere { (userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId) }
                deleteWhere { (userId2 eq player.uniqueId) and (userId1 eq friend.uniqueId) }
            }
        }
    }
}