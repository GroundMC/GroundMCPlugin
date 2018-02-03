package gtlp.groundmc.lobby.event.listener

import com.google.common.io.ByteStreams
import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyChooser
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.Plugin


@Suppress("unused")
object LobbyChooserListener : Listener {

    private const val channel = "CloudNet"

    @EventHandler
    fun openLobbyChooser(event: InventoryClickEvent) {
        if (event.currentItem == Items.LOBBY_CHOOSE_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(LobbyChooser.create(event.whoClicked as Player))
        }
    }

    @EventHandler
    fun openLobbyChooser(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)) {
            event.isCancelled = true
            if (event.item == Items.LOBBY_CHOOSE_ITEM.item) {
                event.player.openInventory(LobbyChooser.create(event.player))
            }
        }
    }

    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        if (event.clickedInventory != null && event.clickedInventory.title == LobbyInventory.TITLE) {
            event.isCancelled = true
            if (event.currentItem == null) {
                return
            }
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item) &&
                    nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.CHOOSE_LOBBY.ordinal) {
                sendPlayerToServer(LobbyMain.instance, player,
                        nbtItem.getString(NBTIdentifier.TP_LOC)!!)
            }
        }
    }

    private fun sendPlayerToServer(plugin: Plugin, player: Player, server: String) {
        if (!Bukkit.getMessenger().isOutgoingChannelRegistered(plugin, channel)) {
            Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, channel)
        }
        val byteArrayDataOutput = ByteStreams.newDataOutput()
        byteArrayDataOutput.writeUTF("Connect")
        byteArrayDataOutput.writeUTF(server)
        player.sendPluginMessage(plugin, channel, byteArrayDataOutput.toByteArray())
    }
}
