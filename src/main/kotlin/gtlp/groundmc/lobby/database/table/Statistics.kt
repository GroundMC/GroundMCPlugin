package gtlp.groundmc.lobby.database.table

import org.bukkit.Material
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

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
}

/**
 * Aggregate the values over one statistic.
 *
 * @param statistic the statistic to aggregate
 *
 * @return the aggregated value
 */
fun Player.queryStatistic(statistic: Statistic) =
        transaction {
            Statistics.select {
                (Statistics.statistic eq statistic.name) and
                        (Statistics.playerId eq uniqueId)
            }.first().tryGet(Statistics.value)
        }

/**
 * Aggregate the values over one statistic, specified by an entity.
 *
 * @param statistic the statistic to aggregate
 * @param entity the entity to specify on
 *
 * @return the aggregated value
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
 * Aggregate the values over one statistic, specified by a material.
 *
 * @param statistic the statistic to aggregate
 * @param material the material to specify on
 *
 * @return the aggregated value
 */
fun Player.queryStatistic(statistic: Statistic, material: Material) =
        transaction {
            Statistics.select {
                (Statistics.statistic eq statistic.name) and
                        (Statistics.playerId eq uniqueId) and
                        (Statistics.material eq material.name)
            }.first().tryGet(Statistics.value)
        }
