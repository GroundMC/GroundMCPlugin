package net.groundmc.lobby.commands

import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Command to list friends
 */
object CommandFriends : ILobbyCommand {
    override val name: String = "friends"

    override fun getCommandHelp(locale: Locale) = I18NStrings.COMMAND_FRIENDS_HELP.get(locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LOGGER.entering(CommandFriends::class, "onCommand", sender, command, label, args?.joinToString())
        LOGGER.finest("Getting friends of ${sender.name}")
        if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18NStrings.COMMAND_PLAYERONLY.get(sender))
            return true
        }
        if (sender is Player) {
            val friends = Relationships.getRelationships(sender.uniqueId)
            if (friends.isEmpty()) {
                sender.sendMessage(I18NStrings.COMMAND_FRIENDS_NO_FRIENDS.get(sender))
                return true
            }
            friends.let {
                if (it.isNotEmpty()) {
                    sender.sendMessage(String.format("%2\$s: %1\$s", it.joinToString { relationship -> relationship.user2.name }, it.size))
                }
            }
            return true
        }
        return false
    }
}
