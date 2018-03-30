package gtlp.groundmc.lobby.event.listener

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.api.player.PlayerExecutorBridge
import de.dytanic.cloudnet.bridge.CloudServer
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.FriendsOverviewInventory
import gtlp.groundmc.lobby.util.I18NStrings
import gtlp.groundmc.lobby.util.NBTItemExt
import kotlinx.coroutines.experimental.async
import org.bukkit.Bukkit
import org.bukkit.Material
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
                val inventory = FriendsOverviewInventory.create(
                        event.whoClicked as Player)
                Bukkit.getScheduler().runTask(LobbyMain.instance, {
                    event.whoClicked.openInventory(inventory)
                })
            }
        }
    }

    @EventHandler
    fun openFriendsOverview(event: PlayerInteractEvent) {
        if (event.action != Action.PHYSICAL && NBTIdentifier.itemHasPrefix(event.item)
                && NBTItemExt(event.item).getInteger(NBTIdentifier.TYPE) == GMCType.FRIENDS.ordinal) {
            event.isCancelled = true
            async {
                val inventory = FriendsOverviewInventory.create(
                        event.player)
                Bukkit.getScheduler().runTask(LobbyMain.instance, {
                    event.player.openInventory(inventory)
                })
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
                async {
                    val inventory = FriendsOverviewInventory.friendDetails(
                            event.whoClicked as Player, item)
                    Bukkit.getScheduler().runTask(LobbyMain.instance, {
                        event.whoClicked.openInventory(inventory)
                    })
                }
            }
        }
    }

    @EventHandler
    fun jumpToFirstPage(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.currentItem.type == Material.COMPASS
                && event.inventory.title == FriendsOverviewInventory.TITLE
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.PAGE)) {
                async {
                    val inventory = FriendsOverviewInventory.create(
                            event.whoClicked as Player)
                    Bukkit.getScheduler().runTask(LobbyMain.instance, {
                        event.whoClicked.openInventory(inventory)
                    })
                }
            }
        }
    }

    @EventHandler
    fun switchPage(event: InventoryClickEvent) {
        if (event.whoClicked is Player
                && event.inventory.title == FriendsOverviewInventory.TITLE
                && NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.currentItem.type == Material.ARROW) {
            event.result = Event.Result.DENY
            async {
                val inventory = FriendsOverviewInventory.openPage(
                        event.whoClicked as Player, event.currentItem)
                Bukkit.getScheduler().runTask(LobbyMain.instance, {
                    event.whoClicked.openInventory(inventory)
                })
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
                    val friend = item.getObject(NBTIdentifier.RELATIONSHIP, Relationship::class)!!.user2.uniqueId
                    Relationships.removeRelationship(event.whoClicked.uniqueId, friend)
                    event.whoClicked.sendMessage(
                            I18NStrings.COMMAND_FRIEND_NO_LONGER_RELATED
                                    .format(event.whoClicked as Player, Users[friend][Users.lastName]))
                }
            }
        }
    }

    @EventHandler
    fun jumpToFriend(event: InventoryClickEvent) {
        if (NBTIdentifier.itemHasPrefix(event.currentItem)
                && event.whoClicked is Player) {
            val item = NBTItemExt(event.currentItem)
            if (item.hasKey(NBTIdentifier.TYPE)
                    && item.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal
                    && item.hasKey(NBTIdentifier.RELATIONSHIP)) {
                event.result = Event.Result.DENY
                event.view.close()
                val friend = item.getObject(NBTIdentifier.RELATIONSHIP, Relationship::class)?.user2
                        ?: return
                val cloudFriend = CloudAPI.getInstance().getOnlinePlayer(friend.uniqueId)
                if (cloudFriend == null) {
                    event.whoClicked.sendMessage(
                            I18NStrings.FRIENDS_OFFLINE.format(event.whoClicked as Player, friend.name))
                    return
                }
                async {
                    if (cloudFriend.server
                            == CloudServer.getInstance().serverProcessMeta.serviceId.serverId) {
                        Bukkit.getScheduler().runTask(LobbyMain.instance, {
                            event.view.close()
                            event.whoClicked.teleport(friend.player)
                        })
                    } else {
                        Bukkit.getScheduler().runTask(LobbyMain.instance, {
                            event.view.close()
                        })
                        PlayerExecutorBridge.INSTANCE.sendPlayer(
                                CloudServer.getInstance().getCachedPlayer(event.whoClicked.uniqueId)
                                , cloudFriend.server)
                    }
                }
            }
        }
    }
}
