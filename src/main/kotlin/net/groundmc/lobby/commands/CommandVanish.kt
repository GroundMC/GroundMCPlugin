package net.groundmc.lobby.commands

import kotlinx.coroutines.launch
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.Permission
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.hasPermission
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.*

/**
 * Command to let player's vanish from the sight of other players
 */
object CommandVanish : ILobbyCommand {
    override val name = "vanish"

    override fun getCommandHelp(locale: Locale) = "Vanishes"

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LOGGER.entering(CommandVanish::class, "onCommand", sender, command, label, args?.joinToString())
        if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18NStrings.COMMAND_PLAYERONLY.get(sender))
            return true
        }
        if (sender is Player) {
            if (!sender.hasPermission(Permission.VANISH)) {
                sender.sendMessage(I18NStrings.NOPERMISSION.get(sender))
            }
            LobbyMain.instance.scope.launch {
                val newVanish = !Users[sender][Users.vanishStatus]
                transaction(LobbyMain.instance.database) {
                    Users.update({ Users.id eq sender.uniqueId }) {
                        it[vanishStatus] = newVanish
                    }
                    commit()
                }
                Users.refresh(sender)
                when (newVanish) {
                    true -> sender.sendMessage(I18NStrings.VANISH_ON.get(sender))
                    false -> sender.sendMessage(I18NStrings.VANISH_OFF.get(sender))
                }
            }
            return true
        }
        return false
    }
}
