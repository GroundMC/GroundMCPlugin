package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.legacy.Meta0
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.util.entering
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
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

    private val configCache = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.SECONDS).build<Config, Any>()

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
                var currentVersion = try {
                    Meta0.selectAll().firstOrNull()?.tryGet(Meta0.version)
                } catch (e: Exception) {
                    null
                }
                if (currentVersion == null) {
                    currentVersion = get(Config.DATABASE_VERSION) as Int? ?: CURRENT_TABLE_VER
                }
                for (version in currentVersion..CURRENT_TABLE_VER) {
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
                            exec("REPLACE INTO `Meta`(`key`, `value`) VALUES (\"${Config.DATABASE_VERSION.key}\", 3)")
                            commit()
                        }
                        3 -> {
                            if ("coins.dailyAmount" in LobbyMain.instance.config) {
                                set(Config.COINS_DAILY, LobbyMain.instance.config.getInt("coins.dailyAmount", 100))
                            }
                            if ("slowchat.enabled" in LobbyMain.instance.config &&
                                    "slowchat.timeout" in LobbyMain.instance.config) {
                                set(Config.SLOWCHAT_ENABLED, LobbyMain.instance.config.getBoolean("slowchat.enabled", false).toString())
                                set(Config.SLOWCHAT_TIMEOUT, LobbyMain.instance.config.getLong("slowchat.timeout", 3000).toString())
                            }
                            if ("hub" in LobbyMain.instance.config) {
                                set(Config.HUB_LOCATION, LobbyMain.instance.config.get("hub",
                                        Bukkit.getWorlds().first().spawnLocation))
                            }
                            if ("jumppads.material" in LobbyMain.instance.config &&
                                    "jumppads.multiplier" in LobbyMain.instance.config &&
                                    "jumppads.y" in LobbyMain.instance.config) {
                                set(Config.JUMPPADS_MATERIAL, LobbyMain.instance.config.getList("jumppads.material"))
                                set(Config.JUMPPADS_MULTIPLIER, LobbyMain.instance.config.getDouble("jumppads.multiplier"))
                                set(Config.JUMPPADS_Y, LobbyMain.instance.config.getDouble("jumppads.y"))
                            }
                            if ("inventory.content" in LobbyMain.instance.config) {
                                @Suppress("UNCHECKED_CAST")
                                set(Config.INVENTORY_CONTENT,
                                        LobbyMain.instance.config.getList("inventory.content") as List<ItemStack?>)
                            }
                            set(Config.DATABASE_VERSION, 4)
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
    operator fun get(key: Config): Any? {
        return configCache.get(key, {
            with(YamlConfiguration()) {
                loadFromString(
                        transaction {
                            select {
                                Meta.key eq key.key
                            }.first().tryGet(value)
                        })
                this.get(key.key, null)
            }
        })
    }


    /**
     * Updates the config and replaces the current value with the new one.
     *
     * @param key the key to associate the value with
     * @param value the contents of this configuration item
     */
    operator fun set(key: Config, value: Any) {
        transaction {
            deleteWhere { Meta.key eq key.key }
            insert {
                it[Meta.key] = key.key
                it[Meta.value] = with(YamlConfiguration()) {
                    this.set(key.key, value)
                    saveToString()
                }
            }
            commit()
        }
    }
}
