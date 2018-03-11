package gtlp.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.bridge.CloudServer
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

object LobbyChooser {

    const val TITLE = "Running lobbies"

    fun create(player: Player) = Bukkit.createInventory(player, 3 * 9, TITLE)
            .apply {
                val servers =
                        CloudAPI.getInstance().getServers(CloudServer.getInstance().groupData.name)
                servers.sortedBy { it.serviceId.id }.forEachIndexed { index, serverInfo ->
                    val material = when (serverInfo.serviceId.id) {
                        CloudServer.getInstance().serverProcessMeta.serviceId.id -> Material.GLOWSTONE_DUST
                        else -> Material.SUGAR
                    }
                    setItem(index, NBTItemExt(ItemStack(material)).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        setInteger(NBTIdentifier.TYPE, GMCType.CHOOSE_LOBBY.ordinal)
                        setString(NBTIdentifier.TP_LOC, serverInfo.serviceId.serverId)
                        lore = listOf("Online: ${serverInfo.players.size}/${serverInfo.maxPlayers}")
                        addEnchantment(Enchantment.LUCK)
                        addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        displayName = serverInfo.serviceId.serverId
                    }.item)
                }
            }!!
}
