package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.PotionSplashEvent

internal class MiscEventListener : Listener {

    @EventHandler
    fun removePotionEffects(event: PotionSplashEvent) {
        if (event.entity.world == LobbyMain.hubLocation.get().world) {
            // Remove players from affectedEntities
            event.affectedEntities.filter { it is Player }.forEach { event.setIntensity(it, -1.0) }
        }
    }

    @EventHandler
    fun cancelBlockPlace(event: BlockPlaceEvent) {
        val nbtItem = NBTItemExt(event.itemInHand)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

}
