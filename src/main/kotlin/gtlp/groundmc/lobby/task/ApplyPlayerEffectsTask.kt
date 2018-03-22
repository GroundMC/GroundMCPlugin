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

package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import org.bukkit.Bukkit

/**
 * Task to apply effects to players in the lobby world.
 */
object ApplyPlayerEffectsTask : ITask {
    override val delay: Long = 20L
    override val period: Long = 20L

    override fun run() {
        Bukkit.getOnlinePlayers().filter { it.world == Meta[Config.HUB_LOCATION]?.world }.forEach {
            it.health = 20.0
            it.saturation = 20.0f
            it.foodLevel = 20
            it.exhaustion = 0.0f
            it.activePotionEffects.forEach { effect -> it.removePotionEffect(effect.type) }
        }
    }
}
