package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import de.dytanic.cloudnet.api.CloudAPI
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
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
    private val userId1 = uuid("user1").references(Users.id).primaryKey()

    /**
     * The [UUID] of the second player in the relationship.
     */
    private val userId2 = uuid("user2").references(Users.id).primaryKey()

    /**
     * The timestamp at which the relationship was created.
     */
    private val since = datetime("since")

    private val relationshipCache = CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS).build(
                    CacheLoader.asyncReloading(RelationshipCacheLoader(), Executors.newCachedThreadPool())
            )

    class RelationshipCacheLoader : CacheLoader<UUID, List<Relationship>>() {
        override fun load(key: UUID): List<Relationship> {
            return transaction {
                return@transaction select { userId1 eq key }
                        .map {
                            Relationship(it[userId1], it[userId2], it[since])
                        }
            }
        }

        override fun loadAll(keys: MutableIterable<UUID>): MutableMap<UUID, List<Relationship>> {
            return transaction {
                return@transaction select { userId1 inList keys }
                        .groupBy { it[userId1] }
                        .mapValues {
                            it.value.map {
                                Relationship(it[userId1], it[userId2], it[since])
                            }
                        }
                        .toMutableMap()
            }
        }
    }

    /**
     * Adds a relationship between [player] and [friend]
     *
     * @param player the player that initiated the relationship
     * @param friend the friend to add the relationship to
     *
     * @see addRelationship
     */
    fun addRelationship(player: Player, friend: OfflinePlayer) {
        addRelationship(player, Relationship(player.uniqueId, friend.uniqueId))
    }

    /**
     * Adds a relationship between [Relationship.user1] and [Relationship.user2]
     *
     * @param player the initiator of the relationship
     * @param relationship the relationship to add
     *
     * @see addRelationship
     */
    private fun addRelationship(player: Player, relationship: Relationship) {
        LobbyMain.logger.entering(Relationships::class, "addRelationship")
        LobbyMain.logger.fine("Adding new relationship: $relationship")
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
            }
            relationshipCache.refresh(relationship.user1.uniqueId)
            relationshipCache.refresh(relationship.user2.uniqueId)
            player.sendMessage(I18n.getString("relationship.success", player.locale))
        } else {
            player.sendMessage(I18n.getString("relationship.exists", player.locale))
        }
        LobbyMain.logger.exiting(Relationships::class, "addRelationship")
    }

    /**
     * Queries the database for a relationship between [player] and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the possible friend of [player]
     *
     * @return whether there exists a relationship between [player] and [friend]
     */
    fun areFriends(player: OfflinePlayer, friend: OfflinePlayer): Boolean {
        LobbyMain.logger.entering(Relationships::class, "areFriends")
        return areFriends(player.uniqueId, friend.uniqueId)
    }

    /**
     * Queries the database for a relationship between [player] and [friend]
     *
     * @param player the player to query the relationship for
     * @param friend the possible friend of [player]
     *
     * @return whether there exists a relationship between [player] and [friend]
     *
     * @see areFriends
     */
    fun areFriends(player: UUID, friend: UUID): Boolean {
        LobbyMain.logger.entering(Relationships::class, "areFriends")
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
        LobbyMain.logger.entering(Relationships::class, "getRelationships")
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
    fun getRelationship(player: OfflinePlayer, friend: OfflinePlayer): Relationship? {
        LobbyMain.logger.entering(Relationships::class, "getRelationship")
        return getRelationship(player.uniqueId, friend.uniqueId)
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
        LobbyMain.logger.entering(Relationships::class, "getRelationship")
        return relationshipCache[player].firstOrNull { it.user2.uniqueId == friend }
    }

    /**
     * Removes a relationship between [player] and [friend]
     *
     * @param player the player that initiated the relationship removal
     * @param friend the friend to remove the relationship of
     */
    fun removeRelationship(player: Player, friend: OfflinePlayer) {
        LobbyMain.logger.entering(Relationships::class, "removeRelationship")
        val relationship = getRelationship(player, friend)
        if (relationship != null) {
            transaction {
                deleteWhere { (userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId) }
                deleteWhere { (userId2 eq player.uniqueId) and (userId1 eq friend.uniqueId) }
                commit()
            }
            relationshipCache.refresh(player.uniqueId)
            relationshipCache.refresh(friend.uniqueId)
        }
    }

    /**
     * Queries all online friends of the [player]
     *
     * @param player the player to query the friends for
     *
     * @return a collection of friends
     */
    fun getOnlineFriends(player: Player): List<Player> {
        LobbyMain.logger.entering(Relationships::class, "getOnlineFriends")
        val onlineUUIDs = getOnlineUUIDs()
        return relationshipCache[player.uniqueId].filter {
            it.user2.uniqueId in onlineUUIDs
        }.map { it.user2.player }
    }

    /**
     * Queries all online players who are not a friend of the [player]
     *
     * @param player the player to query the non-friends for
     *
     * @return a collection of non-friends
     */
    fun getOnlineNonFriends(player: Player): List<Player> {
        LobbyMain.logger.entering(Relationships::class, "getOnlineFriends")
        val onlineFriends = getOnlineFriends(player)
        return Bukkit.getOnlinePlayers().filter {
            it in onlineFriends
        }
    }

    /**
     * Maps all the online players on the network to their [java.util.UUID].
     *
     * @return the UUIDs of all the online players on the network.
     */
    private fun getOnlineUUIDs(): List<UUID> {
        return CloudAPI.getInstance().onlinePlayers.map { it.uniqueId }
    }
}
