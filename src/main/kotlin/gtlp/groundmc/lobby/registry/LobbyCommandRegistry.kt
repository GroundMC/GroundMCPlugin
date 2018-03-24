

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
