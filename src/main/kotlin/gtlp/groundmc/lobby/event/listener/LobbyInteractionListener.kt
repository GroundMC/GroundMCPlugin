/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

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
                    .multiply(Meta[Config.JUMPPADS_MULTIPLIER] ?: 1.0)
                    .setY(Meta[Config.JUMPPADS_Y] ?: 0.0)
            event.player.playSound(event.player.location, Sound.ENTITY_ENDERDRAGON_FLAP, 10f, 1f)
            event.isCancelled = true
        }
    }
}
