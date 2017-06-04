package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

/**
 * Listener to affect all instances of [org.bukkit.entity.Entity]
 */
class EntityEventListener : Listener {

    /**
     * Handles the [EntityDamageEvent] and cancels all damage in the lobby world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun preventDamage(event: EntityDamageEvent) {
        if (event.entity.world == LobbyMain.hubLocation.get().world) {
            event.isCancelled = true
        }
    }
}
