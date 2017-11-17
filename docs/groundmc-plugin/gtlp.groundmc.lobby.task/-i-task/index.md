---
title: ITask - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.task](../index.html) / [ITask](.)

# ITask

`interface ITask : Runnable`

Interface to describe a Task for use as a Runnable
in [org.bukkit.scheduler.BukkitScheduler.scheduleSyncRepeatingTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncRepeatingTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long, long))
or [org.bukkit.scheduler.BukkitScheduler.scheduleSyncDelayedTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncDelayedTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long))

### Properties

| [delay](delay.html) | `abstract val delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The initial delay before the task starts |
| [period](period.html) | `abstract val period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The period in which this task repeats |

### Functions

| [run](run.html) | `abstract fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The function to run every time the task runs (does not need to repeat) |

### Inheritors

| [ApplyPlayerEffectsTask](../-apply-player-effects-task/index.html) | `object ApplyPlayerEffectsTask : ITask`<br>Task to apply effects to players in the lobby world. |
| [HidePlayersTask](../-hide-players-task/index.html) | `object HidePlayersTask : ITask`<br>Task to update players and their change in the visibility state. |
| [MonitorLocaleTask](../-monitor-locale-task/index.html) | `object MonitorLocaleTask : ITask`<br>Task to monitor changes in locale changes of players. Calls the [PlayerChangeLocaleEvent](../../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) for changes in locale. |
| [SetRulesTask](../-set-rules-task/index.html) | `object SetRulesTask : ITask`<br>Task to set the rules. Should only be executed once. |

