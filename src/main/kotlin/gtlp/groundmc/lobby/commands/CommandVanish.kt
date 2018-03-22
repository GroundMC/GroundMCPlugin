/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.hasPermission
import kotlinx.coroutines.experimental.async
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.util.*

/**
 * Command to let player's vanish from the sight of other players
 */
class CommandVanish : ILobbyCommand {
    override val name = "vanish"

    override fun getCommandHelp(locale: Locale) = "Vanishes"

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandVanish::class, "onCommand")
        if (sender is Player) {
            if (sender.hasPermission(Permission.VANISH)) {
                async {
                    transaction {
                        val newVanish = !Users.select { Users.id eq sender.uniqueId }.first()[Users.vanishStatus]
                        Users.update({ Users.id eq sender.uniqueId }) {
                            it[Users.vanishStatus] = newVanish
                        }
                        commit()
                        when (newVanish) {
                            true -> sender.sendMessage(I18n.getString("vanish.on", sender.locale))
                            false -> sender.sendMessage(I18n.getString("vanish.off", sender.locale))
                        }
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
