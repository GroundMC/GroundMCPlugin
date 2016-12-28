package gtlp.groundmc.lobby.util

import com.github.kittinunf.fuel.httpPost
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.bukkit.BanList
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.entity.Player
import java.math.BigInteger
import java.util.*

/**
 * Created by Marvin on 27.12.2016.
 */
object APIUtils {
    fun getOfflinePlayer(name: String): OfflinePlayer {
        val player = object : OfflinePlayer {
            override fun serialize(): MutableMap<String, Any> {
                return mutableMapOf()
            }

            override fun isBanned(): Boolean {
                return Bukkit.getBannedPlayers().contains(this)
            }

            override fun getName(): String {
                return name
            }

            override fun getBedSpawnLocation(): Location? {
                return null
            }

            override fun setBanned(banned: Boolean) {
                Bukkit.getBanList(BanList.Type.NAME).addBan(name, null, null, null)
            }

            override fun isWhitelisted(): Boolean {
                return Bukkit.getServer().whitelistedPlayers.contains(this)
            }

            override fun getPlayer(): Player {
                return Bukkit.getPlayer(uniqueId)
            }

            override fun isOp(): Boolean {
                return Bukkit.getServer().operators.contains(this)
            }

            override fun getUniqueId(): UUID? {
                val type = object : TypeToken<Array<Profile>>() {}.type
                val response = "https://api.mojang.com/profiles/minecraft".httpPost().header("Content-Type" to "application/json").body("""["$name"]""").response()
                val responseString = String(response.second.data)
                val uuid = BigInteger(Gson().fromJson<Array<Profile>>(responseString, type).first().id, 16)
                return UUID(uuid.shiftRight(64).toLong(), uuid.toLong())
            }

            override fun hasPlayedBefore(): Boolean {
                return false
            }

            override fun setWhitelisted(value: Boolean) {
                Bukkit.getServer().whitelistedPlayers.add(this)
            }

            override fun getLastPlayed(): Long {
                return 0
            }

            override fun getFirstPlayed(): Long {
                return 0
            }

            override fun isOnline(): Boolean {
                return Bukkit.getPlayer(uniqueId).isOnline
            }

            override fun setOp(value: Boolean) {
                Bukkit.getServer().operators.add(this)
            }

        }
        return player
    }

    class Profile {
        var id: String = ""
        var name: String = ""
    }
}