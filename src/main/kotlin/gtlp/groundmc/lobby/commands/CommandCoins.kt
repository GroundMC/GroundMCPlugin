package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.entering
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Command to manage coins, a virtual currency of literally no value
 */
class CommandCoins : ILobbyCommand {
    override val name: String = "coins"

    override fun getCommandHelp(locale: Locale): Array<String?> = arrayOf(I18n.getString("command.coins.help", locale))

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandCoins::class, "execute")
        if (sender is Player) {
            sender.sendMessage(I18n.getString("command.coins.currency", sender.spigot().locale) + ": " + Users.getPlayer(sender)[Users.coins])
            return true
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly"))
            return true
        }
        return false
    }

}