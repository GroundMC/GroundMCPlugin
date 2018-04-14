package net.groundmc.lobby.commands

import com.joestelmach.natty.Parser
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Events
import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.enums.Permission
import net.groundmc.lobby.i18n.I18n
import net.groundmc.lobby.i18n.I18nUtils
import net.groundmc.lobby.inventory.LobbyInventory
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.task.SetRulesTask
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.exiting
import net.groundmc.lobby.util.hasPermission
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
object CommandLobby : ILobbyCommand {

    override val name = "globby"

    override fun getCommandHelp(locale: Locale) = I18n.getString("command.lobby.help", locale = locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        LOGGER.entering(CommandLobby::class, "onTabComplete", sender, command, alias, args?.joinToString())
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("", "additem", "maketp", "help", "debug", "event").apply {
                    if (sender.hasPermission(Permission.ADMIN)) {
                        add("set")
                        add("config")
                    }
                }.filter { it.startsWith(args[0]) }.sorted()
                2 -> when (args[0]) {
                    "maketp" -> return listOf("name")
                    "config" -> return Config.keys.map { it.key }.toList().filter { it.startsWith(args[1]) }.sorted()
                }
                3 -> when (args[0]) {
                    "config" -> {
                        val config = Config.keys.firstOrNull { it.key == args[1] }
                                ?: return emptyList()
                        return when (config.type) {
                            Boolean::class.javaObjectType -> listOf("true", "false")
                            Byte::class.javaObjectType, Short::class.javaObjectType, Int::class.javaObjectType, Long::class.javaObjectType -> listOf("0")
                            Float::class.javaObjectType, Double::class.javaObjectType -> listOf("0.0")
                            else -> emptyList()
                        }
                    }
                }
            }
        }
        return null
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LOGGER.entering(CommandLobby::class, "onCommand", sender, command, label, args?.joinToString())
        LOGGER.finest("${sender.name} issued $command - ${args?.joinToString()
                ?: "null"}")
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
                "config" -> {
                    return handleConfig(sender, args.sliceArray(1 until args.size))
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
        LOGGER.entering(CommandLobby::class, "setLobby", sender)
        if (sender.hasPermission(Permission.ADMIN) && sender is Player) {
            Meta[Config.HUB_LOCATION] = sender.location
            Bukkit.getServer().scheduler.scheduleSyncDelayedTask(LobbyMain.instance, SetRulesTask)
            sender.sendMessage(I18n.getString("command.lobby.location_set", sender.locale))
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.locale))
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
        }
        LOGGER.exiting(CommandLobby::class, "setLobby")
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
        LOGGER.entering(CommandLobby::class, "debug", sender)
        if (sender.hasPermission(Permission.ADMIN)) {
            LOGGER.info("Flushing log and forcing a rotate...")

            val handler = LobbyMain.instance.logger.handlers.first {
                it is FileHandler
            } as FileHandler
            val clazz = handler.javaClass
            clazz.getDeclaredMethod("rotate").apply { isAccessible = true }.invoke(handler)

            @Suppress("unchecked_cast")
            val file = clazz.getDeclaredField("files").apply { isAccessible = true }.get(handler) as Array<File>

            sender.sendMessage("See the log file ${file[1].canonicalPath}")
            LOGGER.info("Log finished.")
        } else if (sender is Player) {
            sender.sendMessage(I18n.getString("lobby.nopermission", sender.locale))
        }
        return true
    }

    /**
     * Opens the [LobbyInventory.TEMPLATE_INVENTORY] for the [sender] and allows
     * administrators to add items to, so that they can be used in the [net.groundmc.lobby.objects.Items.COMPASS_ITEM].
     *
     * @param sender the player that sent the command
     * @return `true` when the items have been successfully, `false` otherwise.
     */
    private fun addItem(sender: CommandSender): Boolean {
        LOGGER.entering(CommandLobby::class, "addItem", sender)
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
     * a fast travel item in the [net.groundmc.lobby.objects.Items.COMPASS_ITEM].
     *
     * Uses the current [sender]s position for the teleport destination.
     *
     * @param args the arguments that accompany this command
     * @param sender the player that sent the command
     * @return `true` when the item has successfully been modified, `false` otherwise.
     */
    private fun makeTp(args: Array<String>, sender: CommandSender): Boolean {
        LOGGER.entering(CommandLobby::class, "makeTp", args.joinToString(), sender)
        if (sender is Player) {
            if (sender.hasPermission(Permission.ADMIN) && args.size >= 2) {
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
                sender.sendMessage(msg)
                LOGGER.finest("${sender.name} created a teleport item: $nbtItem")
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
        LOGGER.entering(CommandLobby::class, "handleEvent", sender, args.joinToString())
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
                "disable" -> {
                    val index = args[1].toIntOrNull() ?: return false
                    val event = Events.disable(index)
                    sender.sendMessage(I18n.getString("event.unset")?.format(event[Events.title]))
                    LOGGER.fine("Disabled event $event")
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
     * This subsection handles the overall plugin configuration.
     *
     * When called with no additional parameter, it returns the value of the
     * configuration key.
     *
     * When called with a second parameter, it sets the configuration value to
     * the supplied value and returns a confirmation, that the value has been
     * accepted and is in use immediately.
     *
     * The administrator is expected to enter a value of a type, that is compatible
     * with the given configuration key.
     *
     * @param args the arguments that accompany this command
     * @param sender the player that sent the command
     * @return `true` when the command has been handled successfully, `false` otherwise.
     */
    private fun handleConfig(sender: CommandSender, args: Array<String>): Boolean {
        LOGGER.entering(CommandLobby::class, "handleConfig", sender, args)
        if (!sender.hasPermission(Permission.ADMIN)) {
            sender.sendMessage(I18n.getString("nopermission", I18nUtils.getLocaleFromCommandSender(sender)))
            return false
        }
        if (args.size == 1) {
            val config = Config.keys.firstOrNull { it.key == args[0] }
            if (config != null) {
                sender.sendMessage("%s: %s".format(config, Meta[config]))
            }
        } else if (args.size == 2) {
            val config = Config.keys.firstOrNull { it.key == args[0] }
            if (config != null) {
                Meta[config] = args[1]
                sender.sendMessage("%s: %s".format(config, Meta[config]))
            }
        }
        return true
    }

    /**
     * Saves the template in the plugin-wide configuration
     */
    private fun saveTemplate() {
        LOGGER.entering(CommandLobby::class, "saveTemplate")
        Meta[Config.INVENTORY_CONTENT] = LobbyInventory.TEMPLATE_INVENTORY.contents
        LOGGER.exiting(CommandLobby::class, "saveTemplate")
    }

}
