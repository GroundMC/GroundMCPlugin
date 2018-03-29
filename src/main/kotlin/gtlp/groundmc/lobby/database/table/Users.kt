package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import gtlp.groundmc.lobby.enums.VisibilityStates
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Table to hold players' settings and more data
 */
object Users : Table() {
    /**
     * The [UUID] of the player
     */
    val id = uuid("playerId").primaryKey()

    /**
     * The last name with which this player has been seen
     */
    val lastName = text("last_name").index()

    /**
     * Whether the chat is silent for this player or not
     */
    val silentStatus = bool("silent_status").default(false)

    /**
     * One of the [VisibilityStates] visibility settings
     */
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)

    /**
     * Whether this player is vanished or not
     */
    val vanishStatus = bool("vanish_status").default(false)

    /**
     * The last date at which the player has received daily coins (does not accumulate)
     */
    val lastDailyCoinsDate = date("lastDailyCoins").default(DateTime.parse("1970-01-01"))

    /**
     * Cache for the players which are currently on the server.
     * Improves overall performance and responsiveness.
     */
    private val userCache = CacheBuilder.newBuilder()
            .expireAfterAccess(3, TimeUnit.SECONDS)
            .refreshAfterWrite(2, TimeUnit.SECONDS)
            .build<UUID, ResultRow>(CacheLoader.asyncReloading(UserCacheLoader(), Executors.newCachedThreadPool()))

    /**
     * Loader that simply loads the first user with the corresponding UID
     * into the cache.
     */
    class UserCacheLoader : CacheLoader<UUID, ResultRow>() {
        override fun load(uuid: UUID): ResultRow {
            return transaction {
                return@transaction Users.select(Users.id eq uuid).first()
            }
        }

        override fun loadAll(uuids: MutableIterable<UUID>): MutableMap<UUID, ResultRow> {
            return transaction {
                return@transaction Users.select { Users.id inList uuids }
                        .associateBy { it[id] }.toMutableMap()
            }
        }

    }

    /**
     * @see com.google.common.cache.LoadingCache.get
     */
    operator fun get(player: Player): ResultRow = userCache[player.uniqueId]

    /**
     * @see com.google.common.cache.LoadingCache.get
     */
    operator fun get(uuid: UUID): ResultRow = userCache[uuid]

    /**
     * @see com.google.common.cache.LoadingCache.getAll
     */
    fun getAll(iterable: Iterable<UUID>): Map<UUID, ResultRow> = userCache.getAll(iterable)

    /**
     * @see com.google.common.cache.LoadingCache.invalidate
     */
    fun invalidate(player: Player) {
        userCache.invalidate(player.uniqueId)
    }

    /**
     * @see com.google.common.cache.LoadingCache.invalidate
     */
    fun invalidate(uuid: UUID) {
        userCache.invalidate(uuid)
    }

    /**
     * @see com.google.common.cache.LoadingCache.refresh
     */
    fun refresh(player: Player) {
        userCache.refresh(player.uniqueId)
    }

    /**
     * @see com.google.common.cache.LoadingCache.refresh
     */
    fun refresh(uuid: UUID) {
        userCache.refresh(uuid)
    }

    /**
     * Queries the database for a [ResultRow] by the last name of a player.
     * Additionally stores the row in the cache.
     *
     * @param name the name to query the database for
     * @return the UUID that identifies the searched player or
     * `null`, if there is no player with the given [name]
     */
    fun byName(name: String): UUID? {
        return userCache.asMap().entries.firstOrNull { it.value[lastName] == name }?.key
                ?: run {
                    val row = transaction {
                        return@transaction select { lastName eq name }.firstOrNull()
                    }
                    if (row != null) {
                        userCache.put(row[id], row)
                    }
                    return@run row?.get(id)
                }
    }
}
