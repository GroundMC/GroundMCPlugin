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

package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
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
    private fun addRelationship(relationship: Relationship) {
        LobbyMain.logger.entering(Relationships::class, "addRelationship")
        LobbyMain.logger.fine("Adding new relationship: $relationship")
        transaction {
            if (!areFriends(relationship.user1, relationship.user2)) {
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
                    relationship.user1.sendMessage(I18n.getString("relationship.success", relationship.user1.locale))
                }
            } else if (relationship.user1 is Player) {
                relationship.user1.sendMessage(I18n.getString("relationship.exists", relationship.user1.locale))
            }
            LobbyMain.logger.exiting(Relationships::class, "addRelationship")
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
    fun areFriends(player: OfflinePlayer, friend: OfflinePlayer): Boolean {
        LobbyMain.logger.entering(Relationships::class, "areFriends")
        return transaction {
            return@transaction select {
                (userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId)
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
     * @see areFriends
     */
    fun areFriends(player: UUID, friend: UUID): Boolean {
        LobbyMain.logger.entering(Relationships::class, "areFriends")
        return transaction {
            return@transaction select {
                (userId1 eq player) and (userId2 eq friend)
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
        LobbyMain.logger.entering(Relationships::class, "getRelationships")
        LobbyMain.logger.finest("Getting relationships for ${player.name}...")
        return transaction {
            return@transaction select(userId1 eq player.uniqueId)
                    .map { Relationship(it[userId1], it[userId2], it[since]) }
        }
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
     * @return a [Relationship] object holding the relationship between
     * [player] and [friend], if any, otherwise null
     */
    fun getRelationship(player: UUID, friend: UUID): Relationship? {
        LobbyMain.logger.entering(Relationships::class, "getRelationship")
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
        LobbyMain.logger.entering(Relationships::class, "removeRelationship")
        transaction {
            val relationship = select((userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId))
            if (relationship.any()) {
                deleteWhere { (userId1 eq player.uniqueId) and (userId2 eq friend.uniqueId) }
                deleteWhere { (userId2 eq player.uniqueId) and (userId1 eq friend.uniqueId) }
            }
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
        return transaction {
            return@transaction select {
                (userId1 eq player.uniqueId) and (userId2 inList getOnlineUUIDs())
            }
        }.mapNotNull { Bukkit.getPlayer(it[userId2]) }
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
        return Bukkit.getOnlinePlayers().toMutableList().apply {
            removeAll(getOnlineFriends(player))
        }
    }

    /**
     * Maps all the online players to their [java.util.UUID].
     *
     * @return the UUIDs of all the online players.
     */
    private fun getOnlineUUIDs(): List<UUID> {
        return Bukkit.getServer().onlinePlayers.map { it.uniqueId }
    }
}
