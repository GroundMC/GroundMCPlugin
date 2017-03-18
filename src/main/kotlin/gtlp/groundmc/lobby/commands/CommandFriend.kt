package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.I18nUtils
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
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

    override fun getCommandHelp(locale: Locale): Array<String?> = I18n.getStrings("command.friend.help.1", "command.friend.help.2", "command.friend.help.3", "command.friend.help.4", "command.friend.help.5", locale = locale)

    override fun getTabCompletion(sender: CommandSender, command: Command, alias: String?, args: Array<out String>?): List<String>? {
        if (args != null) {
            when (args.size) {
                1 -> return mutableListOf("add", "update", "remove", "status", "online").filter { it.startsWith(args.last()) }
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

    override fun execute(sender: CommandSender, command: Command, label: String, args: Array<String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage(I18n.getString("command.playeronly"))
            return true
        }
        if (args != null && args.isNotEmpty()) {
            when (args[0]) {
                "add" -> return addFriend(sender, args)
                "update" -> return updateRelationship(sender, args)
                "remove" -> return removeFriend(sender, args)
                "status" -> return sendStatusMessage(sender, args)
                "online" -> return sendOnlineFriends(sender)
            }

        }
        return false
    }

    /**
     * Updates a relationship between two players.
     *
     * @param sender the initiator of the relationship update
     * @param args the arguments passed to this command, requires 3 to be successful ("update", the name of the friend and the new relationship level).
     *
     * @return whether the command executed successfully.
     */
    private fun updateRelationship(sender: Player, args: Array<String>): Boolean {
        if (args.size < 2) {
            sender.sendMessage(I18n.getString("command.friend.specify_player_update", sender.spigot().locale))
            return false
        }
        if (args.size < 3) {
            sender.sendMessage(I18n.getString("command.friend.specify_level_update", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[2])
        if (friend == null) {
            sender.sendMessage(I18n.getString("command.friend.player_not_found", sender.spigot().locale))
            return true
        }
        return true
    }

    /**
     * Send a list of online friends to the [sender].
     *
     * @param sender the initiator of the command
     *
     * @return whether the command executed successfully (always true).
     */
    private fun sendOnlineFriends(sender: Player): Boolean {
        val friendsList = Relationships.getRelationships(sender)
        val onlinePlayers = Bukkit.getOnlinePlayers()
        val onlineFriends = friendsList.filter { it.user2 in onlinePlayers }
        if (onlineFriends.isEmpty()) {
            sender.sendMessage(I18n.getString("command.friend.no_friends_online", sender.spigot().locale))
            return true
        }
        onlineFriends.let {
            sender.sendMessage(it.joinToString(prefix = I18n.getString("relationship.friend", sender.spigot().locale) + ": ", transform = { it -> if (it.user1.uniqueId != sender.uniqueId) it.user1.name else it.user2.name }))
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
        if (args.size < 2) {
            sender.sendMessage(I18n.getString("command.friend.specify_player_status"))
            return false
        } else {
            val friend = Users.byName(name)
            if (friend == null) {
                sender.sendMessage(I18n.getString("command.friend.not_found"))
                return true
            }
            val relationship = Relationships.getRelationship(sender.uniqueId, friend[Users.id])
            if (relationship != null) {
                sender.sendMessage(I18n.getString("relationship.status", sender.spigot().locale)!!.format(args[1],
                        relationship.since.toString(DateTimeFormat.mediumDate().withLocale(I18nUtils.getLocaleFromCommandSender(sender)))))
                return true
            } else {
                sender.sendMessage(I18n.getString("relationship.not_related", sender.spigot().locale)!!.format(args[1]))
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
        if (args.size < 2) {
            sender.sendMessage(I18n.getString("command.friend.specify_player", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18n.getString("command.friend.player_not_found", sender.spigot().locale)!!.format(args[1]))
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            Relationships.removeRelationship(sender, friend)
            sender.sendMessage(I18n.getString("command.friend.no_longer_related")!!.format(friend.name))
            return true
        } else {
            sender.sendMessage(I18n.getString("command.friend.no_friends")!!.format(friend.name))
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
        if (args.size == 1) {
            sender.sendMessage(I18n.getString("command.friend.specify_player", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18n.getString("command.friend.player_not_found", sender.spigot().locale)!!.format(args[1]))
            return true
        }
        if (friend.name == args[1]) {
            sender.sendMessage(I18n.getString("command.friend.cant_add_yourself", sender.spigot().locale))
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            sender.sendMessage(I18n.getString("command.friend.already_friends", sender.spigot().locale)!!.format(args[1]))
            val stringList = I18n.getString("command.friend.update_relationship", sender.spigot().locale)!!.split('|')
            val msg = TextComponent(stringList[0])
            msg.addExtra(TextComponent(stringList[1]).apply { clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "friend update") })
            msg.addExtra(stringList[2])
            sender.spigot().sendMessage(msg)
            return true
        } else {
            Relationships.addRelationship(sender, friend)
            sender.sendMessage(I18n.getString("command.friend.successfully_added", sender.spigot().locale)!!.format(args[1]))
            return true
        }
    }
}