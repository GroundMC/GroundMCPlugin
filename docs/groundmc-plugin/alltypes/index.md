---
title: alltypes - groundmc-plugin
---

### All Types

| [gtlp.groundmc.lobby.task.ApplyPlayerEffectsTask](../gtlp.groundmc.lobby.task/-apply-player-effects-task/index.html) | Task to apply effects to players in the lobby world. |
| [gtlp.groundmc.lobby.commands.CommandCoins](../gtlp.groundmc.lobby.commands/-command-coins/index.html) | Command to manage coins, a virtual currency of literally no value |
| [gtlp.groundmc.lobby.commands.CommandFriend](../gtlp.groundmc.lobby.commands/-command-friend/index.html) | Collection of commands related to friends management |
| [gtlp.groundmc.lobby.commands.CommandFriends](../gtlp.groundmc.lobby.commands/-command-friends/index.html) | Command to list friends |
| [gtlp.groundmc.lobby.commands.CommandLobby](../gtlp.groundmc.lobby.commands/-command-lobby/index.html) | The `/lobby` command. Allows players to teleport back to the lobby and obtain help. This also allows administrators to add more teleport destinations. |
| [gtlp.groundmc.lobby.commands.CommandVanish](../gtlp.groundmc.lobby.commands/-command-vanish/index.html) |  |
| [gtlp.groundmc.lobby.util.ConfigUpgrader](../gtlp.groundmc.lobby.util/-config-upgrader/index.html) | Upgrader to modify the configuration according to changes needed to work with the new version. |
| [gtlp.groundmc.lobby.event.listener.EntityEventListener](../gtlp.groundmc.lobby.event.listener/-entity-event-listener/index.html) | Listener to affect all instances of [org.bukkit.entity.Entity](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Entity.html) |
| [gtlp.groundmc.lobby.enums.GMCType](../gtlp.groundmc.lobby.enums/-g-m-c-type/index.html) | Enum to determine the type of a lobby item. |
| [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html) | Inventory with clickable items to hide other players |
| [gtlp.groundmc.lobby.task.HidePlayersTask](../gtlp.groundmc.lobby.task/-hide-players-task/index.html) | Task to update players and their change in the visibility state. |
| [gtlp.groundmc.lobby.util.I18n](../gtlp.groundmc.lobby.util/-i18n/index.html) | Kotlin object to aid with internationalization (I18n) |
| [gtlp.groundmc.lobby.util.I18nUtils](../gtlp.groundmc.lobby.util/-i18n-utils/index.html) | Utility class for internationalization. This class provides a central location to do specialized formatting in both a default and a locale specific manner. |
| [gtlp.groundmc.lobby.commands.ILobbyCommand](../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html) | Interface for commands compatible with the {@link LobbyCommandRegistry} |
| [gtlp.groundmc.lobby.task.ITask](../gtlp.groundmc.lobby.task/-i-task/index.html) | Interface to describe a Task for use as a Runnable in [org.bukkit.scheduler.BukkitScheduler.scheduleSyncRepeatingTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncRepeatingTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long, long)) or [org.bukkit.scheduler.BukkitScheduler.scheduleSyncDelayedTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncDelayedTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long)) |
| [kotlin.Int](../gtlp.groundmc.lobby.util/kotlin.-int/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.event.listener.InventoryClickEventListener](../gtlp.groundmc.lobby.event.listener/-inventory-click-event-listener/index.html) | Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html) |
| [gtlp.groundmc.lobby.Items](../gtlp.groundmc.lobby/-items/index.html) | Object holding all items with special properties that are used in this plugin. |
| [gtlp.groundmc.lobby.registry.LobbyCommandRegistry](../gtlp.groundmc.lobby.registry/-lobby-command-registry/index.html) | Registry where all commands are saved. Used by [LobbyMain](../gtlp.groundmc.lobby/-lobby-main/index.html) |
| [gtlp.groundmc.lobby.inventory.LobbyInventory](../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) | Inventory for navigating the lobby |
| [gtlp.groundmc.lobby.inventory.LobbyInventoryHolder](../gtlp.groundmc.lobby.inventory/-lobby-inventory-holder/index.html) | Holds the two inventories used by our plugin for a player. |
| [gtlp.groundmc.lobby.LobbyMain](../gtlp.groundmc.lobby/-lobby-main/index.html) | The main class for this plugin. Serves as the entry point and commander of all things. |
| [gtlp.groundmc.lobby.util.LocationTypeAdapter](../gtlp.groundmc.lobby.util/-location-type-adapter/index.html) | An adapter to serialize and deserialize a [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object |
| [gtlp.groundmc.lobby.LogFormatter](../gtlp.groundmc.lobby/-log-formatter/index.html) | A custom [Formatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/Formatter.html) for log files. Inspired by [SimpleFormatter](http://docs.oracle.com/javase/6/docs/api/java/util/logging/SimpleFormatter.html) |
| [java.util.logging.Logger](../gtlp.groundmc.lobby.util/java.util.logging.-logger/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.database.table.Meta](../gtlp.groundmc.lobby.database.table/-meta/index.html) | Meta table to handle upgrades to the database |
| [gtlp.groundmc.lobby.event.listener.MiscEventListener](../gtlp.groundmc.lobby.event.listener/-misc-event-listener/index.html) | Listener to handle miscellaneous events. |
| [gtlp.groundmc.lobby.task.MonitorLocaleTask](../gtlp.groundmc.lobby.task/-monitor-locale-task/index.html) | Task to monitor changes in locale changes of players. Calls the [PlayerChangeLocaleEvent](../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) for changes in locale. |
| [kotlin.collections.MutableList](../gtlp.groundmc.lobby.util/kotlin.collections.-mutable-list/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.enums.NBTIdentifier](../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) | Enum to store NBTIdentifiers for use with [gtlp.groundmc.lobby.util.NBTItemExt](../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html) |
| [gtlp.groundmc.lobby.util.NBTItemExt](../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html) | Extension of [de.tr7zw.itemnbtapi.NBTItem](#) Allows the use of [NBTIdentifier](../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) as a key. |
| [gtlp.groundmc.lobby.enums.Permission](../gtlp.groundmc.lobby.enums/-permission/index.html) | Enum to store permissions as strings. Consolidates all permissions into one enum. |
| [gtlp.groundmc.lobby.event.PlayerChangeLocaleEvent](../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) | An event that is called when a player changes locale. |
| [gtlp.groundmc.lobby.event.listener.PlayerEventListener](../gtlp.groundmc.lobby.event.listener/-player-event-listener/index.html) | Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly. |
| [gtlp.groundmc.lobby.Relationship](../gtlp.groundmc.lobby/-relationship/index.html) | Class holding a relationship |
| [gtlp.groundmc.lobby.database.table.Relationships](../gtlp.groundmc.lobby.database.table/-relationships/index.html) | Table holding relationships between players, including more information |
| [gtlp.groundmc.lobby.task.SetRulesTask](../gtlp.groundmc.lobby.task/-set-rules-task/index.html) | Task to set the rules. Should only be executed once. |
| [gtlp.groundmc.lobby.database.table.Users](../gtlp.groundmc.lobby.database.table/-users/index.html) | Table to hold players' settings and more data |
| [gtlp.groundmc.lobby.enums.VisibilityStates](../gtlp.groundmc.lobby.enums/-visibility-states/index.html) | Enum to hold the visibility states. |

