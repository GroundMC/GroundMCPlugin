package net.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import kotlinx.coroutines.experimental.async
import org.bukkit.OfflinePlayer
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.util.*
import java.util.concurrent.Executors

object FriendRequests : Table("FriendRequests") {

    val requester = uuid("requester").references(Users.id, ReferenceOption.CASCADE).primaryKey().index()

    val requested = uuid("requested").references(Users.id, ReferenceOption.CASCADE).primaryKey().index()

    val requestTime = datetime("requestTime").clientDefault { DateTime.now() }.index()

    private val requestsFrom = CacheBuilder.newBuilder()
            .build(CacheLoader.asyncReloading(RequestLoader(requester), Executors.newCachedThreadPool()))

    private val requestsFor = CacheBuilder.newBuilder()
            .build(CacheLoader.asyncReloading(RequestLoader(requested), Executors.newCachedThreadPool()))


    class RequestLoader(private val column: Column<UUID>) : CacheLoader<UUID, List<ResultRow>>() {
        override fun load(key: UUID): List<ResultRow> {
            return transaction {
                return@transaction select { column eq key }.toList()
            }
        }

        override fun loadAll(keys: Iterable<UUID>): Map<UUID, List<ResultRow>> {
            return transaction {
                return@transaction select { column inList keys }.groupBy { it[column] }
            }
        }
    }

    fun getRequestsFor(player: OfflinePlayer) = requestsFor[player.uniqueId]

    fun getRequestsFrom(player: OfflinePlayer) = requestsFrom[player.uniqueId]

    fun newRequest(requestPlayer: OfflinePlayer, requestedPlayer: OfflinePlayer) {
        async {
            transaction {
                insert {
                    it[requester] = requestedPlayer.uniqueId
                    it[requested] = requestedPlayer.uniqueId
                }
            }
            requestsFor.refresh(requestedPlayer.uniqueId)
            requestsFrom.refresh(requestPlayer.uniqueId)
        }
    }

    fun removeRequest(requestPlayer: OfflinePlayer, requestedPlayer: OfflinePlayer) {
        async {
            transaction {
                deleteWhere { (requester eq requestPlayer.uniqueId) and (requested eq requestedPlayer.uniqueId) }
            }
            requestsFor.refresh(requestedPlayer.uniqueId)
            requestsFrom.refresh(requestPlayer.uniqueId)
        }
    }

}
