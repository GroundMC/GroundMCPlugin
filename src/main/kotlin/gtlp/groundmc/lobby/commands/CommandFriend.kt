package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.util.I18NStrings
import gtlp.groundmc.lobby.util.I18nUtils
import gtlp.groundmc.lobby.util.entering
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.joda.time.format.DateTimeFormat
import java.util.*

/**
 * Collection of commands related to friends management
 */
class CommandFriend : ILobbyCommand {
    override val name = "friend"

    override fun getCommandHelp(locale: Locale) = I18NStrings.COMMAND_FRIEND_HELP.get(locale)

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("add", "remove", "status", "online").filter { it.startsWith(args.last()) }
                2 -> when (args[0]) {
                    "add" -> return Bukkit.getOnlinePlayers().map { it -> it.name }.filter { it.startsWith(args.last()) }
                    "update" -> return friendsStartWith(sender, args)
                    "remove" -> return friendsStartWith(sender, args)
                    "status" -> return friendsStartWith(sender, args)
                }
            }
        }
        return null
    }

    /**
     * Returns a list of friends that start with a certain [CharSequence]
     *
     * @param sender the sender to find the friends of
     * @param args the arguments given to this command, uses [kotlin.collections.last] to determine the beginning of the names
     *
     * @return a list of all friends that begin with [kotlin.collections.last]
     */
    private fun friendsStartWith(sender: CommandSender, args: Array<out String>): List<String>? {
        if (sender is Player) {
            val friendsList = Relationships.getRelationships(sender)
            return friendsList.map { it -> it.user2.name }.filter { it.startsWith(args.last()) }
        }
        return null
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        LobbyMain.logger.entering(CommandFriend::class, "onCommand")
        if (sender !is Player) {
            sender.sendMessage(I18NStrings.COMMAND_PLAYERONLY.get())
            return true
        }
        if (args != null && args.isNotEmpty()) {
            when (args[0]) {
                "add" -> return addFriend(sender, args)
                "remove" -> return removeFriend(sender, args)
                "status" -> return sendStatusMessage(sender, args)
                "online" -> return sendOnlineFriends(sender)
            }

        }
        return false
    }

    /**
     * Send a list of online friends to the [sender].
     *
     * @param sender the initiator of the command
     *
     * @return whether the command executed successfully (always true).
     */
    private fun sendOnlineFriends(sender: Player): Boolean {
        LobbyMain.logger.entering(CommandFriend::class, "sendOnlineFriends")
        val friendsList = Relationships.getRelationships(sender)
        val onlinePlayers = Bukkit.getOnlinePlayers()
        val onlineFriends = friendsList.filter { it.user2.toOfflinePlayer() in onlinePlayers }
        if (onlineFriends.isEmpty()) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_NO_FRIENDS_ONLINE.get(sender))
            return true
        }
        with(onlineFriends) {
            sender.sendMessage(joinToString(prefix = I18NStrings.RELATIONSHIP_FRIEND.get(sender) + ": ", transform = { it.user2.name }))
        }
        return true
    }

    /**
     * Sends the status of a relationship between [sender] and [args] [1] to [sender].
     *
     * @param sender the requester of the status message
     * @param args the arguments passed to this command, requires 2 to be successful ("status" and the name of the friend).
     *
     * @return whether the command executed successfully.
     */
    private fun sendStatusMessage(sender: Player, args: Array<String>): Boolean {
        LobbyMain.logger.entering(CommandFriend::class, "sendStatusMessage")
        if (args.size < 2) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_SPECIFY_PLAYER_STATUS.get(sender))
            return false
        } else {
            val friend = Users.byName(args[1])
            if (friend == null) {
                sender.sendMessage(I18NStrings.COMMAND_FRIEND_NOT_FOUND.get(sender))
                return true
            }
            val relationship = Relationships.getRelationship(sender.uniqueId, friend[Users.id])
            if (relationship != null) {
                sender.sendMessage(I18NStrings.RELATIONSHIP_STATUS.format(sender, args[1],
                        relationship.since.toString(DateTimeFormat.mediumDate().withLocale(I18nUtils.getLocaleFromCommandSender(sender)))))
                return true
            } else {
                sender.sendMessage(I18NStrings.RELATIONSHIP_NOT_RELATED.format(sender, args[1]))
                return true
            }
        }
    }

    /**
     * Removes a relationship between two players.
     *
     * @param sender the initiator of the relationship removal
     * @param args the arguments passed to this command, requires 2 to be successful ("remove" and the name of the friend).
     *
     * @return whether the command executed successfully.
     */
    private fun removeFriend(sender: Player, args: Array<String>): Boolean {
        LobbyMain.logger.entering(CommandFriend::class, "removeFriend")
        if (args.size < 2) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_SPECIFY_PLAYER.get(sender))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_PLAYER_NOT_FOUND.format(sender, args[1]))
            return true
        }
        if (Relationships.areFriends(sender, friend)) {
            Relationships.removeRelationship(sender, friend)
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_NO_LONGER_RELATED.format(sender, friend.name))
            return true
        } else {
            sender.sendMessage(I18NStrings.COMMAND_FRIENDS_NO_FRIENDS.format(sender, friend.name))
            return true
        }
    }

    /**
     * Adds a relationship between two players.
     *
     * @param sender the initiator of the relationship addition
     * @param args the arguments passed to this command, requires 2 to be successful ("add" and the name of the friend).
     *
     * @return whether the command executed successfully.
     */
    private fun addFriend(sender: Player, args: Array<String>): Boolean {
        LobbyMain.logger.entering(CommandFriend::class, "addFriend")
        if (args.size == 1) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_SPECIFY_PLAYER.get(sender))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_PLAYER_NOT_FOUND.format(sender, args[1]))
            return true
        }
        if (sender.name == args[1]) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_CANT_ADD_YOURSELF.get(sender))
            return true
        }
        if (Relationships.areFriends(sender, friend)) {
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_ALREADY_FRIENDS.format(sender, args[1]))
            return true
        } else {
            LobbyMain.logger.fine("${sender.name} tried to add ${friend.name} as a friend")
            Relationships.addRelationship(sender, friend)
            sender.sendMessage(I18NStrings.COMMAND_FRIEND_SUCCESSFULLY_ADDED.format(sender, args[1]))
            return true
        }
    }
}
