package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.commands.CommandLobby
import gtlp.groundmc.lobby.registry.LobbyCommandRegistry
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType


//for vanish: http://codereview.stackexchange.com/q/145674/66955

class LobbyMain : JavaPlugin() {

    override fun onEnable() {
        instance = this
        loadConfig()
        Bukkit.getServer().pluginManager.registerEvents(LobbyEventListener(), this)
        registerCommands()
        Bukkit.getServer().scheduler.scheduleSyncDelayedTask(this, {
            hubWorld?.apply {
                setGameRuleValue("doDaylightCycle", "false")
                setGameRuleValue("doEntityDrops", "false")
                setGameRuleValue("doFireTick", "false")
                setGameRuleValue("doMobLoot", "false")
                setGameRuleValue("doMobSpawning", "false")
                setGameRuleValue("doTileDrops", "false")
                setGameRuleValue("doWeatherCycle", "false")
                setGameRuleValue("mobGriefing", "false")
                setGameRuleValue("randomTickSpeed", "0")
                setGameRuleValue("showDeathMessages", "false")
                setGameRuleValue("reducedDebugInfo", "true")
            }
        })
        Bukkit.getServer().scheduler.scheduleSyncRepeatingTask(this, {
            Bukkit.getServer().onlinePlayers.filter { it.world == hubWorld }.forEach {
                it.addPotionEffect(PotionEffect(PotionEffectType.HEAL, 200, 1, false, false), true)
                it.addPotionEffect(PotionEffect(PotionEffectType.SATURATION, 200, 1, false, false), true)
            }
        }, 20L, 20L)
        hubWorld?.difficulty = Difficulty.PEACEFUL
    }

    private fun loadConfig() {
        config.addDefault("inventory.content", listOf<ItemStack>())
        config.addDefault("hub.world", Bukkit.getWorlds()[0].name)
        config.options().copyDefaults(true)
        saveDefaultConfig()
        if (config.contains("inventory.content") && config.get("inventory.content") is List<*>) {
            @Suppress("unchecked_cast")
            val content = (config.get("inventory.content") as List<ItemStack>).toTypedArray<ItemStack>()
            TEMPLATE_INVENTORY.contents = content
        }
        hubWorld = Bukkit.getWorlds().first { it.name == config.getString("hub.world") }
    }

    private fun registerCommands() {
        LobbyCommandRegistry.registerCommand(CommandLobby())
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

    companion object {
        var inventoryMap = mutableMapOf<HumanEntity, Inventory>()
        var hubWorld: World? = null
        val SILENCED_PLAYERS = mutableSetOf<Player>()
        val TEMPLATE_INVENTORY = Bukkit.createInventory(null, 6 * 9, "Lobby")!!
        var instance: LobbyMain? = null
    }

}
