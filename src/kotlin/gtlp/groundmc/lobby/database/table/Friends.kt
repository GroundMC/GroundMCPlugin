package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.*

/**
 * Table to hold players' settings and friends
 */
object Friends : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
    val friends = text("friends")

    fun addFriend(player: Player, friend: Player) {
        transaction {
            Friends.update({ id.eq(player.uniqueId) }) {
                var friendList = readFriendList(player)

                if (!friendList.contains(friend.uniqueId)) {
                    friendList = friendList.plus(friend.uniqueId)
                }
                it[friends] = prepareFriendList(friendList)
            }
            commit()
            Friends.update({ id.eq(friend.uniqueId) }) {
                var friendList = readFriendList(friend)
                if (!friendList.contains(player.uniqueId)) {
                    friendList = friendList.plus(player.uniqueId)
                }
                it[friends] = prepareFriendList(friendList)
            }
            commit()
            flushCache()
        }
    }

    fun readFriendList(player: Player): Array<UUID> {
        val friendListText = select { id.eq(player.uniqueId) }.first()[friends]

        val bais = ByteArrayInputStream(Base64.getDecoder().decode(friendListText.toByteArray(Charsets.UTF_8)))
        val ois = ObjectInputStream(bais)

        @Suppress("unchecked_cast")
        val friendList = ois.readObject() as Array<UUID>
        return friendList
    }

    fun prepareFriendList(friendList: Array<UUID>): String {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(friendList)

        return Base64.getEncoder().encodeToString(baos.toByteArray())
    }

    fun areFriends(player: Player, friend: Player): Boolean {
        var isFriend: Boolean = false
        transaction {
            val friendList = readFriendList(player)

            isFriend = friendList.contains(friend.uniqueId)
        }
        return isFriend
    }
}