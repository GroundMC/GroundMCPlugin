package gtlp.groundmc.lobby.registry

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.commands.ILobbyCommand
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit

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
        Bukkit.getServer().getPluginCommand(cmd.name).executor = cmd
        Bukkit.getServer().getPluginCommand(cmd.name).tabCompleter = cmd
        LobbyMain.logger.exiting(LobbyCommandRegistry::class, "registerCommand")
    }
}
