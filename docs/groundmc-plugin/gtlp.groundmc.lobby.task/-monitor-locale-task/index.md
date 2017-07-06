---
title: MonitorLocaleTask - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.task](../index.html) / [MonitorLocaleTask](.)

# MonitorLocaleTask

`object MonitorLocaleTask : `[`ITask`](../-i-task/index.html)

Task to monitor changes in locale changes of players.
Calls the [PlayerChangeLocaleEvent](../../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) for changes in locale.

### Properties

| [delay](delay.html) | `val delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The initial delay before the task starts |
| [period](period.html) | `val period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The period in which this task repeats |
| [playerLocaleMap](player-locale-map.html) | `val playerLocaleMap: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)`>`<br>A map of players to their locale. Used to track changes. Defaulted with [Locale.ENGLISH](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#ENGLISH) |

### Functions

| [run](run.html) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The function to run every time the task runs (does not need to repeat) |

