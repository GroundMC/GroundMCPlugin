package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder.Companion.recreateInventories
import gtlp.groundmc.lobby.util.*
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerTeleportEvent
import java.io.File
import java.util.*
import java.util.logging.FileHandler
import kotlin.concurrent.thread

/**
 * The `/lobby` command.
 * Allows players to teleport back to the lobby and obtain help.
 * This also allows administrators to add more teleport destinations.
 */
class CommandLobby : ILobbyCommand {
    override val name: String = "lobby"

    override fun getCommandHelp(locale: Locale) = I18n.getStrings("command.lobby.help.1", "command.lobby.help.2", "command.lobby.help.3", locale = locale)

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("", "additem", "maketp", "help", "debug").filter { it.startsWith(args.last()) }.sorted()
                2 -> if (args[0] == "maketp") {
                    return listOf("name")
                }
            }
        }
        return null
    }

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "execute")
        LobbyMain.logger.finest("${sender.name} issued $command - ${args?.joinToString() ?: "null"}")
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
            //Not in help for a reason
                "set" -> {
                    return setLobby(sender)
                }
                else -> {
                    sender.sendMessage(getCommandHelp(I18nUtils.getLocaleFromCommandSender(sender)))
                    return false
                }
            }
        } else if (sender is Player) {
            sender.teleport(LobbyMain.hubLocation.get(), PlayerTeleportEvent.TeleportCause.COMMAND)
            return true
        }
        return false
    }

    /**
     * Sets the [LobbyMain.hubLocation] to the [sender]s current location.
     *
     * @param sender the player that sent the command
     * @return is always true to not trigger the command help of Spigot.
     */
    private fun setLobby(sender: CommandSender): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "setLobby")
        if (sender.hasPermission(Permission.ADMIN.id) && sender is Player) {
            LobbyMain.hubLocation = Optional.of(sender.location)
            LobbyMain.instance.ifPresent {
                it.config["hub"] = sender.location
                it.saveConfig()
            }
            val locale = if (sender is Player) sender.spigot().locale else Locale.getDefault().toString()
            sender.sendMessage(I18n.getString("command.lobby.location_set", locale))
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.spigot().locale))
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        LobbyMain.logger.exiting(CommandLobby::class, "setLobby")
        return true
    }

    /**
     * *Forcefully* rotates the log file and tells the player the location of
     * the last log file that can be sent for assistance to the creator of this
     * plugin.
     *
     * @param sender the player that sent the command
     * @return is always true to not trigger the command help of Spigot.
     */
    private fun debug(sender: CommandSender): Boolean {
        if (sender.hasPermission(Permission.ADMIN.id)) {
            LobbyMain.instance.ifPresent {
                it.logger.info("Flushing log and forcing a rotate...")

                val handler = it.logger.handlers.first {
                    it is FileHandler
                } as FileHandler
                val clazz = handler.javaClass
                clazz.getDeclaredMethod("rotate").apply { isAccessible = true }.invoke(handler)

                @Suppress("unchecked_cast")
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
        LobbyMain.logger.entering(CommandLobby::class, "addItem")
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
                    recreateInventories()
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
        LobbyMain.logger.entering(CommandLobby::class, "makeTp")
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN.id) && args.size >= 2 && !args[1].isNullOrBlank()) {
                val nbtItem = NBTItemExt(sender.inventory.itemInMainHand)
                nbtItem.apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)
                    setObject(NBTIdentifier.TP_LOC, sender.location)
                    displayName = args.sliceArray(IntRange(1, args.size - 1)).reduce { left, right -> "$left $right" }
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
            it.config["inventory.content"] = LobbyInventory.TEMPLATE_INVENTORY.contents
            it.saveConfig()
        }
        LobbyMain.logger.exiting(CommandLobby::class, "saveTemplate")
    }

}
