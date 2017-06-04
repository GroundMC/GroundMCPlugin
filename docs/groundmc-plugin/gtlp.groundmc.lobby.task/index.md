---
title: gtlp.groundmc.lobby.task - groundmc-plugin
---

[groundmc-plugin](../index.html) / [gtlp.groundmc.lobby.task](.)

## Package gtlp.groundmc.lobby.task

### Types

| [ApplyPlayerEffectsTask](-apply-player-effects-task/index.html) | `object ApplyPlayerEffectsTask : `[`ITask`](-i-task/index.html)<br>Task to apply effects to players in the lobby world. |
| [HidePlayersTask](-hide-players-task/index.html) | `object HidePlayersTask : `[`ITask`](-i-task/index.html)<br>Task to update players and their change in the visibility state. |
| [ITask](-i-task/index.html) | `interface ITask : `[`Runnable`](http://docs.oracle.com/javase/6/docs/api/java/lang/Runnable.html)<br>Interface to describe a Task for use as a Runnable in [org.bukkit.scheduler.BukkitScheduler.scheduleSyncRepeatingTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncRepeatingTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long, long)) or [org.bukkit.scheduler.BukkitScheduler.scheduleSyncDelayedTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncDelayedTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long)) |
| [LobbyUpdateTask](-lobby-update-task/index.html) | `object LobbyUpdateTask : `[`ITask`](-i-task/index.html)<br>Task to update the [LobbyInventory](../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) with information about the amount of slots in the destination world. Stops when Multiverse is not installed. |
| [RecreateItemsTask](-recreate-items-task/index.html) | `object RecreateItemsTask : `[`ITask`](-i-task/index.html)<br>Task to recreate the [LobbyInventoryHolder](../gtlp.groundmc.lobby.inventory/-lobby-inventory-holder/index.html) for players whose locale chnages |
| [SetRulesTask](-set-rules-task/index.html) | `object SetRulesTask : `[`ITask`](-i-task/index.html)<br>Task to set the rules. Should only be executed once. |

