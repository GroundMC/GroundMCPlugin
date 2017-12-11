package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.legacy.Meta0
import gtlp.groundmc.lobby.util.entering
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Meta table to store the runtime configuration of the plugin.
 * It also handles upgrades to the database.
 */
object Meta : Table() {
    /**
     * The latest version of the database.
     * Used to track the upgrade process and to determine what upgrades to do.
     */
    private val CURRENT_TABLE_VER = 3

    /**
     * Key to be used to save the database's version
     */
    private val DB_VERSION = "db.version"

    /**
     * Key part of the table.
     */
    val key = varchar("key", 255).primaryKey()

    /**
     * Value part of the table.
     */
    val value = varchar("value", 16384)

    /**
     * Upgrades the database by performing the needed modifications to the database.
     */
    fun upgradeDatabase() {
        LobbyMain.logger.entering(Meta::class, "upgradeDatabase")
        try {
            transaction {
                var currentVersion = Meta0.selectAll().firstOrNull()?.tryGet(Meta0.version)
                if (currentVersion == 0) {
                    currentVersion = select { key eq DB_VERSION }.firstOrNull()?.tryGet(value)?.toInt() ?: CURRENT_TABLE_VER
                }
                for (version in currentVersion!!..CURRENT_TABLE_VER) {
                    when (version) {
                        1 -> {
                            Relationships.columns.filter { it.name.toUpperCase() in arrayOf("LEVEL", "RELATIONSHIP") }.forEach {
                                exec(it.dropStatement().first())
                            }
                            exec("UPDATE `Meta` SET version = 2")
                            commit()
                        }
                        2 -> {
                            Meta.dropStatement().forEach { exec(it) }
                            Meta.createStatement().forEach { exec(it) }
                            exec("REPLACE INTO `Meta`(`key`, `value`) VALUES (\"$DB_VERSION\", \"$CURRENT_TABLE_VER\")")
                            commit()
                        }
                    }
                }
            }
        } catch (exception: NoSuchElementException) {
            transaction {
                Meta.insert {
                    it[key] = DB_VERSION
                    it[value] = CURRENT_TABLE_VER.toString()
                }
                commit()
            }
            LobbyMain.logger.info("Database newly created, no update necessary")
        }
    }
}
