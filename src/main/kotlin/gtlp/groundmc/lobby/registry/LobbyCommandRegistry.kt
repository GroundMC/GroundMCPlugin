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

package gtlp.groundmc.lobby.registry

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.commands.ILobbyCommand
import gtlp.groundmc.lobby.util.I18nUtils
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import org.bukkit.help.HelpTopic

/**
 * Registry where all commands are saved.
 * Used by [LobbyMain]
 */
object LobbyCommandRegistry {
    /**
     * Registers the [org.bukkit.command.CommandExecutor] and
     * [org.bukkit.command.TabCompleter] for the given [ILobbyCommand]
     *
     * @param cmd the command to register
     */
    fun registerCommand(cmd: ILobbyCommand) {
        LobbyMain.logger.entering(LobbyCommandRegistry::class, "registerCommand")
        LobbyMain.logger.config("Registering command: ${cmd.name}")
        Bukkit.getServer().getPluginCommand(cmd.name).executor = cmd
        Bukkit.getServer().getPluginCommand(cmd.name).tabCompleter = cmd
        Bukkit.getServer().helpMap.addTopic(object : HelpTopic() {
            override fun canSee(player: CommandSender) = true
            override fun getName() = cmd.name
            override fun getFullText(forWho: CommandSender) =
                    cmd.getCommandHelp(I18nUtils.getLocaleFromCommandSender(forWho))
        })
        LobbyMain.logger.exiting(LobbyCommandRegistry::class, "registerCommand")
    }
}
