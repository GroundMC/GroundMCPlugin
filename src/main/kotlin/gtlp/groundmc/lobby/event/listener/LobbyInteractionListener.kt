package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.util.Vector

/**
 * This [Listener] handles player interactions in the lobby.
 */
object LobbyInteractionListener : Listener {
    /**
     * Launches a player forward when stepping on a golden pressure plate.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun launchPlayerForward(event: PlayerInteractEvent) {
        /**
         * Calculates a normalized vector based on the [Location.yaw] on the XZ-plane.
         *
         * @return a vector pointing in the direction of [Location.yaw] with a length of 1.
         */
        fun Location.getDirectionXZ(): Vector {
            val vector = Vector()

            val rotX = this.yaw.toDouble()

            vector.y = 0.0

            vector.x = -Math.sin(Math.toRadians(rotX))
            vector.z = Math.cos(Math.toRadians(rotX))

            return vector.normalize()
        }
        if (event.clickedBlock != null && event.action == Action.PHYSICAL
                && event.clickedBlock.type.name in Meta[Config.JUMPPADS_MATERIAL] as List<*>
                && event.player.world == (Meta[Config.HUB_LOCATION] as Location).world) {
            event.player.velocity = event.player.location.getDirectionXZ()
                    .multiply(Meta[Config.JUMPPADS_MULTIPLIER] as Double)
                    .setY(Meta[Config.JUMPPADS_Y] as Double)
            event.player.playSound(event.player.location, Sound.ENTITY_ENDERDRAGON_FLAP, 10f, 1f)
            event.isCancelled = true
        }
    }
}