package net.groundmc.lobby.commands

import me.BukkitPVP.PointsAPI.PointsAPI
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.util.entering
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

    override fun getCommandHelp(locale: Locale) = I18NStrings.COMMAND_COINS_HELP.get(locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandCoins::class, "onCommand")
        if (sender is Player) {
            sender.sendMessage(I18NStrings.COMMAND_COINS_CURRENCY.get(sender) + ": " + PointsAPI.getPoints(sender))
            return true
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18NStrings.COMMAND_PLAYERONLY.get())
            return true
        }
        return false
    }

}
