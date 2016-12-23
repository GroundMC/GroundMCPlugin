package gtlp.groundmc.lobby.commands

import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enum.RelationshipLevel
import gtlp.groundmc.lobby.util.I18n
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

    override fun getCommandHelp(locale: Locale): Array<String> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
                    "add" -> return RelationshipLevel.values().map { it -> I18n.getString(it.i18nKey, if (sender is Player) sender.spigot().locale else Locale.US.toLanguageTag()) }
                }
            }
        }
        return null
    }

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
                "remove" -> return removeFriend(sender, args)
                "status" -> return sendStatusMessage(sender, args)
                "online" -> return sendOnlineFriends(sender, args)
            }

        }
        return false
    }

    private fun sendOnlineFriends(sender: Player, args: Array<String>): Boolean {
        val friendsList = Relationships.getRelationships(sender)
        val onlinePlayers = Bukkit.getOnlinePlayers()
        val onlineFriends = friendsList.filter { it.value.user2 in onlinePlayers }
        for (level in RelationshipLevel.values()) {
            onlineFriends.filter { it.key == level }.let {
                sender.sendMessage(it.values.joinToString(prefix = I18n.getString(level.i18nKey, sender.spigot().locale) + ": "))
            }
        }
        return true
    }

    private fun sendStatusMessage(sender: Player, args: Array<String>): Boolean {
        if (args.size < 2) {
            sender.sendMessage("No player specified")
            return false
        } else {
            val relationship = Relationships.getRelationship(sender, Bukkit.getPlayer(args[1]))
            if (relationship != null) {
                sender.sendMessage("You and ${args[1]} are ${relationship.level.i18nKey}")
                return true
            } else {
                sender.sendMessage("You and ${args[1]} are no friends")
                return true
            }
        }
    }

    private fun removeFriend(sender: Player, args: Array<String>): Boolean {
        if (args.size == 1) {
            sender.sendMessage("Specify player")
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage("Player not found")
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            Relationships.removeRelationship(sender, friend)
            sender.sendMessage("You and $friend are no longer related")
            return true
        } else {
            sender.sendMessage("You and $friend are no friends")
            return true
        }
    }

    private fun addFriend(sender: Player, args: Array<String>): Boolean {
        if (args.size == 1) {
            sender.sendMessage("Specify player")
            return false
        }
        val friend = Bukkit.getPlayer(args[1])
        if (friend == null) {
            sender.sendMessage("Player not found")
            return true
        }
        if (Relationships.areRelated(sender, friend)) {
            sender.sendMessage("Already friends")
            sender.sendMessage("To update relationship use /friend update")
            return true
        } else {
            var relationshipLevel: RelationshipLevel? = null
            if (args.size >= 3) {
                try {
                    relationshipLevel = RelationshipLevel.valueOf(args[2])
                } catch (exception: IllegalArgumentException) {
                    sender.sendMessage("Unknown relationship level")
                    return true
                }
            }
            if (relationshipLevel == null) {
                relationshipLevel = RelationshipLevel.FRIEND
            }
            Relationships.addRelationship(sender, friend, relationshipLevel)
            sender.sendMessage("Successfully added ${friend.name} as $relationshipLevel")
            return true
        }
    }
}