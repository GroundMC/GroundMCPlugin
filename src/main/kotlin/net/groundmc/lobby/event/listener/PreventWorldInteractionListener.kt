package net.groundmc.lobby.event.listener

import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.enums.Permission
import net.groundmc.lobby.util.hasPermission
import org.bukkit.Location
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent

/**
 * This [Listener] cancels any world interaction in the lobby or with items
 * that are designed to be used in the lobby.
 *
 * Interactions include dropping items, placing blocks or picking up items.
 */
object PreventWorldInteractionListener : Listener {

    /**
     * Prevents players to place blocks with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        if (event.isCancelled) return

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
     * Prevents non-admin players from picking up items when they are in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventItemPickup(event: EntityPickupItemEvent) {
        if (event.entity.world == (Meta[Config.HUB_LOCATION] as Location).world
                && !event.entity.hasPermission(Permission.ADMIN)) {
            event.isCancelled = true
        }
    }

    /**
     * Prevents non-admin players from breaking blocks in the hub.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun preventBlockBreaking(event: BlockBreakEvent) {
        if (event.player.world == (Meta[Config.HUB_LOCATION] as Location).world
                && !event.player.hasPermission(Permission.ADMIN)) {
            event.isCancelled = true
        }
    }
}
