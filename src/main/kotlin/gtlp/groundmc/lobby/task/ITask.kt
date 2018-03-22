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

/**
 * Interface to describe a Task for use as a Runnable
 * in [org.bukkit.scheduler.BukkitScheduler.scheduleSyncRepeatingTask]
 * or [org.bukkit.scheduler.BukkitScheduler.scheduleSyncDelayedTask]
 */
interface ITask : Runnable {
    /**
     * The initial delay before the task starts
     */
    val delay: Long

    /**
     * The period in which this task repeats
     */
    val period: Long

    /**
     * The function to run every time the task runs (does not need to repeat)
     */
    override fun run()
}
