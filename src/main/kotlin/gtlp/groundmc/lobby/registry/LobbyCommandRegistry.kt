package gtlp.groundmc.lobby.registry

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.commands.ILobbyCommand
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting

/**
 * Registry where all commands are saved.
 * Used by [LobbyMain]
 */
class LobbyCommandRegistry {

    companion object {
        private val commands = mutableMapOf<String, ILobbyCommand>()

        fun registerCommand(cmd: ILobbyCommand) {
            LobbyMain.logger.entering(Companion::class, "registerCommand")
            commands[cmd.name] = cmd
            LobbyMain.logger.exiting(Companion::class, "registerCommand")
        }

        fun getCommand(name: String): ILobbyCommand? {
            LobbyMain.logger.entering(Companion::class, "getCommand")
            return commands[name]
        }

        fun hasCommand(name: String): Boolean {
            LobbyMain.logger.entering(Companion::class, "hasCommand")
            return commands.containsKey(name)
        }
    }
}