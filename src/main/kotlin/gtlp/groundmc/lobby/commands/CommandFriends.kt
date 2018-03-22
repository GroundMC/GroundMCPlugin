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

    override fun getCommandHelp(locale: Locale) = I18n.getString("command.friends.help", locale)

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
