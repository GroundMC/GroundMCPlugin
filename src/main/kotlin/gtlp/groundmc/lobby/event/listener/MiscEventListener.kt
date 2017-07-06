package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.PotionSplashEvent

/**
 * Listener to handle miscellaneous events.
 */
class MiscEventListener : Listener {

    /**
     * Removes potion effects from splashed potions in the lobby world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun removePotionEffects(event: PotionSplashEvent) {
        if (event.entity.world == LobbyMain.hubLocation.get().world) {
            // Remove players from affectedEntities
            event.affectedEntities.filter { it is Player }.forEach { event.setIntensity(it, -1.0) }
        }
    }

    /**
     * Prevents players to place blocks with the [NBTIdentifier.PREFIX] on them.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        val nbtItem = NBTItemExt(event.itemInHand)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

}
