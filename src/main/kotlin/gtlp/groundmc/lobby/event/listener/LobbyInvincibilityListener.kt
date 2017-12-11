package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityDamageEvent.DamageCause.*
import org.bukkit.event.entity.PotionSplashEvent

/**
 * This [Listener] takes care to protect players from any unwanted damage in
 * the lobby by cancelling any damage or damage-inducing events.
 */
object LobbyInvincibilityListener : Listener {
    /**
     * Removes potion effects from splashed potions in the lobby world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun removePotionEffects(event: PotionSplashEvent) {
        if (event.entity.world == (Meta.getConfig(Config.HUB_LOCATION) as Location).world) {
            // Remove players from affectedEntities
            event.affectedEntities.filter { it is Player }.forEach { event.setIntensity(it, -1.0) }
        }
    }

    /**
     * Handles the [EntityDamageEvent] and cancels all damage in the lobby world.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun preventDamage(event: EntityDamageEvent) {
        if (event.entity.world == (Meta.getConfig(Config.HUB_LOCATION) as Location).world
                && event.cause !in arrayOf(SUICIDE, CUSTOM, VOID)) {
            event.isCancelled = true
        }
    }
}