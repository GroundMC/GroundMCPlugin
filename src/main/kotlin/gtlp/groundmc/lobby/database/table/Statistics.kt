

package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import org.bukkit.Material
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Table to store and organize statistic entries.
 */
object Statistics : Table() {

    /**
     * The [org.bukkit.OfflinePlayer.getUniqueId] of the player.
     */
    val playerId = uuid("player_id").references(Users.id)

    /**
     * The statistic or statistics category.
     */
    val statistic = varchar("statistic", 255)

    /**
     * The material that precisely specifies the statistic.
     */
    val material = varchar("material", 255).nullable()

    /**
     * The entity that precisely specifies the statistic.
     */
    val entity = varchar("entity", 255).nullable()

    /**
     * The value of the statistic.
     */
    val value = integer("value")

    /**
     * Cache to store the statistics of a player in for 10 seconds.
     */
    private val statisticsCache = CacheBuilder.newBuilder()
            .refreshAfterWrite(10L, TimeUnit.SECONDS)
            .build<StatisticsObject, Int?>(CacheLoader.asyncReloading(StatisticsCacheLoader(), Executors.newCachedThreadPool()))

    /**
     * Class to load statistics when needed
     */
    class StatisticsCacheLoader : CacheLoader<StatisticsObject, Int?>() {
        override fun load(key: StatisticsObject) = when {
            key.material != null -> key.player.queryStatistic(key.statistic, key.material)
            key.entity != null -> key.player.queryStatistic(key.statistic, key.entity)
            else -> key.player.queryStatistic(key.statistic)
        }

    }

    /**
     * A class that holds a player and a defined statistic without value.
     */
    data class StatisticsObject(
            /**
             * The player, who's statistic this is meant to be.
             */
            val player: Player,

            /**
             * The type of statistic.
             */
            val statistic: Statistic,

            /**
             * The material which defines the statistic.
             * `null` for statistics without a material identifier.
             */
            val material: Material? = null,

            /**
             * The entity which defines the statistic.
             * `null` for statistics without a entity identifier.
             */
            val entity: EntityType? = null)

    /**
     * Asks the [statisticsCache] for a player's statistic and returns its value,
     * if there is one.
     *
     * @param player the player. who's statistics to get
     * @param statistic the statistic to get
     * @param material the material definition for statistics that require this
     * @param entity the entity type definition for statistics that require this
     */
    fun getStatistic(player: Player, statistic: Statistic, material: Material? = null, entity: EntityType? = null) =
            statisticsCache[StatisticsObject(player, statistic, material, entity)]
}

/**
 * Query the values of a statistic.
 *
 * @param statistic the statistic to query
 *
 * @return the queried value
 */
fun Player.queryStatistic(statistic: Statistic) =
        transaction {
            Statistics.select {
                (Statistics.statistic eq statistic.name) and
                        (Statistics.playerId eq uniqueId)
            }.first().tryGet(Statistics.value)
        }

/**
 * Query the value of a statistic, specified with an entity.
 *
 * @param statistic the statistic to query
 * @param entity the entity to specify on
 *
 * @return the queried value
 */
fun Player.queryStatistic(statistic: Statistic, entity: EntityType) =
        transaction {
            Statistics.select {
                (Statistics.statistic eq statistic.name) and
                        (Statistics.playerId eq uniqueId) and
                        (Statistics.entity eq entity.name)
            }.first().tryGet(Statistics.value)
        }

/**
 * Query the value of a statistic, specified with a material.
 *
 * @param statistic the statistic to query
 * @param material the material to specify on
 *
 * @return the queried value
 */
fun Player.queryStatistic(statistic: Statistic, material: Material) =
        transaction {
            Statistics.select {
                (Statistics.statistic eq statistic.name) and
                        (Statistics.playerId eq uniqueId) and
                        (Statistics.material eq material.name)
            }.first().tryGet(Statistics.value)
        }
