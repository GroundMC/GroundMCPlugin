package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.database.table.Users
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.joda.time.DateTime
import java.io.Serializable
import java.util.*

/**
 * Class holding a relationship
 */
data class Relationship constructor(val user1: OfflinePlayer, val user2: OfflinePlayer, val since: DateTime = DateTime.now()) : Serializable {

    constructor(user1Name: String, user2Name: String, since: DateTime = DateTime.now()) : this(Users.byName(user1Name)!![Users.id], Users.byName(user2Name)!![Users.id], since)
    constructor(user1Id: UUID, user2Id: UUID, since: DateTime = DateTime.now()) : this(Bukkit.getOfflinePlayer(user1Id), Bukkit.getOfflinePlayer(user2Id), since)

}