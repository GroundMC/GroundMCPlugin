

package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.FriendsOverviewInventory
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent


@Suppress("unused")
object FriendsOverviewListener : Listener {

    @EventHandler
    fun openFriendsOverview(event: InventoryClickEvent) {
        if (event.isCancelled || event.result == Event.Result.DENY) return

        if (event.whoClicked is Player && event.currentItem == Items.FRIENDS_ITEM.item) {
            event.result = Event.Result.DENY
            event.whoClicked.openInventory(FriendsOverviewInventory.create(event.whoClicked as Player))
        }
    }

    @EventHandler
    fun openFriendsOverview(event: PlayerInteractEvent) {
        if (event.isCancelled) return

        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)) {
            event.isCancelled = true
            if (event.item == Items.FRIENDS_ITEM.item) {
                event.player.openInventory(FriendsOverviewInventory.create(event.player))
            }
        }
    }
}
