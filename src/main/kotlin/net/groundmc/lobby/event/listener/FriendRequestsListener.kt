package net.groundmc.lobby.event.listener

import kotlinx.coroutines.experimental.async
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.FriendRequests
import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.inventory.FriendRequestsInventory
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.objects.Relationship
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

object FriendRequestsListener : Listener {
    @EventHandler
    fun openFriendsOverview(event: InventoryClickEvent) {
        if (event.whoClicked is Player && NBTIdentifier.itemHasPrefix(event.currentItem)
                && NBTItemExt(event.currentItem).getInteger(NBTIdentifier.TYPE) == GMCType.FRIEND_REQUESTS.ordinal) {
            event.result = Event.Result.DENY
            async {
                val inventory = FriendRequestsInventory.create(
                        event.whoClicked as Player)
                Bukkit.getScheduler().runTask(LobbyMain.instance) {
                    event.whoClicked.openInventory(inventory)
                }
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
                && event.inventory.title == FriendRequestsInventory.TITLE) {
            event.result = Event.Result.DENY
        }
    }

    @EventHandler
    fun jumpToFirstPage(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.currentItem.type == Material.COMPASS
                && event.inventory.title == FriendRequestsInventory.TITLE
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.PAGE)) {
                async {
                    val inventory = FriendRequestsInventory.create(
                            event.whoClicked as Player)
                    Bukkit.getScheduler().runTask(LobbyMain.instance) {
                        event.whoClicked.openInventory(inventory)
                    }
                }
            }
        }
    }

    @EventHandler
    fun switchPage(event: InventoryClickEvent) {
        if (event.whoClicked is Player
                && event.inventory.title == FriendRequestsInventory.TITLE
                && NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.currentItem.type == Material.ARROW) {
            event.result = Event.Result.DENY
            async {
                val inventory = FriendRequestsInventory.openPage(
                        event.whoClicked as Player, event.currentItem)
                Bukkit.getScheduler().runTask(LobbyMain.instance) {
                    event.whoClicked.openInventory(inventory)
                }
            }
        }
    }

    @EventHandler
    fun openRequestDetails(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.inventory.title == FriendRequestsInventory.TITLE
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.RELATIONSHIP)) {
                event.result = Event.Result.DENY
                async {
                    val inventory = FriendRequestsInventory.requestDetails(
                            event.whoClicked as Player, item)
                    Bukkit.getScheduler().runTask(LobbyMain.instance) {
                        event.whoClicked.openInventory(inventory)
                    }
                }
            }
        }
    }

    @EventHandler
    fun handleRequest(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            when (item.getType()) {
                GMCType.FRIEND_REQUEST_ACCEPT -> {
                    if (item.hasKey(NBTIdentifier.RELATIONSHIP)) {
                        val request = item.getObject(NBTIdentifier.RELATIONSHIP, FriendRequests.FriendRequest::class)
                        if (request != null) {
                            FriendRequests.removeRequest(request.requester, request.requested)
                            Relationships.addRelationship(event.whoClicked as Player,
                                    Relationship(request.requester, request.requested))
                        }
                    }
                    event.isCancelled = true
                    Bukkit.getScheduler().runTask(LobbyMain.instance) {
                        event.view.close()
                    }
                }
                GMCType.FRIEND_REQUEST_DENY -> {
                    if (item.hasKey(NBTIdentifier.RELATIONSHIP)) {
                        val request = item.getObject(NBTIdentifier.RELATIONSHIP, FriendRequests.FriendRequest::class)
                        if (request != null) {
                            FriendRequests.removeRequest(request.requester, request.requested)
                        }
                    }
                    event.isCancelled = true
                    Bukkit.getScheduler().runTask(LobbyMain.instance) {
                        event.view.close()
                    }
                }
                else -> {
                }
            }
        }
    }
}
