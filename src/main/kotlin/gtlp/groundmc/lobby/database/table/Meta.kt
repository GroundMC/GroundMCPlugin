package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.legacy.Meta0
import gtlp.groundmc.lobby.database.table.legacy.Users0
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import me.BukkitPVP.PointsAPI.PointsAPI
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.inventory.ItemStack
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Meta table to store the runtime configuration of the plugin.
 * It also handles upgrades to the database.
 */
object Meta : Table() {

    /**
     * Key part of the table.
     */
    val key = varchar("key", 255).primaryKey()

    /**
     * Value part of the table.
     */
    val value = varchar("value", 16384)

    /**
     * The latest version of the database.
     * Used to track the upgrade process and to determine what upgrades to do.
     */
    private const val CURRENT_DB_VER = 5

    /**
     * The cache that is used to store configuration objects.
     * Refreshes every 5 seconds.
     */
    private val configCache = CacheBuilder.newBuilder()
            .refreshAfterWrite(5L, TimeUnit.SECONDS)
            .build<Config<*>, Any>(CacheLoader.asyncReloading(DatabaseCacheLoader(), Executors.newCachedThreadPool()))

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
                    currentVersion = get(Config.DATABASE_VERSION) ?: CURRENT_DB_VER
                }
                for (version in currentVersion..CURRENT_DB_VER) {
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
                                set(Config.SLOWCHAT_ENABLED, LobbyMain.instance.config.getBoolean("slowchat.enabled", false))
                                set(Config.SLOWCHAT_TIMEOUT, LobbyMain.instance.config.getLong("slowchat.timeout", 3000))
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
                        4 -> {
                            Users0.selectAll().forEach {
                                PointsAPI.setPoints(Bukkit.getOfflinePlayer(it[Users0.id]),
                                        it[Users0.coins])
                            }
                            when (LobbyMain.instance.config["database.driver"]) {
                                "org.sqlite.JDBC" -> {
                                    exec("ALTER TABLE `${identity(Users0)}` RENAME TO `${identity(Users0)}-old`")
                                    Users.createStatement().forEach { exec(it) }
                                    val newColumns = Users.columns.joinToString("`, `", "`", "`") { it.name }
                                    exec("INSERT INTO `${identity(Users)}`($newColumns) " +
                                            "SELECT $newColumns FROM `${identity(Users0)}-old`")
                                    exec("DROP TABLE `${identity(Users0)}-old`")
                                }
                                else -> {
                                    Users0.coins.dropStatement().forEach { exec(it) }
                                }
                            }
                            set(Config.DATABASE_VERSION, 5)
                        }
                    }
                }
            }
        } catch (exception: NoSuchElementException) {
            transaction {
                set(Config.DATABASE_VERSION, CURRENT_DB_VER)
                commit()
            }
            LobbyMain.logger.info("Database newly created, no update necessary")
        }
        LobbyMain.logger.exiting(Meta::class, "upgradeDatabase")
    }

    /**
     * Queries the database for a given key and returns the value associated
     * to it.
     *
     * @param key the key to lookup
     *
     * @return the value associated with the [key] or `null`, if not present.
     */
    @Suppress("UNCHECKED_CAST", "PlatformExtensionReceiverOfInline")
    operator fun <T> get(key: Config<T>): T? {
        return try {
            with(configCache[key]) {
                try {
                    key.type.cast(this) as T
                } catch (e: ClassCastException) {
                    if (this is String) {
                        when (key.type) {
                            Boolean::class.javaObjectType -> this.toBoolean() as T
                            Byte::class.javaObjectType -> this.toByte() as T
                            Short::class.javaObjectType -> this.toShort() as T
                            Int::class.javaObjectType -> this.toInt() as T
                            Long::class.javaObjectType -> this.toLong() as T
                            Float::class.javaObjectType -> this.toFloat() as T
                            Double::class.javaObjectType -> this.toDouble() as T
                            else -> this as T
                        }
                    } else {
                        this as T
                    }
                }
            }
        } catch (e: Exception) {
            LobbyMain.logger.throwing(this.javaClass.name, "get", e)
            null as T
        }
    }


    /**
     * Updates the config and replaces the current value with the new one.
     *
     * @param key the key to associate the value with
     * @param value the contents of this configuration item
     */
    operator fun <T> set(key: Config<T>, value: Any) {
        LobbyMain.logger.fine("Setting value for ${key.key}")
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
        configCache.invalidate(key)
    }

    /**
     * Class to load config values for the cache.
     */
    class DatabaseCacheLoader : CacheLoader<Config<*>, Any>() {
        override fun load(key: Config<*>): Any {
            LobbyMain.logger.finer("Getting value for ${key.key}")
            with(YamlConfiguration()) {
                loadFromString(
                        transaction {
                            select {
                                Meta.key eq key.key
                            }.first().tryGet(value) ?: throw NoSuchElementException(
                                    "value for key \"${key.key}\" is non-existent!")
                        })
                return this.get(key.key) ?: throw NullPointerException(
                        "value for key \"${key.key}\" is null!")
            }
        }
    }
}
