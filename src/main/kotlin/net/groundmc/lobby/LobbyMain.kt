package net.groundmc.lobby


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapterFactory
import com.zaxxer.hikari.HikariDataSource
import de.tr7zw.nbtapi.utils.GsonWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import net.groundmc.lobby.commands.*
import net.groundmc.lobby.database.table.*
import net.groundmc.lobby.event.listener.*
import net.groundmc.lobby.inventory.LobbyInventory
import net.groundmc.lobby.objects.Items
import net.groundmc.lobby.registry.LobbyCommandRegistry
import net.groundmc.lobby.registry.LobbyCommandRegistry.registerCommand
import net.groundmc.lobby.task.*
import net.groundmc.lobby.util.*
import net.groundmc.statsdb.StatsDB
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.MemorySection
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.PluginLogger
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.bukkit.scheduler.BukkitTask
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import org.slf4j.helpers.SubstituteLogger
import org.slf4j.impl.JDK14LoggerAdapter
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.staticProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaField

/**
 * The main class for this plugin.
 * Serves as the entry point and commander of all things.
 */
class LobbyMain : JavaPlugin() {

    /**
     * A map of tasks to their IDs
     */
    val tasks = mutableMapOf<ITask, BukkitTask>()
    /**
     * A map of [Player]s to their inventory contents.
     */
    val originalInventories = mutableMapOf<Player, Array<ItemStack?>>()

    val scope = CoroutineScope(Dispatchers.Default)

    lateinit var database: Database
    lateinit var statsDB: StatsDB

    /**
     * Initializes the plugin.
     * Sets up the logging before the plugin executes.
     */
    init {
        LOGGER = logger
        LOGGER.entering(LobbyMain::class, "init")
        val logFileDirectory = File("${dataFolder.absolutePath}/logs")
        if (!logFileDirectory.exists()) {
            logFileDirectory.mkdirs()
        }
        val logHandler = FileHandler("$logFileDirectory/groundmc.%g.log", 5.megabytes, 10).apply {
            level = Level.FINEST
            formatter = LogFormatter()
        }
        LOGGER.addHandler(logHandler)
        when (exposedLogger) {
            is JDK14LoggerAdapter -> {
                val fLogger = JDK14LoggerAdapter::class.java.getDeclaredField("logger")
                fLogger.isAccessible = true
                fLogger.set(exposedLogger, PluginLogger(this).apply {
                    addHandler(logHandler)
                    level = Level.ALL
                })
            }
            is SubstituteLogger -> {
                val wrappedLoggerAdapter = JDK14LoggerAdapter::class.java.getDeclaredConstructor(Logger::class.java).newInstance(LOGGER)
                (exposedLogger as SubstituteLogger).setDelegate(wrappedLoggerAdapter)
            }
        }
        LOGGER.exiting(LobbyMain::class, "init")
    }

    /**
     * Called when this plugin is enabled
     */
    override fun onEnable() {
        LOGGER.entering(LobbyMain::class, "onEnable")
        backingInstance = this
        registerGsonHandlers()
        createDefaultConfig()
        upgradeConfig()
        loadConfig()
        logger.config("Loading database...")
        statsDB = Bukkit.getPluginManager().getPlugin("StatsDB") as StatsDB
        database = Database.connect(HikariDataSource().apply {
            jdbcUrl = config.getString("database.url")
                    .replace("\$dataFolder", dataFolder.absolutePath)
            username = config.getString("database.username", "")
            password = config.getString("database.password", "")
            transactionIsolation = "TRANSACTION_READ_COMMITTED"
        })
        try {
            transaction(database) {
                createMissingTablesAndColumns(Meta, Users, Relationships, Events, FriendRequests)
            }
        } catch (e: Exception) {
            logger.warning("Error in first database update pass. If you are updating the database from version " +
                    "2 to version 3, you can ignore this warning.")
        }
        Meta.upgradeDatabase()

        registerListeners()
        registerCommands()

        scheduleTasks()

        LOGGER.exiting(LobbyMain::class, "onEnable")
    }

    /**
     * Schedules all [ITask]s used by the plugin.
     */
    private fun scheduleTasks() {
        logger.config("Scheduling tasks...")
        Bukkit.getScheduler().scheduleSyncDelayedTask(SetRulesTask)
        Bukkit.getScheduler().runTaskTimerAsynchronously(ApplyPlayerEffectsTask)
        Bukkit.getScheduler().runTaskTimerAsynchronously(HidePlayersTask)
        Bukkit.getScheduler().runTaskTimerAsynchronously(UpdateLobbyInventoryTask)
        Bukkit.getScheduler().runTaskTimerAsynchronously(UpdateScoreboardsTask)
    }

    /**
     * Registers all [org.bukkit.event.Listener]s that are used by this plugin.
     */
    private fun registerListeners() {
        LOGGER.entering(LobbyMain::class, "registerListeners")
        LOGGER.config("Registering event listeners...")
        arrayOf(ChatInteractionListener,
                HidePlayerListener,
                LobbyInteractionListener,
                LobbyInventoryListener,
                LobbyInvincibilityListener,
                PreventWorldInteractionListener,
                ServerStateListener,
                SilentChatListener,
                LobbyChooserListener,
                FriendsOverviewListener,
                FriendRequestsListener,
                RequestListener
        ).forEach { Bukkit.getPluginManager().registerEvents(it, this) }
        LOGGER.exiting(LobbyMain::class, "registerListeners")
    }

    /**
     * Registers a custom GSON handler to handle the [Location] class.
     */
    private fun registerGsonHandlers() {
        LOGGER.entering(LobbyMain::class, "registerGsonHandlers")
        // Gets private static final Gson gson = new Gson();
        val fGson = GsonWrapper::class.staticProperties.first { it.name == "gson" && it.returnType == Gson::class } as KMutableProperty0<Gson>
        fGson.isAccessible = true

        val modifiersField = Field::class.memberProperties.first { name == "modifiers" && it.returnType == Int::class } as KMutableProperty1<Field, Int>
        modifiersField.isAccessible = true
        modifiersField.set(fGson.javaField!!, modifiersField.get(fGson.javaField!!) and Modifier.FINAL.inv())

        // Gets  private final List<TypeAdapterFactory> factories;
        val fFactories = Gson::class.memberProperties.first { it.name == "factories" }
        fFactories.isAccessible = true
        val factories = fFactories.get(fGson.get()) as List<*>

        // Sets private static final Gson gson
        fGson.set(GsonBuilder().apply {
            registerTypeAdapter(Location::class.java, LocationTypeAdapter)
            registerTypeAdapter(DateTime::class.java, DateTimeAdapter)
            factories.forEach { registerTypeAdapterFactory(it as TypeAdapterFactory) }
        }.create())
        LOGGER.exiting(LobbyMain::class, "registerGsonHandlers")
    }

    /**
     * Upgrades the config file using the [ConfigUpgrader].
     */
    private fun upgradeConfig() {
        LOGGER.entering(LobbyMain::class, "upgradeConfig")
        LOGGER.info("Upgrading configuration...")
        LOGGER.info("Current version is ${config["version"]}.")
        LOGGER.info("New version is $configVersion")
        LOGGER.finest("Config before:")
        LOGGER.finest(config.saveToString().replace(Regex("""\r?\n"""), "\r\n"))
        if (config["hub"] is MemorySection) {
            LOGGER.warning("Upgraded 'hub', please set new hub location!")
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

        LOGGER.finest("Config after:")
        LOGGER.finest(config.saveToString().replace(Regex("""\r?\n"""), "\r\n"))

        LOGGER.info("Configuration upgrade complete.")
        LOGGER.exiting(LobbyMain::class, "upgradeConfig")
    }

    /**
     * Loads the config and sanitizes certain fields.
     */
    private fun loadConfig() {
        LOGGER.entering(LobbyMain::class, "loadConfig")
        if ("inventory.content" in config && config["inventory.content"] is List<*>) {
            @Suppress("unchecked_cast")
            LobbyInventory.TEMPLATE_INVENTORY.contents = (config["inventory.content"] as List<ItemStack?>).toTypedArray()

            (LobbyInventory.TEMPLATE_INVENTORY.contents.indices).forEach {
                if (LobbyInventory.TEMPLATE_INVENTORY.getItem(it) == null) {
                    LobbyInventory.TEMPLATE_INVENTORY.setItem(it, Items.FILLER.item)
                }
            }
        }
        LOGGER.info("Setting logger verbosity to ${config.getString("log.verbosity", "FINEST")}")
        LOGGER.level = Level.parse(config.getString("log.verbosity", "FINEST"))
        LOGGER.info("Loaded config.")
        LOGGER.exiting(LobbyMain::class, "loadConfig")
    }

    /**
     * Initializes the config file for first use.
     */
    private fun createDefaultConfig() {
        LOGGER.entering(LobbyMain::class, "createDefaultConfig")

        config.addDefault("log.verbosity", "FINEST")

        config.addDefault("database.username", "")
        config.addDefault("database.password", "")
        config.addDefault("database.driver", "org.sqlite.JDBC")
        config.addDefault("database.url", "jdbc:sqlite:\$dataFolder/database")

        config.addDefault("version", configVersion)

        config.options().copyDefaults(true)
        saveDefaultConfig()
        LOGGER.exiting(LobbyMain::class, "createDefaultConfig")
    }

    /**
     * Registers all commands into the [LobbyCommandRegistry].
     */
    private fun registerCommands() {
        LOGGER.entering(LobbyMain::class, "registerCommands")
        LOGGER.config("Registering commands...")
        arrayOf(CommandLobby,
                CommandVanish,
                CommandCoins,
                CommandFriend,
                CommandFriends
        ).forEach(LobbyCommandRegistry::registerCommand)
        LOGGER.exiting(LobbyMain::class, "registerCommands")
    }

    /**
     * Called when this plugin is disabled
     */
    override fun onDisable() {
        LOGGER.entering(LobbyMain::class, "onDisable")
        LOGGER.info("Saving configuration and disabling...")
        tasks.forEach { it.value.cancel() }
        scope.cancel("Disabling...")
        saveConfig()
        LOGGER.exiting(LobbyMain::class, "onDisable")
    }

    /**
     * Saves the [org.bukkit.configuration.file.FileConfiguration] retrievable by [getConfig].
     */
    override fun saveConfig() {
        LOGGER.entering(LobbyMain::class, "saveConfig")
        when (config["inventory.content"]) {
            is List<*> -> config["inventory.content"] = (config["inventory.content"] as List<*>).map { if (it != Items.FILLER.item) it else null }
            is Array<*> -> config["inventory.content"] = (config["inventory.content"] as Array<*>).map { if (it != Items.FILLER.item) it else null }.toTypedArray()
        }
        super.saveConfig()
        LOGGER.exiting(LobbyMain::class, "saveConfig")
    }

    /**
     * Schedules a repeating task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncRepeatingTask
     */
    private fun BukkitScheduler.scheduleSyncRepeatingTask(task: ITask) {
        LOGGER.entering(LobbyMain::class, "scheduleSyncRepeatingTask", task)
        tasks[task] = runTaskTimer(this@LobbyMain, task, task.delay, task.period)
        LOGGER.exiting(LobbyMain::class, "scheduleSyncRepeatingTask")
    }

    /**
     * Schedules a delayed task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncDelayedTask
     */
    private fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask) {
        LOGGER.entering(LobbyMain::class, "scheduleSyncDelayedTask", task)
        tasks[task] = runTaskLater(this@LobbyMain, task, task.delay)
        LOGGER.exiting(LobbyMain::class, "scheduleSyncDelayedTask")
    }


    /**
     * Schedules an asynchronous, periodic task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.runTaskTimerAsynchronously
     */
    private fun BukkitScheduler.runTaskTimerAsynchronously(task: ITask) {
        LOGGER.entering(LobbyMain::class, "runTaskTimerAsynchronously", task)
        tasks[task] = runTaskTimerAsynchronously(this@LobbyMain, task, task.delay, task.period)
        LOGGER.exiting(LobbyMain::class, "runTaskTimerAsynchronously")
    }

    companion object {
        private lateinit var backingInstance: LobbyMain

        /**
         * Common instance of this [LobbyMain] plugin.
         */
        val instance: LobbyMain
            get() = backingInstance
        /**
         * The latest version of the configuration.
         * Used in [upgradeConfig].
         */
        const val configVersion = 3

    }

}
