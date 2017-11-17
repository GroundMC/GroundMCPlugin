---
title: LobbyMain - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby](../index.html) / [LobbyMain](.)

# LobbyMain

`class LobbyMain : `[`JavaPlugin`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html)

The main class for this plugin.
Serves as the entry point and commander of all things.

### Constructors

| [&lt;init&gt;](-init-.html) | `LobbyMain()`<br>The main class for this plugin. Serves as the entry point and commander of all things. |

### Functions

| [createDefaultConfig](create-default-config.html) | `fun createDefaultConfig(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initializes the config file for first use. |
| [loadConfig](load-config.html) | `fun loadConfig(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Loads the config and sanitizes certain fields. |
| [onDisable](on-disable.html) | `fun onDisable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when this plugin is disabled |
| [onEnable](on-enable.html) | `fun onEnable(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Called when this plugin is enabled |
| [registerCommands](register-commands.html) | `fun registerCommands(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers all commands into the [LobbyCommandRegistry](../../gtlp.groundmc.lobby.registry/-lobby-command-registry/index.html). |
| [registerGsonHandlers](register-gson-handlers.html) | `fun registerGsonHandlers(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers a custom GSON handler to handle the [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) class. |
| [saveConfig](save-config.html) | `fun saveConfig(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves the [org.bukkit.configuration.file.FileConfiguration](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/file/FileConfiguration.html) retrievable by [getConfig](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/plugin/java/JavaPlugin.html#getConfig()). |
| [scheduleSyncDelayedTask](schedule-sync-delayed-task.html) | `fun `[`BukkitScheduler`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html)`.scheduleSyncDelayedTask(task: `[`ITask`](../../gtlp.groundmc.lobby.task/-i-task/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Schedules a delayed task. |
| [scheduleSyncRepeatingTask](schedule-sync-repeating-task.html) | `fun `[`BukkitScheduler`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html)`.scheduleSyncRepeatingTask(task: `[`ITask`](../../gtlp.groundmc.lobby.task/-i-task/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Schedules a repeating task. |
| [upgradeConfig](upgrade-config.html) | `fun upgradeConfig(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Upgrades the config file using the [ConfigUpgrader](../../gtlp.groundmc.lobby.util/-config-upgrader/index.html). |

### Companion Object Properties

| [SILENCED_PLAYERS](-s-i-l-e-n-c-e-d_-p-l-a-y-e-r-s.html) | `val SILENCED_PLAYERS: `[`MutableSet`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-set/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`>`<br>Set holding players that want their chat to be silent |
| [configVersion](config-version.html) | `const val configVersion: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The latest version of the configuration. Used in [upgradeConfig](upgrade-config.html). |
| [dailyCoins](daily-coins.html) | `var dailyCoins: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The variable holding the amount of coins a player gets every day. |
| [hubLocation](hub-location.html) | `var hubLocation: Optional<`[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`>`<br>Variable to hold the [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) of the hub/lobby. |
| [instance](instance.html) | `var instance: Optional<LobbyMain>`<br>Common instance of this LobbyMain plugin. |
| [logger](logger.html) | `val logger: Logger`<br>The [Logger](#) that is created in the init block. |
| [originalInventories](original-inventories.html) | `val originalInventories: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?>>`<br>A map of [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s to their inventory contents. |
| [tasks](tasks.html) | `val tasks: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`ITask`](../../gtlp.groundmc.lobby.task/-i-task/index.html)`, `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>`<br>A map of tasks to their IDs |

