package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.LobbyMain
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

object Meta : Table() {
    private val CURRENT_TABLE_VER = 1

    private val version = integer("version").default(CURRENT_TABLE_VER).uniqueIndex().primaryKey()

    fun upgradeDatabase() {
        try {
            transaction {
                val currentVersion = Meta.selectAll().first()[version]
                for (version in currentVersion..CURRENT_TABLE_VER) {
                    when (version) {

                    }
                }
            }
        } catch (exception: NoSuchElementException) {
            transaction {
                Meta.insert { it[version] = CURRENT_TABLE_VER }
                commit()
            }
            LobbyMain.instance?.logger?.info("Database newly created, no update necessary")
        }
    }
}