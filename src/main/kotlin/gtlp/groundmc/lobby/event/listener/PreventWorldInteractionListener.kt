package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.NBTIdentifier
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent

object PreventWorldInteractionListener : Listener {

    /**
     * Prevents players to place blocks with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        if (NBTIdentifier.itemHasPrefix(event.itemInHand)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents players dropping items with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        if (NBTIdentifier.itemHasPrefix(event.itemDrop.itemStack)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents players from picking up items when they are in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventItemPickup(event: EntityPickupItemEvent) {
        if (event.entity.world == LobbyMain.hubLocation.get().world) {
            event.isCancelled = true
        }
    }
}