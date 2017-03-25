package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.*

object Meta : Table() {
    private val CURRENT_TABLE_VER = 2

    private val version = integer("version").default(CURRENT_TABLE_VER).uniqueIndex().primaryKey()

    fun upgradeDatabase() {
        LobbyMain.logger.entering(Meta::class, "upgradeDatabase")
        try {
            transaction {
                val currentVersion = Meta.selectAll().first()[version]
                for (version in currentVersion..CURRENT_TABLE_VER) {
                    when (version) {
                        1 -> {
                            Relationships.columns.filter { it.name.toUpperCase() in arrayOf("LEVEL", "RELATIONSHIP") }.forEach {
                                exec(it.dropStatement().first())
                            }
                            update({ Meta.version eq 1 }) {
                                it[Meta.version] = 2
                            }
                        }
                    }
                }
            }
        } catch (exception: NoSuchElementException) {
            transaction {
                Meta.insert { it[version] = CURRENT_TABLE_VER }
                commit()
            }
            LobbyMain.logger.info("Database newly created, no update necessary")
        }
    }
}