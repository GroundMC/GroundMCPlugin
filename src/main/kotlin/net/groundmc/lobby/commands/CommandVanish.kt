package net.groundmc.lobby.commands

import kotlinx.coroutines.experimental.async
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.Permission
import net.groundmc.lobby.i18n.I18n
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
        if (sender is Player) {
            if (sender.hasPermission(Permission.VANISH)) {
                async {
                    val newVanish = !Users[sender][Users.vanishStatus]
                    transaction {
                        Users.update({ Users.id eq sender.uniqueId }) {
                            it[Users.vanishStatus] = newVanish
                        }
                        commit()
                    }
                    Users.refresh(sender)
                    when (newVanish) {
                        true -> sender.sendMessage(I18n.getString("vanish.on", sender.locale))
                        false -> sender.sendMessage(I18n.getString("vanish.off", sender.locale))
                    }
                }
                return true
            } else {
                sender.sendMessage(I18n.getString("nopermission", sender.locale))
            }
        } else if (sender is ConsoleCommandSender) {
            sender.sendMessage(I18n.getString("command.playeronly", Locale.getDefault()))
            return true
        }
        return false
    }
}
