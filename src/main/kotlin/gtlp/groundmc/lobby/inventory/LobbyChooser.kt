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
                servers.forEachIndexed { index, serverInfo ->
                    setItem(index, NBTItemExt(ItemStack(Material.NETHER_STAR)).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        setInteger(NBTIdentifier.TYPE, GMCType.CHOOSE_LOBBY.ordinal)
                        setString(NBTIdentifier.TP_LOC, serverInfo.serviceId.serverId)
                        lore += "Online: " + serverInfo.players.size
                        addEnchantment(Enchantment.LUCK)
                        addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        displayName = serverInfo.serviceId.serverId
                    }.item)
                }
            }!!
}
