package gtlp.groundmc.lobby

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import de.tr7zw.itemnbtapi.NBTReflectionUtil
import gtlp.groundmc.lobby.commands.*
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.event.EntityEventListener
import gtlp.groundmc.lobby.event.InventoryClickEventListener
import gtlp.groundmc.lobby.event.MiscEventListener
import gtlp.groundmc.lobby.event.PlayerEventListener
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.registry.LobbyCommandRegistry
import gtlp.groundmc.lobby.task.*
import gtlp.groundmc.lobby.util.*
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.Location
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
import java.io.PrintWriter
import java.io.StringWriter
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.util.*
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger


class LobbyMain : JavaPlugin() {

    init {
        logger.entering(LobbyMain::class, "init")
        val logFileDirectory = File("${dataFolder.absolutePath}/logs")
        if (!logFileDirectory.exists()) {
            logFileDirectory.mkdir()
        }
        val logHandler = FileHandler("$logFileDirectory/groundmc.%g.log", 5.megabytes, 10).apply {
            level = Level.FINEST
            formatter = object : java.util.logging.Formatter() {

                val date = Date()
                val format = "%1\$tF %1\$tT %3\$s: [%2\$s] %4\$s%5\$s%n"

                override fun format(record: LogRecord): String {
                    date.time = record.millis

                    var source: String
                    if (record.sourceClassName != null) {
                        source = record.sourceClassName
                        if (record.sourceMethodName != null) {
                            source += " " + record.sourceMethodName
                        }
                    } else {
                        source = record.loggerName
                    }

                    var throwable = ""
                    if (record.thrown != null) {
                        val sw = StringWriter()
                        val pw = PrintWriter(sw)
                        pw.println()
                        record.thrown.printStackTrace(pw)
                        pw.close()
                        throwable = sw.toString()
                        sw.close()
                    }

                    return format.format(date, source, record.level.localizedName, formatMessage(record), throwable)
                }
            }
        }
        logger.addHandler(logHandler)
        if (exposedLogger is JDK14LoggerAdapter) {
            val fLogger = JDK14LoggerAdapter::class.java.getDeclaredField("logger")
            fLogger.isAccessible = true
            (fLogger.get(exposedLogger) as Logger).addHandler(logHandler)
        }
        logger.exiting(LobbyMain::class, "init")
    }

    override fun onEnable() {
        logger.entering(LobbyMain::class, "onEnable")
        instance = Optional.of(this)
        registerGsonHandlers()
        createDefaultConfig()
        upgradeConfig()
        loadConfig()
        logger.finer("Loading database...")
        Database.connect(config.getString("database.url")
                .replace("\$dataFolder", dataFolder.absolutePath)
                , config.getString("database.driver"), config.getString("database.username", ""), config.getString("database.password", ""))
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
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(LobbyUpdateTask)

        logger.finer("Setting difficulty of the hub world to peaceful")
        hubLocation.get().world.difficulty = Difficulty.PEACEFUL
        logger.exiting(LobbyMain::class, "onEnable")
    }

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

        config.addDefault("version", configVersion)

        config.options().copyDefaults(true)
        saveDefaultConfig()
        logger.exiting(LobbyMain::class, "createDefaultConfig")
    }

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

    override fun onDisable() {
        logger.entering(LobbyMain::class, "onDisable")
        logger.info("Saving configuration and disabling...")
        saveConfig()
        logger.exiting(LobbyMain::class, "onDisable")
    }

    override fun saveConfig() {
        logger.entering(LobbyMain::class, "saveConfig")
        when (config["inventory.content"]) {
            is List<*> -> config["inventory.content"] = (config["inventory.content"] as List<*>).map { if (it != Items.FILLER.item) it else null }
            is Array<*> -> config["inventory.content"] = (config["inventory.content"] as Array<*>).map { if (it != Items.FILLER.item) it else null }.toTypedArray()
        }
        super.saveConfig()
        logger.exiting(LobbyMain::class, "saveConfig")
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (LobbyCommandRegistry.hasCommand(command.name)) {
            LobbyMain.logger.finest("${sender.name} executed ${command.name}")
            return LobbyCommandRegistry.getCommand(command.name)!!.execute(sender, command, label, args)
        }
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (LobbyCommandRegistry.hasCommand(command.name)) {
            return LobbyCommandRegistry.getCommand(command.name)?.getTabCompletion(sender, command, alias, args)
        }
        return null
    }

    fun BukkitScheduler.scheduleSyncRepeatingTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncRepeatingTask")
        tasks.put(task, scheduleSyncRepeatingTask(this@LobbyMain, task, task.delay, task.period))
    }

    fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask) {
        logger.entering(LobbyMain::class, "scheduleSyncDelayedTask")
        tasks.put(task, scheduleSyncDelayedTask(this@LobbyMain, task, task.delay))
    }

    companion object {
        val lobbyInventoryMap = mutableMapOf<Player, LobbyInventoryHolder>()
        var hubLocation: Optional<Location> = Optional.empty()

        val tasks = emptyMap<ITask, Int>().toMutableMap()

        /**
         * Set holding players that want their chat to be silent
         */
        val SILENCED_PLAYERS = mutableSetOf<Player>()

        /**
         * Common instance of this [LobbyMain] plugin.
         */
        var instance: Optional<LobbyMain> = Optional.empty()

        var dailyCoins = 0
        val logger: Logger
            get() = instance.get().logger

        val configVersion = 2
    }

}
