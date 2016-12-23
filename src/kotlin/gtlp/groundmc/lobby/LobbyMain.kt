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
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.createMissingTablesAndColumns
import org.jetbrains.exposed.sql.transactions.transaction
import org.mcstats.Metrics
import java.io.IOException


class LobbyMain : JavaPlugin() {

    override fun onEnable() {
        instance = this
        loadConfig()
        Database.connect("jdbc:h2:" + dataFolder.absolutePath + "/database", driver = "org.h2.Driver")
        transaction {
            createMissingTablesAndColumns(Meta, Users, Relationships)
            Meta.upgradeDatabase()
        }
        Bukkit.getServer().pluginManager.registerEvents(EntityEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(InventoryClickEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(MiscEventListener(), this)
        Bukkit.getServer().pluginManager.registerEvents(PlayerEventListener(), this)
        registerCommands()
        Bukkit.getServer().scheduler.scheduleSyncDelayedTask(SetRulesTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(ApplyPlayerEffectsTask)
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(HidePlayersTask)
        hubWorld?.difficulty = Difficulty.PEACEFUL

        try {
            val metrics = Metrics(this)
            metrics.start()
        } catch (e: IOException) {
            // Failed to submit the stats :-(
        }

    }

    private fun loadConfig() {
        config.addDefault("inventory.content", listOf<ItemStack>())
        config.addDefault("hub.world", Bukkit.getWorlds()[0].name)
        config.options().copyDefaults(true)
        saveDefaultConfig()
        if (config.contains("inventory.content") && config.get("inventory.content") is List<*>) {
            @Suppress("unchecked_cast")
            LobbyInventory.TEMPLATE_INVENTORY.contents = (config.get("inventory.content") as List<ItemStack>).toTypedArray()
        }
        hubWorld = Bukkit.getWorlds().firstOrNull { it.name == config.getString("hub.world") }
        if (hubWorld == null) {
            hubWorld = Bukkit.getWorlds().first()
        }
    }

    private fun registerCommands() {
        LobbyCommandRegistry.registerCommand(CommandLobby())
        LobbyCommandRegistry.registerCommand(CommandVanish())
        LobbyCommandRegistry.registerCommand(CommandCoins())
        LobbyCommandRegistry.registerCommand(CommandFriend())
        LobbyCommandRegistry.registerCommand(CommandFriends())
    }

    override fun onDisable() {
        saveConfig()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (LobbyCommandRegistry.hasCommand(command.name)) {
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
        return scheduleSyncRepeatingTask(this@LobbyMain, task, task.delay, task.period)
    }

    fun BukkitScheduler.scheduleSyncDelayedTask(task: ITask): Int {
        return scheduleSyncDelayedTask(this@LobbyMain, task, task.delay)
    }

    companion object {
        val lobbyInventoryMap = mutableMapOf<HumanEntity, LobbyInventoryHolder>()
        var hubWorld: World? = null

        /**
         * Set holding players that want their chat to be silent
         */
        val SILENCED_PLAYERS = mutableSetOf<Player>()

        /**
         * Common instance of this [LobbyMain] plugin.
         */
        var instance: LobbyMain? = null
    }

}
