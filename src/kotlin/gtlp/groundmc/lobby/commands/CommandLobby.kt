package gtlp.groundmc.lobby.commands

import de.tr7zw.itemnbtapi.NBTItem
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.GMCType
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.Permission
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.*
import kotlin.concurrent.thread


class CommandLobby : ILobbyCommand {
    override val name: String = "lobby"

    override val commandHelp = arrayOf(ChatColor.YELLOW.toString() + "additem" + ChatColor.RESET.toString() + ": Add items to the template inventory",
            ChatColor.YELLOW.toString() + "maketp" + ChatColor.RESET.toString() + ": Make an item ready to be used for teleporting",
            ChatColor.YELLOW.toString() + "help" + ChatColor.RESET.toString() + ": This help")

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("additem", "maketp", "help").filter { it.startsWith(args.last()) }
                2 -> if (args[0] == "maketp") {
                    return listOf("name")
                }
            }
        }
        return null
    }

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (args != null && args.isNotEmpty()) {
            when (args[0]) {
                "maketp" -> {
                    return makeTp(args, sender)
                }
                "additem" -> {
                    return addItem(sender)
                }
                "help" -> {
                    sender.sendMessage(commandHelp)
                    return true
                }
                "debug" -> {
                    saveTemplate()
                    return true
                }
                else -> {
                    sender.sendMessage(commandHelp)
                    return false
                }
            }
        }
        return false
    }

    private fun addItem(sender: CommandSender): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN.toString())) {
                thread {
                    val view = sender.openInventory(LobbyMain.TEMPLATE_INVENTORY)
                    sender.sendMessage(I18n.getString("commandlobby.30seconds", sender.spigot().locale))
                    Thread.sleep(30000)
                    saveTemplate()
                    sender.sendMessage(I18n.getString("commandlobby.inventorydone", sender.spigot().locale))
                    if (sender.openInventory == view) {
                        view.close()
                    }
                    val tempMap = mutableMapOf<HumanEntity, Inventory>()
                    for ((player, inventory) in LobbyMain.inventoryMap) {
                        tempMap[player] = LobbyInventory.cloneInventory(LobbyMain.TEMPLATE_INVENTORY, player)
                    }
                    LobbyMain.inventoryMap.clear()
                    LobbyMain.inventoryMap.putAll(tempMap)
                }
                return true
            } else {
                sender.sendMessage(I18n.getString("nopermission", sender.spigot().locale))
            }
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        return false
    }

    private fun makeTp(args: Array<String>, sender: CommandSender): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN.toString()) && args.size == 2 && !args[1].isNullOrBlank()) {
                val nbtItem = NBTItem(sender.inventory.itemInMainHand)
                nbtItem.setBoolean(LobbyMain.NBT_PREFIX, true)
                nbtItem.setInteger(LobbyMain.NBT_TYPE, GMCType.TP.ordinal)
                nbtItem.setDouble(LobbyMain.NBT_LOC_X, sender.location.x)
                nbtItem.setDouble(LobbyMain.NBT_LOC_Y, sender.location.y)
                nbtItem.setDouble(LobbyMain.NBT_LOC_Z, sender.location.z)
                nbtItem.setString(LobbyMain.NBT_LOC_WORLD, sender.location.world.name)
                val meta = nbtItem.item.itemMeta
                meta.displayName = args[1]
                nbtItem.item.itemMeta = meta
                sender.inventory.itemInMainHand = nbtItem.item
                sender.inventory.itemInMainHand.itemMeta.displayName = args[1]

                sender.sendMessage(I18n.getString("commandlobby.placeitem", sender.spigot().locale))
                return true
            } else if (!sender.hasPermission("groundmc.lobby.admin")) {
                sender.sendMessage(I18n.getString("nopermission", sender.spigot().locale))
            }
        } else {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        return false
    }

    private fun saveTemplate() {
        LobbyMain.instance?.config?.set("inventory.content", LobbyMain.TEMPLATE_INVENTORY.contents)
        LobbyMain.instance?.saveConfig()
    }

}