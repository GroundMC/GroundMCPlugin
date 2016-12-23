package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enum.RelationshipLevel
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by Marvin on 21.12.2016.
 */
class CommandFriends : ILobbyCommand {
    override val name: String = "friends"

    override fun getCommandHelp(locale: Locale): Array<String> = arrayOf("Nope, no help ;)")

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (sender is Player) {
            val friends = Relationships.getRelationships(sender)
            for (level in RelationshipLevel.values()) {
                friends.filter { it.key == level }.let {
                    if (it.isNotEmpty()) {
                        sender.sendMessage(it.values.map { it -> it.user2.name }.joinToString(prefix = I18n.getString(level.i18nKey, sender.spigot().locale)))
                    }
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