package gtlp.groundmc.lobby

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
import gtlp.groundmc.lobby.task.ApplyPlayerEffectsTask
import gtlp.groundmc.lobby.task.HidePlayersTask
import gtlp.groundmc.lobby.task.ITask
import gtlp.groundmc.lobby.task.SetRulesTask
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import gtlp.groundmc.lobby.util.megabytes
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.configuration.MemorySection
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.util.*
import java.util.logging.FileHandler
import java.util.logging.Level
import java.util.logging.Logger
import java.util.logging.SimpleFormatter


class LobbyMain : JavaPlugin() {

    init {
        logger.entering(LobbyMain::class, "init")
        val logFileDirectory = File("${dataFolder.absolutePath}/logs")
        if (!logFileDirectory.exists()) {
            logFileDirectory.mkdir()
        }
        val logHandler = FileHandler("$logFileDirectory/groundmc.%g.log", 5.megabytes, 10).apply {
            level = Level.FINEST
            formatter = SimpleFormatter()
        }
        logger.addHandler(logHandler)
        logger.exiting(LobbyMain::class, "init")
    }

    override fun onEnable() {
        logger.entering(LobbyMain::class, "onEnable")
        instance = Optional.of(this)
        upgradeConfig()
        loadConfig()
        logger.finer("Loading database...")
        Database.connect("jdbc:h2:" + dataFolder.absolutePath + "/database", driver = "org.h2.Driver")
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

        logger.finer("Setting difficulty of the hub world to peaceful")
        hubLocation.get().world.difficulty = Difficulty.PEACEFUL
        logger.exiting(LobbyMain::class, "onEnable")
    }

    private fun upgradeConfig() {
        logger.entering(LobbyMain::class, "upgradeConfig")
        logger.info("Upgrading configuration...")
        if (config["hub"] is MemorySection) {
            logger.warning("Upgraded 'hub', please set new hub location!")
            config["hub"] = Bukkit.getWorlds().first().spawnLocation
        }
        logger.exiting(LobbyMain::class, "upgradeConfig")
    }

    private fun loadConfig() {
        logger.entering(LobbyMain::class, "loadConfig")
        config.addDefault("inventory.content", listOf<ItemStack>())
        config.addDefault("hub", Bukkit.getWorlds().first().spawnLocation)
        config.addDefault("coins.dailyAmount", 100)
        config.addDefault("log.verbosity", "FINEST")
        config.addDefault("slowchat.enabled", true)
        config.addDefault("slowchat.timeout", 5)
        config.options().copyDefaults(true)
        saveDefaultConfig()
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

    fun BukkitScheduler.scheduleSyncRepeatingTask(task: ITask): Int {
        logger.entering(LobbyMain::class, "scheduleSyncRepeatingTask")
        return scheduleSyncRepeatingTask(this@LobbyMain, task, task.delay, task.period)
    }

    fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask): Int {
        logger.entering(LobbyMain::class, "scheduleSyncDelayedTask")
        return scheduleSyncDelayedTask(this@LobbyMain, task, task.delay)
    }

    companion object {
        val lobbyInventoryMap = mutableMapOf<HumanEntity, LobbyInventoryHolder>()
        var hubLocation: Optional<Location> = Optional.empty()

        /**
         * Set holding players that want their chat to be silent
         */
        val SILENCED_PLAYERS = mutableSetOf<Player>()

        /**
         * Common instance of this [LobbyMain] plugin.
         */
        var instance: Optional<LobbyMain> = Optional.empty()

        var dailyCoins = 100
        val logger: Logger
            get() = instance.get().logger
    }

}
