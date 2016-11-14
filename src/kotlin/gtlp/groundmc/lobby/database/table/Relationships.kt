package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.RelationshipLevel
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Table

/**
 * Created by Marv1 on 14.11.2016.
 */
object Relationships : Table() {
    val user1 = uuid("user1").references(Friends.id).index()
    val user2 = uuid("user2").references(Friends.id).index()
    val initiator = uuid("initUser").references(Friends.id)
    val since = datetime("since")
    val relationshipLevel = enumeration("level", RelationshipLevel::class.java)

    fun addRelationship(player: Player, friend: Player, relationship: RelationshipLevel) {

    }
}