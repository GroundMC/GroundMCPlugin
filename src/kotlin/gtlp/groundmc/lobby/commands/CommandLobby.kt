package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.I18nUtils
import gtlp.groundmc.lobby.util.NBTItemExt
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*
import kotlin.concurrent.thread

class CommandLobby : ILobbyCommand {
    override val name: String = "lobby"

    override fun getCommandHelp(locale: Locale) = arrayOf(I18n.getString("commandlobby.help.1", locale),
            I18n.getString("commandlobby.help.2", locale),
            I18n.getString("commandlobby.help.3", locale))

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
                    sender.sendMessage(getCommandHelp(I18nUtils.getLocaleFromCommandSender(sender)))
                    return true
                }
                "debug" -> {
                    if (sender is Player) {
                        Relationships.addRelationship(sender, Bukkit.getServer().getPlayer(args[1]))
                    }
                    return true
                }
                else -> {
                    sender.sendMessage(getCommandHelp(I18nUtils.getLocaleFromCommandSender(sender)))
                    return false
                }
            }
        }
        return false
    }

    private fun addItem(sender: CommandSender): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN.id)) {
                thread {
                    val view = sender.openInventory(LobbyInventory.TEMPLATE_INVENTORY)
                    sender.sendMessage(I18n.getString("commandlobby.30seconds", sender.spigot().locale))
                    for (i in 0..30) {
                        if (sender.openInventory != view) {
                            break
                        }
                        Thread.sleep(1000)
                    }
                    saveTemplate()
                    sender.sendMessage(I18n.getString("commandlobby.inventorydone", sender.spigot().locale))
                    if (sender.openInventory == view) {
                        view.close()
                    }
                    for ((player, inventories) in LobbyMain.lobbyInventoryMap) {
                        inventories.lobbyInventory = LobbyInventory.create(player)
                    }
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
            if (sender.hasPermission(Permission.ADMIN.id) && args.size >= 2 && !args[1].isNullOrBlank()) {
                val nbtItem = NBTItemExt(sender.inventory.itemInMainHand)
                nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
                nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)
                nbtItem.setDouble(NBTIdentifier.LOC_X, sender.location.x)
                nbtItem.setDouble(NBTIdentifier.LOC_Y, sender.location.y)
                nbtItem.setDouble(NBTIdentifier.LOC_Z, sender.location.z)
                nbtItem.setDouble(NBTIdentifier.ROT_X, sender.location.yaw.toDouble())
                nbtItem.setDouble(NBTIdentifier.ROT_Y, sender.location.pitch.toDouble())
                nbtItem.setString(NBTIdentifier.LOC_WORLD, sender.location.world.name)
                nbtItem.displayName = args.sliceArray(IntRange(1, args.size - 1)).reduce { left, right -> left + " " + right }
                sender.inventory.itemInMainHand = nbtItem.item

                val string = I18n.getString("commandlobby.placeitem", sender.spigot().locale)
                val strList = string.split("|")
                val msg = TextComponent(strList[0])
                val clickComponent = TextComponent(strList[1])
                clickComponent.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/lobby additem")
                msg.addExtra(clickComponent)
                msg.addExtra(strList[2])
                sender.spigot().sendMessage(msg)
                return true
            } else if (!sender.hasPermission("groundmc.lobby.admin")) {
                sender.sendMessage(I18n.getString("nopermission", sender.spigot().locale))
            }
        } else {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        return false
    }

    /**
     * Saves the template in the plugin-wide configuration
     */
    private fun saveTemplate() {
        LobbyMain.instance?.config?.set("inventory.content", LobbyInventory.TEMPLATE_INVENTORY.contents)
        LobbyMain.instance?.saveConfig()
    }

}
