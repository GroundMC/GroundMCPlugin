package gtlp.groundmc.lobby.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import java.util.*

/**
 * Interface for commands compatible with the {@link LobbyCommandRegistry}
 */
interface ILobbyCommand {

    /**
     * Name of the command (used as id)
     */
    val name: String

    /**
     * Message(s) that list help content for this command
     */
    fun getCommandHelp(locale: Locale): Array<String>

    /**
     * Generates and returns a list of possible autocompletion entries
     *
     * @param sender the sender of the command
     * @param command the command to get the completion for
     * @param alias the alias used for this command, if an alias was used
     * @param args all arguments including the one to complete
     *
     * @return a list of possible autocompletion entries
     */
    fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>?

    /**
     *Executes a given command and returns whether the command was valid
     *
     * @param sender the sender that invoked the command, could be a dummy
     * @param command the command that has been invoked
     * @param label the alias used to invoke this command
     * @param args the arguments passed on to the command
     *
     * @return whether or not the command was valid
     */
    fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean
}