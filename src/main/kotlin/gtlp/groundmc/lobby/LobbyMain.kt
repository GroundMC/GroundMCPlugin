package gtlp.groundmc.lobby

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.tr7zw.itemnbtapi.utils.GsonWrapper
import gtlp.groundmc.lobby.commands.*
import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.event.listener.*
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.registry.LobbyCommandRegistry
import gtlp.groundmc.lobby.task.*
import gtlp.groundmc.lobby.util.*
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.MemorySection
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.PluginLogger
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.impl.JDK14LoggerAdapter
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.sql.Connection
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger

/**
 * The main class for this plugin.
 * Serves as the entry point and commander of all things.
 */
class LobbyMain : JavaPlugin() {

    /**
     * Initializes the plugin.
     * Sets up the logging before the plugin executes.
     */
    init {
        logger.entering(LobbyMain::class, "init")
        val logFileDirectory = File("${dataFolder.absolutePath}/logs")
        if (!logFileDirectory.exists()) {
            logFileDirectory.mkdir()
        }
        val logHandler = FileHandler("$logFileDirectory/groundmc.%g.log", 5.megabytes, 10).apply {
            level = Level.FINEST
            formatter = LogFormatter()
        }
        logger.addHandler(logHandler)
        if (exposedLogger is JDK14LoggerAdapter) {
            val fLogger = JDK14LoggerAdapter::class.java.getDeclaredField("logger")
            fLogger.isAccessible = true
            fLogger.set(exposedLogger, PluginLogger(this).apply {
                level = Level.INFO
            })
        }
        logger.exiting(LobbyMain::class, "init")
    }

    /**
     * Called when this plugin is enabled
     */
    override fun onEnable() {
        logger.entering(LobbyMain::class, "onEnable")
        instance = this
        registerGsonHandlers()
        createDefaultConfig()
        upgradeConfig()
        loadConfig()
        logger.config("Loading database...")
        Database.connect(config.getString("database.url")
                .replace("\$dataFolder", dataFolder.absolutePath),
                config.getString("database.driver"), config.getString("database.username", ""),
                config.getString("database.password", ""))
        if (config.getString("database.driver") == "org.sqlite.JDBC") {
            logger.info("SQLite detected, setting default isolation level" +
                    " to TransactionSerializable")
            TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
        }
        try {
            transaction {
                createMissingTablesAndColumns(Meta, Users, Relationships, Events)
            }
        } catch (e: Exception) {
            logger.warning("Error in first database update pass. If you are updating the database from version " +
                    "2 to version 3, you can ignore this warning.")
        }
        Meta.upgradeDatabase()

        registerListeners()
        registerCommands()

        scheduleTasks()

        logger.exiting(LobbyMain::class, "onEnable")
    }

    /**
     * Schedules all [ITask]s used by the plugin.
     */
    private fun scheduleTasks() {
        logger.config("Scheduling tasks...")
        Bukkit.getServer().scheduler.scheduleSyncDelayedTask(SetRulesTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(ApplyPlayerEffectsTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(HidePlayersTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(MonitorLocaleTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(UpdateLobbyInventoryTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(UpdateScoreboardsTask)
    }

    /**
     * Registers all [org.bukkit.event.Listener]s that are used by this plugin.
     */
    private fun registerListeners() {
        logger.config("Registering event listeners...")
        arrayOf(ChatInteractionListener,
                HidePlayerListener,
                LobbyInteractionListener,
                LobbyInventoryListener,
                LobbyInvincibilityListener,
                PreventWorldInteractionListener,
                ServerStateListener,
                SilentChatListener
        ).forEach { Bukkit.getServer().pluginManager.registerEvents(it, this) }
    }

    /**
     * Registers a custom GSON handler to handle the [Location] class.
     */
    private fun registerGsonHandlers() {
        logger.entering(LobbyMain::class, "registerGsonHandlers")
        // Gets private static final Gson gson = new Gson();
        val fGson = GsonWrapper::class.java.getDeclaredField("gson")
        fGson.isAccessible = true

        val modifiersField = Field::class.java.getDeclaredField("modifiers")
        modifiersField.isAccessible = true
        modifiersField.setInt(fGson, fGson.modifiers and Modifier.FINAL.inv())

        // Gets  private final List<TypeAdapterFactory> factories;
        val fFactories = Gson::class.java.getDeclaredField("factories")
        fFactories.isAccessible = true
        val factories = fFactories.get(fGson.get(null)) as List<*>

        // Sets private static final Gson gson
        fGson.set(null, GsonBuilder().apply {
            registerTypeAdapter(Location::class.java, LocationTypeAdapter)
            factories.forEach { this::registerTypeAdapterFactory }
        }.create())
        logger.exiting(LobbyMain::class, "registerGsonHandlers")
    }

    /**
     * Upgrades the config file using the [ConfigUpgrader].
     */
    private fun upgradeConfig() {
        logger.entering(LobbyMain::class, "upgradeConfig")
        logger.info("Upgrading configuration...")
        logger.info("Current version is ${config["version"]}.")
        logger.info("New version is $configVersion")
        logger.finest("Config before:")
        logger.finest(config.saveToString().replace(Regex("""\r?\n"""), "\r\n"))
        if (config["hub"] is MemorySection) {
            logger.warning("Upgraded 'hub', please set new hub location!")
            config["hub"] = Bukkit.getWorlds().first().spawnLocation
        }
        for (currentVersion in config.getInt("version", 1)..configVersion) {
            when (currentVersion) {
                1 -> ConfigUpgrader.upgradeItemsToUseObject(config)
                2 -> ConfigUpgrader.addJumpPadConfiguration(config)
            }
        }

        config["version"] = configVersion

        saveConfig()
        reloadConfig()

        logger.finest("Config after:")
        logger.finest(config.saveToString().replace(Regex("""\r?\n"""), "\r\n"))

        logger.info("Configuration upgrade complete.")
        logger.exiting(LobbyMain::class, "upgradeConfig")
    }

    /**
     * Loads the config and sanitizes certain fields.
     */
    private fun loadConfig() {
        logger.entering(LobbyMain::class, "loadConfig")
        if ("inventory.content" in config && config["inventory.content"] is List<*>) {
            @Suppress("unchecked_cast")
            LobbyInventory.TEMPLATE_INVENTORY.contents = (config["inventory.content"] as List<ItemStack?>).toTypedArray()

            (0 until LobbyInventory.TEMPLATE_INVENTORY.contents.size).forEach { i ->
                if (LobbyInventory.TEMPLATE_INVENTORY.getItem(i) == null) {
                    LobbyInventory.TEMPLATE_INVENTORY.setItem(i, Items.FILLER.item)
                }
            }
        }
        logger.info("Setting logger verbosity to ${config.getString("log.verbosity", "FINEST")}")
        logger.level = Level.parse(config.getString("log.verbosity", "FINEST"))
        logger.info("Loaded config.")
        logger.exiting(LobbyMain::class, "loadConfig")
    }

    /**
     * Initializes the config file for first use.
     */
    private fun createDefaultConfig() {
        logger.entering(LobbyMain::class, "createDefaultConfig")

        config.addDefault("log.verbosity", "FINEST")

        config.addDefault("database.username", "")
        config.addDefault("database.password", "")
        config.addDefault("database.driver", "org.sqlite.JDBC")
        config.addDefault("database.url", "jdbc:sqlite:\$dataFolder/database")

        config.addDefault("version", configVersion)

        config.options().copyDefaults(true)
        saveDefaultConfig()
        logger.exiting(LobbyMain::class, "createDefaultConfig")
    }

    /**
     * Registers all commands into the [LobbyCommandRegistry].
     */
    private fun registerCommands() {
        logger.entering(LobbyMain::class, "registerCommands")
        logger.config("Registering commands...")
        LobbyCommandRegistry.registerCommand(CommandLobby())
        LobbyCommandRegistry.registerCommand(CommandVanish())
        LobbyCommandRegistry.registerCommand(CommandCoins())
        LobbyCommandRegistry.registerCommand(CommandFriend())
        LobbyCommandRegistry.registerCommand(CommandFriends())
        logger.exiting(LobbyMain::class, "registerCommands")
    }

    /**
     * Called when this plugin is disabled
     */
    override fun onDisable() {
        logger.entering(LobbyMain::class, "onDisable")
        logger.info("Saving configuration and disabling...")
        tasks.forEach { Bukkit.getServer().scheduler.cancelTask(it.value) }
        saveConfig()
        logger.exiting(LobbyMain::class, "onDisable")
    }

    /**
     * Saves the [org.bukkit.configuration.file.FileConfiguration] retrievable by [getConfig].
     */
    override fun saveConfig() {
        logger.entering(LobbyMain::class, "saveConfig")
        when (config["inventory.content"]) {
            is List<*> -> config["inventory.content"] = (config["inventory.content"] as List<*>).map { if (it != Items.FILLER.item) it else null }
            is Array<*> -> config["inventory.content"] = (config["inventory.content"] as Array<*>).map { if (it != Items.FILLER.item) it else null }.toTypedArray()
        }
        super.saveConfig()
        logger.exiting(LobbyMain::class, "saveConfig")
    }

    /**
     * Schedules a repeating task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncRepeatingTask
     */
    private fun BukkitScheduler.scheduleSyncRepeatingTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncRepeatingTask")
        tasks.put(task, scheduleSyncRepeatingTask(this@LobbyMain, task, task.delay, task.period))
    }

    /**
     * Schedules a delayed task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncDelayedTask
     */
    private fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncDelayedTask")
        tasks.put(task, scheduleSyncDelayedTask(this@LobbyMain, task, task.delay))
    }

    companion object {
        /**
         * A map of [Player]s to their inventory contents.
         */
        val originalInventories = mutableMapOf<Player, Array<ItemStack?>>()

        /**
         * A map of tasks to their IDs
         */
        val tasks = mutableMapOf<ITask, Int>()

        /**
         * Set holding players that want their chat to be silent
         */
        val SILENCED_PLAYERS = mutableSetOf<Player>()

        /**
         * Common instance of this [LobbyMain] plugin.
         */
        lateinit var instance: LobbyMain

        /**
         * The [Logger] that is created in the init block.
         */
        val logger: Logger
            get() = instance.logger

        /**
         * The latest version of the configuration.
         * Used in [upgradeConfig].
         */
        const val configVersion = 3
    }

}
