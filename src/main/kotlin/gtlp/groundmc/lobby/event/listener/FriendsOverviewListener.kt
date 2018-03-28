package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.FriendsOverviewInventory
import gtlp.groundmc.lobby.util.NBTItemExt
import kotlinx.coroutines.experimental.async
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
        if (event.whoClicked is Player && NBTIdentifier.itemHasPrefix(event.currentItem)
                && NBTItemExt(event.currentItem).getInteger(NBTIdentifier.TYPE) == GMCType.FRIENDS.ordinal) {
            event.result = Event.Result.DENY
            async {
                event.whoClicked.openInventory(FriendsOverviewInventory.create(event.whoClicked as Player))
            }
        }
    }

    @EventHandler
    fun openFriendsOverview(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)
                && NBTItemExt(event.item).getInteger(NBTIdentifier.TYPE) == GMCType.FRIENDS.ordinal) {
            event.isCancelled = true
            async {
                event.player.openInventory(FriendsOverviewInventory.create(event.player))
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
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.inventory.title == FriendsOverviewInventory.TITLE) {
            event.result = Event.Result.DENY
        } else if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && NBTItemExt(event.currentItem).hasKey(NBTIdentifier.RELATIONSHIP)) {
            event.result = Event.Result.DENY
        }
    }

    @EventHandler
    fun openFriendDetails(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.inventory.title == FriendsOverviewInventory.TITLE
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.RELATIONSHIP)) {
                event.result = Event.Result.DENY
                event.whoClicked.openInventory(FriendsOverviewInventory.friendDetails(
                        event.whoClicked as Player, item))
            }
        }
    }

    @EventHandler
    fun removeFriend(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.TYPE)
                    && item.getInteger(NBTIdentifier.TYPE) == GMCType.REMOVE_FRIEND.ordinal) {
                event.result = Event.Result.DENY
                event.view.close()
                async {
                    Relationships.removeRelationship(event.whoClicked as Player,
                            item.getObject(NBTIdentifier.RELATIONSHIP, Relationship::class)!!.user2.offlinePlayer)
                }
            }
        }
    }
}
