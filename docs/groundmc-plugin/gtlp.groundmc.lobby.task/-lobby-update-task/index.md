---
TITLE: LobbyUpdateTask - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.task](../index.html) / [LobbyUpdateTask](.)

# LobbyUpdateTask

`object LobbyUpdateTask : `[`ITask`](../-i-task/index.html)

Task to update the [LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) with information about the amount of slots
in the destination world.
Stops when Multiverse is not installed.

### Properties

| [delay](delay.html) | `val delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The initial delay before the task starts |
| [period](period.html) | `val period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The period in which this task repeats |

### Functions

| [run](run.html) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The function to run every time the task runs (does not need to repeat) |

