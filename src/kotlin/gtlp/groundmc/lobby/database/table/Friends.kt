package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.json.simple.JSONArray
import org.json.simple.parser.JSONParser

/**
 * Created by Marvin on 11.11.2016.
 */
object Friends : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
    val friends = text("friends").default(JSONArray.toJSONString(listOf<String>()))

    fun addFriend(player: Player, friend: Player) {
        transaction {
            Friends.update({ id.eq(player.uniqueId) }) {
                val friendList = (JSONParser().parse(select { id.eq(player.uniqueId) }.first()[friends]) as JSONArray)
                if (!friendList.contains("'" + friend.uniqueId.toString() + "'")) {
                    friendList.add("'" + friend.uniqueId.toString() + "'")
                }
                it[friends] = JSONArray.toJSONString(friendList)
            }
            commit()
            Friends.update({ id.eq(friend.uniqueId) }) {
                val friendList = (JSONParser().parse(select { id.eq(friend.uniqueId) }.first()[friends]) as JSONArray)
                if (!friendList.contains("'" + player.uniqueId.toString() + "'")) {
                    friendList.add("'" + player.uniqueId.toString() + "'")
                }
                it[friends] = JSONArray.toJSONString(friendList)
            }
            commit()
            flushCache()
        }
    }
}