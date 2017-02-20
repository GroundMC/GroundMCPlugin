package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.LobbyMain
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

/**
 * Created by Marv1 on 14.11.2016.
 */
class EntityEventListener : Listener {
    @EventHandler
    fun preventDamage(event: EntityDamageEvent) {
        if (event.entity.world == LobbyMain.hubWorld) {
            event.isCancelled = true
        }
    }
}