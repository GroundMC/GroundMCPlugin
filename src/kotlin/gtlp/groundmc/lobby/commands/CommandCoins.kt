package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.database.table.Users
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

/**
 * Created by Marvin on 05.12.2016.
 */
class CommandCoins : ILobbyCommand {
    override val name: String = "coins"

    override fun getCommandHelp(locale: Locale): Array<String> = arrayOf("No help, yet.")

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? = null

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (sender is Player) {
            return transaction {
                sender.sendMessage("Coins: " + Users.select(Users.id eq sender.uniqueId).first()[Users.coins])
                return@transaction true
            }
        }
        return false
    }

}