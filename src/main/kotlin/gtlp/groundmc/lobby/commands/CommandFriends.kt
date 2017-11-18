package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.entering
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Command to list friends
 */
class CommandFriends : ILobbyCommand {
    override val name: String = "friends"

    override fun getCommandHelp(locale: Locale): Array<String?> = arrayOf(I18n.getString("command.friends.help", locale))

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandFriends::class, "onCommand")
        LobbyMain.logger.finest("Getting friends of ${sender.name}")
        if (sender is Player) {
            val friends = Relationships.getRelationships(sender)
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