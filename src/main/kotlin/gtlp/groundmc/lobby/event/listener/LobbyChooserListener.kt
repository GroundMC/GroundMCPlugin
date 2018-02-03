package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.inventory.LobbyChooser
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

object LobbyChooserListener : Listener {

    @EventHandler
    fun openLobbyChooser(event: InventoryClickEvent) {
        if (event.currentItem == Items.LOBBY_CHOOSE_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(LobbyChooser.create(event.whoClicked as Player))
        }
    }
}
