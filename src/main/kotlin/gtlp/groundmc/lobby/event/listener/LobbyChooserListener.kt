package gtlp.groundmc.lobby.event.listener

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.api.player.PlayerExecutorBridge
import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyChooser
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent


@Suppress("unused")
object LobbyChooserListener : Listener {

    @EventHandler
    fun openLobbyChooser(event: InventoryClickEvent) {
        if (event.isCancelled || event.result == Event.Result.DENY) return

        if (event.currentItem == Items.LOBBY_CHOOSE_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(LobbyChooser.create(event.whoClicked as Player))
        }
    }

    @EventHandler
    fun openLobbyChooser(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)
                && event.item == Items.LOBBY_CHOOSE_ITEM.item) {
            event.isCancelled = true
            event.player.openInventory(LobbyChooser.create(event.player))
        }
    }

    @EventHandler
    fun teleportPlayer(event: InventoryClickEvent) {
        val player = event.whoClicked as Player
        if (event.clickedInventory != null && event.clickedInventory.title == LobbyChooser.TITLE) {
            if (event.currentItem == null) {
                return
            }
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item) &&
                    nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.CHOOSE_LOBBY.ordinal) {
                event.result = Event.Result.DENY
                PlayerExecutorBridge.INSTANCE.sendPlayer(
                        CloudAPI.getInstance().getOnlinePlayer(player.uniqueId),
                        nbtItem.getString(NBTIdentifier.TP_LOC))
                event.view.close()
            }
        }
    }

    /**
     * Denies default actions when clicking on items with the [NBTIdentifier.PREFIX].
     *
     * @param event the event to handle.
     */
    @EventHandler
    fun cancelInventoryClick(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem) &&
                event.inventory.title == LobbyChooser.TITLE) {
            event.result = Event.Result.DENY
        }
    }
}
