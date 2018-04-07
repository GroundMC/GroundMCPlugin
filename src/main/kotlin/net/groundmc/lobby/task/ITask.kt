package net.groundmc.lobby.task

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
