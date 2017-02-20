package gtlp.groundmc.lobby.registry

import gtlp.groundmc.lobby.commands.ILobbyCommand

/**
 * Created by Marv1 on 04.10.2016.
 */
class LobbyCommandRegistry {

    companion object {
        private val commands = mutableMapOf<String, ILobbyCommand>()

        fun registerCommand(cmd: ILobbyCommand) {
            commands[cmd.name] = cmd
        }

        fun getCommand(name: String): ILobbyCommand? {
            return commands[name]
        }

        fun hasCommand(name: String): Boolean {
            return commands.containsKey(name)
        }
    }
}