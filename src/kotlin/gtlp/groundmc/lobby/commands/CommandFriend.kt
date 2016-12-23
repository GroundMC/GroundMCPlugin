package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enum.RelationshipLevel
import gtlp.groundmc.lobby.util.I18n
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

/**
 * Created by Marvin on 23.12.2016.
 */
class CommandFriend : ILobbyCommand {
    override val name = "friend"

    override fun getCommandHelp(locale: Locale): Array<String?> = I18n.getStrings(listOf("commandfriend.help.1", "commandfriend.help.2", "commandfriend.help.3", "commandfriend.help.4", "commandfriend.help.5"), locale)

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
                3 -> when (args[0]) {
                    "add" -> return RelationshipLevel.values().map { it -> it.name }.filter { it.startsWith(args.last()) }
                    "update" -> return RelationshipLevel.values().map { it -> it.name }.filter { it.startsWith(args.last()) }
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
            return friendsList.map { it -> it.value.user2.name }.filter { it.startsWith(args.last()) }
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
            sender.sendMessage(I18n.getString("commandfriend.specify_player_update", sender.spigot().locale))
            return false
        }
        if (args.size < 3) {
            sender.sendMessage(I18n.getString("commandfriend.specify_level_update", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[2])
        if (friend == null) {
            sender.sendMessage(I18n.getString("commandfriend.player_not_found", sender.spigot().locale))
            return true
        }
        val relationshipLevel: RelationshipLevel?
        try {
            relationshipLevel = RelationshipLevel.valueOf(args[2])
        } catch (exception: IllegalArgumentException) {
            sender.sendMessage(I18n.getString("commandfriend.unkown_relationship_level", sender.spigot().locale)!!.format(args[2]))
            sender.sendMessage(I18n.getString("commandfriend.valid_levels", sender.spigot().locale) + RelationshipLevel.values().map { it -> it.name })
            return true
        }
        Relationships.updateRelationshipLevel(sender, friend, relationshipLevel)
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
        val onlineFriends = friendsList.filter { it.value.user2 in onlinePlayers }
        if (onlineFriends.isEmpty()) {
            sender.sendMessage(I18n.getString("commandfriend.no_friends_online", sender.spigot().locale))
            return true
        }
        for (level in RelationshipLevel.values()) {
            onlineFriends.filter { it.key == level }.let {
                sender.sendMessage(it.values.joinToString(prefix = I18n.getString(level.i18nKey, sender.spigot().locale) + ": "))
            }
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
            sender.sendMessage(I18n.getString("commandfriend.specify_player_status"))
            return false
        } else {
            val relationship = Relationships.getRelationship(sender, Bukkit.getPlayer(args[1]))
            if (relationship != null) {
                sender.sendMessage(I18n.getString("relationship.status", sender.spigot().locale)!!.format(args[1],
                        I18n.getString(relationship.level.i18nKey, sender.spigot().locale)))
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
            sender.sendMessage(I18n.getString("commandfriend.specify_player", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18n.getString("commandfriend.player_not_found", sender.spigot().locale)!!.format(args[1]))
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            Relationships.removeRelationship(sender, friend)
            sender.sendMessage(I18n.getString("commandfriend.no_longer_related")!!.format(friend.name))
            return true
        } else {
            sender.sendMessage(I18n.getString("commandfriend.no_friends")!!.format(friend.name))
            return true
        }
    }

    /**
     * Adds a relationship between two players.
     *
     * @param sender the initiator of the relationship addition
     * @param args the arguments passed to this command, requires 2 to be successful, a third one is optional ("add", the name of the friend and the relationship level).
     *
     * @return whether the command executed successfully.
     */
    private fun addFriend(sender: Player, args: Array<String>): Boolean {
        if (args.size == 1) {
            sender.sendMessage(I18n.getString("commandfriend.specify_player", sender.spigot().locale))
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage(I18n.getString("commandfriend.player_not_found", sender.spigot().locale)!!.format(args[1]))
            return true
        }
        if (friend.name == args[1]) {
            sender.sendMessage(I18n.getString("commandfriend.cant_add_yourself", sender.spigot().locale))
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            sender.sendMessage(I18n.getString("commandfriend.already_friends", sender.spigot().locale)!!.format(args[1]))
            val stringList = I18n.getString("commandfriend.update_relationship", sender.spigot().locale)!!.split('|')
            val msg = TextComponent(stringList[0])
            msg.addExtra(TextComponent(stringList[1]).apply { clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "friend update") })
            msg.addExtra(stringList[2])
            sender.spigot().sendMessage(msg)
            return true
        } else {
            var relationshipLevel: RelationshipLevel? = null
            if (args.size >= 3) {
                try {
                    relationshipLevel = RelationshipLevel.valueOf(args[2])
                } catch (exception: IllegalArgumentException) {
                    sender.sendMessage(I18n.getString("commandfriend.unkown_relationship_level", sender.spigot().locale)!!.format(args[2]))
                    sender.sendMessage(I18n.getString("commandfriend.valid_levels", sender.spigot().locale) + RelationshipLevel.values().map { it -> it.name })
                    return true
                }
            }
            if (relationshipLevel == null) {
                relationshipLevel = RelationshipLevel.FRIEND
            }
            Relationships.addRelationship(sender, friend, relationshipLevel)
            sender.sendMessage(I18n.getString("commandfriend.successfully_added", sender.spigot().locale)!!.format(args[1], I18n.getString(relationshipLevel.i18nKey, sender.spigot().locale)))
            return true
        }
    }
}