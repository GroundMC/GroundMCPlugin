package gtlp.groundmc.lobby.database.table

import org.jetbrains.exposed.sql.Table

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
    val value = long("value")
}
