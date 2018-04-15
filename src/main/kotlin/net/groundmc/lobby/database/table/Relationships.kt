package net.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import kotlinx.coroutines.experimental.async
import net.groundmc.lobby.i18n.I18n
import net.groundmc.lobby.objects.Relationship
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Table holding relationships between players, including more information
 */
object Relationships : Table() {

    /**
     * The [UUID] of the first player in the relationship.
     * Usually the initiator.
     */
    private val userId1 = uuid("user1").references(Users.id).primaryKey().index()

    /**
     * The [UUID] of the second player in the relationship.
     */
    private val userId2 = uuid("user2").references(Users.id).primaryKey().index()

    /**
     * The timestamp at which the relationship was created.
     */
    private val since = datetime("since")

    private val relationshipCache = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .build(
                    CacheLoader.asyncReloading(RelationshipCacheLoader(), Executors.newCachedThreadPool())
            )

    class RelationshipCacheLoader : CacheLoader<UUID, List<Relationship>>() {
        override fun load(key: UUID): List<Relationship> {
            return transaction {
                return@transaction select { userId1 eq key }.also {
                    Users.getAll(it.map { it[userId2] })
                }.map {
                    Relationship(it[userId1], it[userId2], it[since])
                }
            }
        }

        override fun loadAll(keys: MutableIterable<UUID>): Map<UUID, List<Relationship>> {
            return transaction {
                return@transaction select { userId1 inList keys }
                        .groupBy { it[userId1] }
                        .mapValues {
                            it.value.map {
                                Relationship(it[userId1], it[userId2], it[since])
                            }
                        }
            }
        }
    }

    /**
     * Adds a relationship between [Relationship.user1] and [Relationship.user2]
     *
     * @param player the initiator of the relationship
     * @param relationship the relationship to add
     *
     */
    fun addRelationship(player: Player, relationship: Relationship) {
        LOGGER.entering(Relationships::class, "addRelationship", player, relationship)
        LOGGER.fine("Adding new relationship: $relationship")
        async {
            if (!areFriends(relationship.user1.uniqueId, relationship.user2.uniqueId)) {
                transaction {
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
                    commit()
                }
                relationshipCache.refresh(relationship.user1.uniqueId)
                relationshipCache.refresh(relationship.user2.uniqueId)
                player.sendMessage(I18n.getString("relationship.success", player.locale))
            } else {
                player.sendMessage(I18n.getString("relationship.exists", player.locale))
            }
            LOGGER.exiting(Relationships::class, "addRelationship")
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
    fun areFriends(player: UUID, friend: UUID): Boolean {
        LOGGER.entering(Relationships::class, "areFriends", player, friend)
        return relationshipCache[player]
                .any { it.user2.uniqueId == friend }
    }

    /**
     * Queries the database for a list of relationships of [player]
     *
     * @param player the player to query the relationships for
     *
     * @return a list of relationships of [player]
     */
    fun getRelationships(player: Player): List<Relationship> {
        LOGGER.entering(Relationships::class, "getRelationships", player)
        return relationshipCache[player.uniqueId]
    }


    /**
     * Gets the relationship between [player]  and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the friend to get the relationship for
     *
     * @return a [Relationship] object holding the relationship between
     * [player] and [friend], if any, otherwise null
     */
    fun getRelationship(player: UUID, friend: UUID): Relationship? {
        LOGGER.entering(Relationships::class, "getRelationship", player, friend)
        return relationshipCache[player].firstOrNull { it.user2.uniqueId == friend }
    }

    /**
     * Removes a relationship between [player] and [friend]
     *
     * @param player the player that initiated the relationship removal
     * @param friend the friend to remove the relationship of
     */
    fun removeRelationship(player: UUID, friend: UUID) {
        LOGGER.entering(Relationships::class, "removeRelationship", player, friend)
        if (areFriends(player, friend)) {
            transaction {
                deleteWhere { (userId1 eq player) and (userId2 eq friend) }
                deleteWhere { (userId2 eq player) and (userId1 eq friend) }
                commit()
            }
            relationshipCache.refresh(player)
            relationshipCache.refresh(friend)
        }
        LOGGER.exiting(Relationships::class, "removeRelationship")
    }

    /**
     * Queries all online friends of the [player]
     *
     * @param player the player to query the friends for
     *
     * @return a collection of friends
     */
    fun getOnlineFriends(player: Player): List<Player> {
        LOGGER.entering(Relationships::class, "getOnlineFriends", player)
        val onlineUUIDs = getOnlineUUIDs()
        return getRelationships(player).filter {
            it.user2.uniqueId in onlineUUIDs
        }.mapNotNull { it.user2.player }
    }

    /**
     * Queries all online players who are not a friend of the [player]
     *
     * @param player the player to query the non-friends for
     *
     * @return a collection of non-friends
     */
    fun getOnlineNonFriends(player: Player): List<Player> {
        LOGGER.entering(Relationships::class, "getOnlineNonFriends", player)
        val onlineFriends = getOnlineFriends(player)
        return Bukkit.getOnlinePlayers().filter { it in onlineFriends }
    }

    /**
     * Maps all the online players on the network to their [java.util.UUID].
     *
     * @return the UUIDs of all the online players on the network.
     */
    private fun getOnlineUUIDs(): List<UUID> {
        return Bukkit.getOnlinePlayers().map { it.uniqueId }
    }
}
