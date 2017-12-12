package gtlp.groundmc.lobby.commands

import com.joestelmach.natty.Parser
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Events
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.task.SetRulesTask
import gtlp.groundmc.lobby.util.*
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerTeleportEvent
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import java.io.File
import java.util.*
import java.util.logging.FileHandler
import kotlin.concurrent.thread

/**
 * The `/lobby` command.
 * Allows players to teleport back to the lobby and obtain help.
 * This also allows administrators to add more teleport destinations.
 * Additionally, events can be added to the scoreboard as well.
 */
class CommandLobby : ILobbyCommand {

    override val name = "globby"

    override fun getCommandHelp(locale: Locale) = I18n.getStrings("command.lobby.help.1", "command.lobby.help.2", "command.lobby.help.3", locale = locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("", "additem", "maketp", "help", "debug").apply {
                    if (sender.hasPermission(Permission.ADMIN)) {
                        add("set")
                        add("event")
                    }
                }.filter { it.startsWith(args.last()) }.sorted()
                2 -> if (args[0] == "maketp") {
                    return listOf("name")
                }
            }
        }
        return null
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "onCommand")
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
                "set" -> {
                    return setLobby(sender)
                }
                "event" -> {
                    return handleEvent(sender, args.sliceArray(1 until args.size))
                }
                else -> {
                    sender.sendMessage(getCommandHelp(I18nUtils.getLocaleFromCommandSender(sender)))
                    return false
                }
            }
        } else if (sender is Player) {
            sender.teleport(Meta[Config.HUB_LOCATION] as Location, PlayerTeleportEvent.TeleportCause.COMMAND)
            return true
        }
        return false
    }

    /**
     * Sets the hub location to the [sender]s current location.
     *
     * @param sender the player that sent the command
     * @return is always true to not trigger the command help of Spigot.
     */
    private fun setLobby(sender: CommandSender): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "setLobby")
        if (sender.hasPermission(Permission.ADMIN) && sender is Player) {
            Meta[Config.HUB_LOCATION] = sender.location
            Bukkit.getServer().scheduler.scheduleSyncDelayedTask(LobbyMain.instance, SetRulesTask)
            sender.sendMessage(I18n.getString("command.lobby.location_set", sender.locale))
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.locale))
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
        if (sender.hasPermission(Permission.ADMIN)) {
            LobbyMain.instance.logger.info("Flushing log and forcing a rotate...")

            val handler = LobbyMain.instance.logger.handlers.first {
                it is FileHandler
            } as FileHandler
            val clazz = handler.javaClass
            clazz.getDeclaredMethod("rotate").apply { isAccessible = true }.invoke(handler)

            @Suppress("unchecked_cast")
            val file = clazz.getDeclaredField("files").apply { isAccessible = true }.get(handler) as Array<File>

            sender.sendMessage("See the log file ${file[1].canonicalPath}")
            LobbyMain.instance.logger.info("Log finished.")
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.locale))
        }
        return true
    }

    /**
     * Opens the [LobbyInventory.TEMPLATE_INVENTORY] for the [sender] and allows
     * administrators to add items to, so that they can be used in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM].
     *
     * @param sender the player that sent the command
     * @return `true` when the items have been successfully, `false` otherwise.
     */
    private fun addItem(sender: CommandSender): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "addItem")
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN)) {
                thread {
                    val view = sender.openInventory(LobbyInventory.TEMPLATE_INVENTORY)
                    sender.sendMessage(I18n.getString("command.lobby.30seconds", sender.locale))
                    for (i in 0..30) {
                        if (sender.openInventory != view) {
                            break
                        }
                        Thread.sleep(1000)
                    }
                    saveTemplate()
                    sender.sendMessage(I18n.getString("command.lobby.inventorydone", sender.locale))
                    if (sender.openInventory == view) {
                        view.close()
                    }
                }
                return true
            } else {
                sender.sendMessage(I18n.getString("nopermission", sender.locale))
            }
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        return false
    }

    /**
     * Modifies the item the [sender] has in his hand, so that it can be used as
     * a fast travel item in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM].
     *
     * Uses the current [sender]s position for the teleport destination.
     *
     * @param args the arguments that accompany this command
     * @param sender the player that sent the command
     * @return `true` when the item has successfully been modified, `false` otherwise.
     */
    private fun makeTp(args: Array<String>, sender: CommandSender): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "makeTp")
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN) && args.size >= 2 && !args[1].isBlank()) {
                val nbtItem = NBTItemExt(sender.inventory.itemInMainHand)
                nbtItem.apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)
                    setObject(NBTIdentifier.TP_LOC, sender.location)
                    displayName = args.sliceArray(1 until args.size).reduce { left, right -> "$left $right" }
                    sender.inventory.itemInMainHand = item
                }
                val string = I18n.getString("command.lobby.placeitem", sender.locale)!!
                val strList = string.split("|")
                val msg = TextComponent(strList[0])
                val clickComponent = TextComponent(strList[1])
                clickComponent.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/$name additem")
                msg.addExtra(clickComponent)
                msg.addExtra(strList[2])
                sender.spigot().sendMessage(msg)
                LobbyMain.logger.finest("${sender.name} created a teleport item: $nbtItem")
                return true
            } else if (!sender.hasPermission("groundmc.lobby.admin")) {
                sender.sendMessage(I18n.getString("nopermission", sender.locale))
            }
        } else {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        return false
    }

    /**
     * Handles the event subset of this command.
     *
     * Called with no arguments, this returns just the titles of the currently
     * active events.
     *
     * Called with `unset` as the first argument and an integer as the second
     * argument, this will disable the n-th active event.
     *
     * Called with `add` as the first argument, this command will add a new event
     * according to the following syntax:
     * `/<command> event add "date and time of the beginning of the event"
     * "date and time of the end of the event" "the title or description of the event"`.
     * The date and time can be absolute as well as relative to the current time.
     *
     * @param args the arguments that accompany this command
     * @param sender the player that sent the command
     * @return `true` when the command has been handled successfully, `false` otherwise.
     */
    private fun handleEvent(sender: CommandSender, args: Array<String>): Boolean {
        LobbyMain.logger.entering(CommandLobby::class, "handleEvent")
        if (args.isEmpty()) {
            Events.getCurrentEventTitles().forEach {
                sender.sendMessage(it)
            }
            return true
        } else if (args.size >= 2) {
            if (!sender.hasPermission(Permission.ADMIN)) {
                sender.sendMessage(I18n.getString("nopermission", I18nUtils.getLocaleFromCommandSender(sender)))
                return false
            }
            when (args[0]) {
                "unset" -> {
                    val index = args[1].toIntOrNull() ?: return false
                    sender.sendMessage(I18n.getString("event.unset")?.format(Events.disable(index)[Events.title]))
                    return true
                }
                "add" -> {
                    val matches = mutableListOf<String>()
                    val joinedArgs = args.sliceArray(1 until args.size).joinToString(" ")
                    "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'".toPattern().matcher(joinedArgs).apply {
                        while (find()) {
                            when {
                                group(1) != null -> matches.add(group(1))
                                group(2) != null -> matches.add(group(2))
                                else -> matches.add(group())
                            }
                        }
                    }
                    val parser = Parser()
                    val beginDate = DateTime(parser.parse(matches[0]).first().dates.first())
                    val endDate = DateTime(parser.parse(matches[1]).first().dates.first())
                    val title = matches[2]
                    if (Events.newEvent(title, sender, beginDate, endDate)) {
                        sender.sendMessage(I18n.getString("event.create", I18nUtils.getLocaleFromCommandSender(sender))
                                ?.format(title, ISODateTimeFormat.dateHourMinuteSecond().print(beginDate),
                                        ISODateTimeFormat.dateHourMinuteSecond().print(endDate)))
                        return true
                    }
                }
            }
        }
        return false
    }

    /**
     * Saves the template in the plugin-wide configuration
     */
    private fun saveTemplate() {
        LobbyMain.logger.entering(CommandLobby::class, "saveTemplate")
        Meta[Config.INVENTORY_CONTENT] = LobbyInventory.TEMPLATE_INVENTORY.contents
        LobbyMain.logger.exiting(CommandLobby::class, "saveTemplate")
    }

}
