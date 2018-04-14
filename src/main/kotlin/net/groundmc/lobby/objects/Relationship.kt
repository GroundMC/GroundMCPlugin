package net.groundmc.lobby.objects

import com.google.common.base.MoreObjects
import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.lib.player.CloudPlayer
import net.groundmc.lobby.database.table.Users
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import org.joda.time.DateTime
import java.util.*

/**
 * Class holding a relationship
 */
data class Relationship constructor(
        /**
         * The first user of this relationship.
         * Usually the initiator.
         */
        val user1: Friend,

        /**
         * The second user of this relationship.
         */
        val user2: Friend,

        /**
         * The time at which this relationship was created.
         */
        val since: DateTime = DateTime.now()
) {

    /**
     * The constructor to create a [Relationship] out of two usernames.
     */
    constructor(user1Name: String, user2Name: String, since: DateTime = DateTime.now()) : this(Users.byName(user1Name)!!, Users.byName(user2Name)!!, since)

    /**
     * The constructor to create a [Relationship] out of two users' [UUID]s.
     */
    constructor(user1Id: UUID, user2Id: UUID, since: DateTime = DateTime.now()) : this(Friend.fromUniqueId(user1Id), Friend.fromUniqueId(user2Id), since)

    override fun toString() = MoreObjects.toStringHelper(this)
            .add("user1", user1)
            .add("user2", user2)
            .add("since", since)
            .toString()
}

class Friend(val name: String, val uniqueId: UUID) {

    val offlinePlayer: OfflinePlayer
        get() = Bukkit.getOfflinePlayer(uniqueId)

    val player: Player?
        get() = Bukkit.getPlayer(uniqueId)

    val cloudPlayer: CloudPlayer?
        get() = CloudAPI.getInstance().getOnlinePlayer(uniqueId)

    override fun toString() = MoreObjects.toStringHelper(this)
            .add("name", name)
            .add("uniqueId", uniqueId)
            .toString()

    companion object {
        fun fromPlayer(player: OfflinePlayer) = Friend(player.name, player.uniqueId)

        fun fromUniqueId(uniqueId: UUID) = Friend(Users[uniqueId][Users.lastName], uniqueId)
    }
}
