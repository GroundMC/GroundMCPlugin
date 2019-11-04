package net.groundmc.lobby.event.listener

import kotlinx.coroutines.launch
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.enums.VisibilityStates
import net.groundmc.lobby.inventory.HidePlayerInventory
import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * This [Listener] handles the visibility of other players towards the calling
 * player.
 * Handles the opening of the inventory, as well as the selection of the desired
 * [VisibilityStates]
 */
object HidePlayerListener : Listener {
    /**
     * Opens the [net.groundmc.lobby.inventory.HidePlayerInventory].
     *
     * @param event the event to handle
     */
    @EventHandler
    fun openHidePlayerInventory(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item)
                    && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                event.isCancelled = true
                event.player.openInventory(HidePlayerInventory.create(event.player))
            }
        }
    }

    /**
     * Opens the [net.groundmc.lobby.inventory.HidePlayerInventory].
     *
     * @param event the event to handle
     */
    @EventHandler
    fun openHidePlayInventory(event: InventoryClickEvent) {
        if (event.currentItem != null && event.whoClicked is Player) {
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item)
                    && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal
                    && event.clickedInventory.title != HidePlayerInventory.TITLE) {
                event.result = Event.Result.DENY
                event.whoClicked.openInventory(HidePlayerInventory.create(event.whoClicked as Player))
            }
        }
    }

    /**
     * Updates the state of players to hide, when clicked on an option in the
     * [net.groundmc.lobby.inventory.HidePlayerInventory].
     *
     * @param event the event to handle
     */
    @EventHandler
    fun selectHideState(event: InventoryClickEvent) {
        if (event.clickedInventory != null && event.clickedInventory.title == HidePlayerInventory.TITLE) {
            if (NBTIdentifier.itemHasPrefix(event.currentItem)) {
                val nbtItem = NBTItemExt(event.currentItem)
                if (nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                    event.result = Event.Result.DENY
                    val player = event.whoClicked as Player
                    LobbyMain.instance.scope.launch {
                        transaction {
                            Users.update({ Users.id eq player.uniqueId }) {
                                it[hiddenStatus] = VisibilityStates.values()[nbtItem.getInteger(NBTIdentifier.HIDE_STATE)!!]
                            }
                            commit()
                        }
                        Users.refresh(player.uniqueId)
                        player.inventory.setItem(2,
                                NBTItemExt(player.inventory.getItem(2)).apply {
                                    this.displayName = nbtItem.displayName
                                }.item)
                    }
                    player.sendMessage(nbtItem.displayName)
                    event.view.close()
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
        if (NBTIdentifier.itemHasPrefix(event.currentItem) &&
                event.inventory.title == HidePlayerInventory.TITLE) {
            event.result = Event.Result.DENY
        }
    }

}
