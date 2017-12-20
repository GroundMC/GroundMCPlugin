package gtlp.groundmc.lobby.database.table

import org.jetbrains.exposed.sql.Table

object Statistics : Table() {

    val serverId = varchar("server_id", 255)

    val playerId = uuid("player_id").references(Users.id)

    val statistic = varchar("statistic", 255)

    val material = varchar("material", 255).nullable()

    val entity = varchar("entity", 255).nullable()

    val value = long("value")
}