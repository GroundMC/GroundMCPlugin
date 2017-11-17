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
     * A map of command strings to their respective command object.
     */
    private val commands = mutableMapOf<String, ILobbyCommand>()

    /**
     * Registers a command by adding it to the map.
     *
     * @param cmd the command to register
     */
    fun registerCommand(cmd: ILobbyCommand) {
        LobbyMain.logger.entering(LobbyCommandRegistry::class, "registerCommand")

        Bukkit.getServer().getPluginCommand(cmd.name).executor = cmd
        Bukkit.getServer().getPluginCommand(cmd.name).tabCompleter = cmd
        //commands[cmd.name] = cmd
        LobbyMain.logger.exiting(LobbyCommandRegistry::class, "registerCommand")
    }

    /**
     * Gets the command for the command string
     *
     * @param name the name of the command to get
     * @return the command for the [name]
     */
    fun getCommand(name: String): ILobbyCommand? {
        LobbyMain.logger.entering(LobbyCommandRegistry::class, "getCommand")
        return commands[name]
    }

    /**
     * Checks whether this registry contains a command.
     *
     * @param name the name of the command to get
     * @return the command for the [name]
     */
    fun hasCommand(name: String): Boolean {
        LobbyMain.logger.entering(LobbyCommandRegistry::class, "hasCommand")
        return commands.containsKey(name)
    }
}
