package net.groundmc.lobby.commands

import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.i18n.I18n
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

    override fun getCommandHelp(locale: Locale) = I18n.getString("command.friends.help", locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LOGGER.entering(CommandFriends::class, "onCommand", sender, command, label, args?.joinToString())
        LOGGER.finest("Getting friends of ${sender.name}")
        if (sender is Player) {
            val friends = Relationships.getRelationships(sender.uniqueId)
            if (friends.isEmpty()) {
                sender.sendMessage(I18n.getString("command.friends.no_friends", sender.locale))
                return true
            }
            friends.let {
                if (it.isNotEmpty()) {
                    sender.sendMessage(String.format("%2\$s: %1\$s", it.joinToString { it.user2.name }, it.size))
                }
            }
            return true
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly"))
            return true
        }
        return false
    }
}
