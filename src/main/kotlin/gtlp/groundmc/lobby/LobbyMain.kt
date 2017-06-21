package gtlp.groundmc.lobby

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.tr7zw.itemnbtapi.NBTReflectionUtil
import gtlp.groundmc.lobby.commands.*
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.event.listener.EntityEventListener
import gtlp.groundmc.lobby.event.listener.InventoryClickEventListener
import gtlp.groundmc.lobby.event.listener.MiscEventListener
import gtlp.groundmc.lobby.event.listener.PlayerEventListener
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.registry.LobbyCommandRegistry
import gtlp.groundmc.lobby.task.*
import gtlp.groundmc.lobby.util.*
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.configuration.MemorySection
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.exposedLogger
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.impl.JDK14LoggerAdapter
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.*
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
            (fLogger.get(exposedLogger) as Logger).addHandler(logHandler)
        }
        logger.exiting(LobbyMain::class, "init")
    }

    /**
     * Called when this plugin is enabled
     */
    override fun onEnable() {
        logger.entering(LobbyMain::class, "onEnable")
        instance = Optional.of(this)
        registerGsonHandlers()
        createDefaultConfig()
        upgradeConfig()
        loadConfig()
        logger.finer("Loading database...")
        Database.connect(config.getString("database.url")
                .replace("\$dataFolder", dataFolder.absolutePath),
                config.getString("database.driver"), config.getString("database.username", ""),
                config.getString("database.password", ""))
        transaction {
            createMissingTablesAndColumns(Meta, Users, Relationships)
            Meta.upgradeDatabase()
        }
        logger.finer("Registering events...")
        Bukkit.getServer().pluginManager.registerEvents(EntityEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(InventoryClickEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(MiscEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(PlayerEventListener(), this)
        registerCommands()

        logger.finer("Scheduling tasks...")
        Bukkit.getServer().scheduler.scheduleSyncDelayedTask(SetRulesTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(ApplyPlayerEffectsTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(HidePlayersTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(MonitorLocaleTask)

        logger.finer("Setting difficulty of the hub world to peaceful")
        hubLocation.get().world.difficulty = Difficulty.PEACEFUL
        logger.exiting(LobbyMain::class, "onEnable")
    }

    /**
     * Registers a custom GSON handler to handle the [Location] class.
     */
    private fun registerGsonHandlers() {
        logger.entering(LobbyMain::class, "registerGsonHandlers")
        val fGson = NBTReflectionUtil::class.java.getDeclaredField("gson")
        fGson.isAccessible = true

        val modifiersField = Field::class.java.getDeclaredField("modifiers")
        modifiersField.isAccessible = true
        modifiersField.setInt(fGson, fGson.modifiers and Modifier.FINAL.inv())

        val fFactories = Gson::class.java.getDeclaredField("factories")
        fFactories.isAccessible = true
        val factories = fFactories.get(fGson.get(null)) as List<*>

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
            LobbyInventory.TEMPLATE_INVENTORY.contents = (config["inventory.content"] as List<ItemStack>).toTypedArray()

            (0..LobbyInventory.TEMPLATE_INVENTORY.contents.size - 1).forEach { i ->
                if (LobbyInventory.TEMPLATE_INVENTORY.getItem(i) == null) {
                    LobbyInventory.TEMPLATE_INVENTORY.setItem(i, Items.FILLER.item)
                }
            }
        }
        // Get lobby location
        hubLocation = Optional.of(config.get("hub") as Location)
        dailyCoins = config.getInt("coins.dailyAmount")
        logger.info("Setting logger verbosity to ${config.getString("log.verbosity", "FINEST")}")
        logger.level = Level.parse(config.getString("log.verbosity", "FINEST"))
        logger.finer("Loaded config.")
        logger.exiting(LobbyMain::class, "loadConfig")
    }

    /**
     * Initializes the config file for first use.
     */
    private fun createDefaultConfig() {
        logger.entering(LobbyMain::class, "createDefaultConfig")
        config.addDefault("inventory.content", listOf<ItemStack>())

        config.addDefault("hub", Bukkit.getWorlds().first().spawnLocation)

        config.addDefault("coins.dailyAmount", 100)

        config.addDefault("log.verbosity", "FINEST")

        config.addDefault("slowchat.enabled", true)
        config.addDefault("slowchat.timeout", 5)

        config.addDefault("database.username", "")
        config.addDefault("database.password", "")
        config.addDefault("database.driver", "org.h2.Driver")
        config.addDefault("database.url", "jdbc:h2:\$dataFolder/database")

        config.addDefault("jumppads.material", listOf(Material.GOLD_PLATE))
        config.addDefault("jumppads.multiplier", 3.0)
        config.addDefault("jumppads.y", 1.5)

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
        logger.finer("Registering commands...")
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
     * Executes the given command, returning its success
     *
     * @param sender Source of the command
     * @param command Command which was executed
     * @param label Alias of the command which was used
     * @param args Passed command arguments
     * @return true if a valid command, otherwise false
     */
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (LobbyCommandRegistry.hasCommand(command.name)) {
            LobbyMain.logger.finest("${sender.name} executed ${command.name}")
            return LobbyCommandRegistry.getCommand(command.name)!!.execute(sender, command, label, args)
        }
        return false
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender Source of the command.  For players tab-completing a
     *     command inside of a command block, this will be the player, not
     *     the command block.
     * @param command Command which was executed
     * @param alias The alias used
     * @param args The arguments passed to the command, including final
     *     partial argument to be completed and command label
     * @return A List of possible completions for the final argument, or null
     *     to default to the command executor
     */
    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (LobbyCommandRegistry.hasCommand(command.name)) {
            return LobbyCommandRegistry.getCommand(command.name)?.getTabCompletion(sender, command, alias, args)
        }
        return null
    }

    /**
     * Schedules a repeating task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncRepeatingTask
     */
    fun BukkitScheduler.scheduleSyncRepeatingTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncRepeatingTask")
        tasks.put(task, scheduleSyncRepeatingTask(this@LobbyMain, task, task.delay, task.period))
    }

    /**
     * Schedules a delayed task.
     *
     * @param task the task to schedule.
     * @see BukkitScheduler.scheduleSyncDelayedTask
     */
    fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncDelayedTask")
        tasks.put(task, scheduleSyncDelayedTask(this@LobbyMain, task, task.delay))
    }

    companion object {
        /**
         * A map of [Player]s to their [LobbyInventoryHolder]s.
         */
        val lobbyInventoryMap = mutableMapOf<Player, LobbyInventoryHolder>()

        /**
         * Variable to hold the [Location] of the hub/lobby.
         */
        var hubLocation: Optional<Location> = Optional.empty()

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
        var instance: Optional<LobbyMain> = Optional.empty()

        /**
         * The variable holding the amount of coins a player gets every day.
         */
        var dailyCoins = 0

        /**
         * The [Logger] that is created in the init block.
         */
        val logger: Logger
            get() = instance.get().logger

        /**
         * The latest version of the configuration.
         * Used in [upgradeConfig].
         */
        const val configVersion = 3
    }

}
