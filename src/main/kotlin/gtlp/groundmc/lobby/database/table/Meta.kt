package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.legacy.Meta0
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.util.entering
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.TimeUnit

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

    private val configCache = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.SECONDS).build<Config, String>()

    /**
     * Key part of the table.
     */
    val key = varchar("key", 255).primaryKey()

    /**
     * Value part of the table.
     */
    val value = varchar("value", 16384).default("")

    /**
     * Upgrades the database by performing the needed modifications to the database.
     */
    fun upgradeDatabase() {
        LobbyMain.logger.entering(Meta::class, "upgradeDatabase")
        try {
            transaction {
                var currentVersion = Meta0.selectAll().firstOrNull()?.tryGet(Meta0.version)
                if (currentVersion == 0) {
                    currentVersion = select { key eq Config.DATABASE_VERSION.key }.firstOrNull()?.tryGet(value)?.toInt() ?: CURRENT_TABLE_VER
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
                            exec("REPLACE INTO `Meta`(`key`, `value`) VALUES (\"${Config.DATABASE_VERSION.key}\", \"$CURRENT_TABLE_VER\")")
                            commit()
                        }
                    }
                }
            }
        } catch (exception: NoSuchElementException) {
            transaction {
                Meta.insert {
                    it[key] = Config.DATABASE_VERSION.key
                    it[value] = CURRENT_TABLE_VER.toString()
                }
                commit()
            }
            LobbyMain.logger.info("Database newly created, no update necessary")
        }
    }

    /**
     * Queries the database for a given key and returns the value associated
     * to it.
     *
     * @param key the key to lookup
     *
     * @return the value associated with the [key] or `null`, if not present.
     */
    fun getConfig(key: Config): String {
        return configCache.get(key, {
            transaction {
                select {
                    Meta.key eq key.key
                }.toList().first().tryGet(value) ?: ""
            }
        })
    }


    /**
     * Updates the config and replaces the current value with the new one.
     *
     * @param key the key to associate the value with
     * @param value the contents of this configuration item
     */
    fun putConfig(key: Config, value: String) {
        transaction {
            replace {
                it[Meta.key] = key.key
                it[Meta.value] = value
            }
            commit()
        }
    }
}
