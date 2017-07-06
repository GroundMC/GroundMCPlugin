---
TITLE: RecreateItemsTask - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.task](../index.html) / [RecreateItemsTask](.)

# RecreateItemsTask

`object RecreateItemsTask : `[`ITask`](../-i-task/index.html)

Task to recreate the [LobbyInventoryHolder](../../gtlp.groundmc.lobby.inventory/-lobby-inventory-holder/index.html) for players whose locale chnages

### Properties

| [delay](delay.html) | `val delay: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The initial delay before the task starts |
| [period](period.html) | `val period: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>The period in which this task repeats |

### Functions

| [addItemsToInventory](add-items-to-inventory.html) | `fun addItemsToInventory(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Generates and adds items to a player's inventory according to their permissions. |
| [run](run.html) | `fun run(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>The function to run every time the task runs (does not need to repeat) |

