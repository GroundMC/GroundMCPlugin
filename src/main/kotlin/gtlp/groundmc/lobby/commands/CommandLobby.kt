package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.*
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.io.File
import java.util.*
import java.util.logging.FileHandler
import kotlin.concurrent.thread

class CommandLobby : ILobbyCommand {
    override val name: String = "lobby"

    override fun getCommandHelp(locale: Locale) = I18n.getStrings("command.lobby.help.1", "command.lobby.help.2", "command.lobby.help.3", locale = locale)

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("additem", "maketp", "help", "debug").filter { it.startsWith(args.last()) }.sorted()
                2 -> if (args[0] == "maketp") {
                    return listOf("name")
                }
            }
        }
        return null
    }

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "execute")
        LobbyMain.logger.finest("${sender.name} issued $command - $args")
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
                    return debug(sender)
                }
                else -> {
                    sender.sendMessage(getCommandHelp(I18nUtils.getLocaleFromCommandSender(sender)))
                    return false
                }
            }
        }
        return false
    }

    private fun debug(sender: CommandSender): Boolean {
        if (sender.hasPermission(Permission.ADMIN.id)) {
            LobbyMain.instance.ifPresent {
                it.logger.info("Flushing log and forcing a rotate...")

                val handler = it.logger.handlers.first {
                    it is FileHandler
                } as FileHandler
                val clazz = handler.javaClass
                clazz.getDeclaredMethod("rotate").apply { isAccessible = true }.invoke(handler)

                val file = clazz.getDeclaredField("files").apply { isAccessible = true }.get(handler) as Array<File>

                sender.sendMessage("See the log file ${file[1].canonicalPath}")
                it.logger.info("Log finished.")
            }
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.spigot().locale))
        }
        return true
    }

    private fun addItem(sender: CommandSender): Boolean {
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN.id)) {
                thread {
                    val view = sender.openInventory(LobbyInventory.TEMPLATE_INVENTORY)
                    sender.sendMessage(I18n.getString("command.lobby.30seconds", sender.spigot().locale))
                    for (i in 0..30) {
                        if (sender.openInventory != view) {
                            break
                        }
                        Thread.sleep(1000)
                    }
                    saveTemplate()
                    sender.sendMessage(I18n.getString("command.lobby.inventorydone", sender.spigot().locale))
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
                nbtItem.apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)
                    setDouble(NBTIdentifier.LOC_X, sender.location.x)
                    setDouble(NBTIdentifier.LOC_Y, sender.location.y)
                    setDouble(NBTIdentifier.LOC_Z, sender.location.z)
                    setDouble(NBTIdentifier.ROT_X, sender.location.yaw.toDouble())
                    setDouble(NBTIdentifier.ROT_Y, sender.location.pitch.toDouble())
                    setString(NBTIdentifier.LOC_WORLD, sender.location.world.name)
                    displayName = args.sliceArray(IntRange(1, args.size - 1)).reduce { left, right -> left + " " + right }
                    sender.inventory.itemInMainHand = item
                }
                val string = I18n.getString("command.lobby.placeitem", sender.spigot().locale)!!
                val strList = string.split("|")
                val msg = TextComponent(strList[0])
                val clickComponent = TextComponent(strList[1])
                clickComponent.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/lobby additem")
                msg.addExtra(clickComponent)
                msg.addExtra(strList[2])
                sender.spigot().sendMessage(msg)
                LobbyMain.logger.finest("${sender.name} created a teleport item: $nbtItem")
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
        LobbyMain.logger.entering(CommandLobby::class, "saveTemplate")
        LobbyMain.instance.ifPresent {
            it.config.set("inventory.content", LobbyInventory.TEMPLATE_INVENTORY.contents)
            it.saveConfig()
        }
        LobbyMain.logger.exiting(CommandLobby::class, "saveTemplate")
    }

}
