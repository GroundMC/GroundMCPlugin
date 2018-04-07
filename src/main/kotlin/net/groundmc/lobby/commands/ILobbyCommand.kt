package net.groundmc.lobby.commands

import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import java.util.*

/**
 * Interface for commands compatible with the {@link LobbyCommandRegistry}
 */
interface ILobbyCommand : CommandExecutor, TabCompleter {

    /**
     * Name of the command (used as id)
     */
    val name: String

    /**
     * Message(s) that list help content for this command
     */
    fun getCommandHelp(locale: Locale): String?
}
