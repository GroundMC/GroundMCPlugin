package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.inventory.HidePlayerInventory
import gtlp.groundmc.lobby.util.NBTItemExt
import kotlinx.coroutines.experimental.async
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
     * Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory].
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
     * Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory].
     *
     * @param event the event to handle
     */
    @EventHandler
    fun openHidePlayInventory(event: InventoryClickEvent) {
        if (event.currentItem != null && event.whoClicked is Player) {
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(nbtItem.item)
                    && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                event.result = Event.Result.DENY
                event.whoClicked.openInventory(HidePlayerInventory.create(event.whoClicked as Player))
            }
        }
    }

    /**
     * Updates the state of players to hide, when clicked on an option in the
     * [gtlp.groundmc.lobby.inventory.HidePlayerInventory].
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
                    async {
                        transaction {
                            Users.update({ Users.id eq event.whoClicked.uniqueId }) {
                                it[hiddenStatus] = VisibilityStates.values()[nbtItem.getInteger(NBTIdentifier.HIDE_STATE)!!]
                            }
                            commit()
                        }
                        Users.refresh(event.whoClicked.uniqueId)
                    }
                    event.whoClicked.sendMessage(nbtItem.displayName)
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
