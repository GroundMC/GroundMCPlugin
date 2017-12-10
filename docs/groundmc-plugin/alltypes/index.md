---
title: alltypes - groundmc-plugin
---

### All Types

| [gtlp.groundmc.lobby.task.ApplyPlayerEffectsTask](../gtlp.groundmc.lobby.task/-apply-player-effects-task/index.html) | Task to apply effects to players in the lobby world. |
| [gtlp.groundmc.lobby.event.listener.ChatInteractionListener](../gtlp.groundmc.lobby.event.listener/-chat-interaction-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the chat interaction of the players. It makes sure that the chat is not spammed by malicious players, if this feature is enabled. |
| [gtlp.groundmc.lobby.commands.CommandCoins](../gtlp.groundmc.lobby.commands/-command-coins/index.html) | Command to manage coins, a virtual currency of literally no value |
| [gtlp.groundmc.lobby.commands.CommandFriend](../gtlp.groundmc.lobby.commands/-command-friend/index.html) | Collection of commands related to friends management |
| [gtlp.groundmc.lobby.commands.CommandFriends](../gtlp.groundmc.lobby.commands/-command-friends/index.html) | Command to list friends |
| [gtlp.groundmc.lobby.commands.CommandLobby](../gtlp.groundmc.lobby.commands/-command-lobby/index.html) | The `/lobby` command. Allows players to teleport back to the lobby and obtain help. This also allows administrators to add more teleport destinations. Additionally, events can be added to the scoreboard as well. |
| [org.bukkit.command.CommandSender](../gtlp.groundmc.lobby.util/org.bukkit.command.-command-sender/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.commands.CommandVanish](../gtlp.groundmc.lobby.commands/-command-vanish/index.html) |  |
| [gtlp.groundmc.lobby.util.ConfigUpgrader](../gtlp.groundmc.lobby.util/-config-upgrader/index.html) | Upgrader to modify the configuration according to changes needed to work with the new version. |
| [gtlp.groundmc.lobby.database.table.Events](../gtlp.groundmc.lobby.database.table/-events/index.html) | Table holding all past, current and future events planned for the server. |
| [gtlp.groundmc.lobby.enums.GMCType](../gtlp.groundmc.lobby.enums/-g-m-c-type/index.html) | Enum to determine the type of a lobby item. |
| [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html) | Inventory with clickable items to hide other players |
| [gtlp.groundmc.lobby.event.listener.HidePlayerListener](../gtlp.groundmc.lobby.event.listener/-hide-player-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the visibility of other players towards the calling player. Handles the opening of the inventory, as well as the selection of the desired [VisibilityStates](../gtlp.groundmc.lobby.enums/-visibility-states/index.html) |
| [gtlp.groundmc.lobby.task.HidePlayersTask](../gtlp.groundmc.lobby.task/-hide-players-task/index.html) | Task to update players and their change in the visibility state. |
| [gtlp.groundmc.lobby.util.I18n](../gtlp.groundmc.lobby.util/-i18n/index.html) | Kotlin object to aid with internationalization (I18n) |
| [gtlp.groundmc.lobby.util.I18nUtils](../gtlp.groundmc.lobby.util/-i18n-utils/index.html) | Utility class for internationalization. This class provides a central location to do specialized formatting in both a default and a locale specific manner. |
| [gtlp.groundmc.lobby.commands.ILobbyCommand](../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html) | Interface for commands compatible with the {@link LobbyCommandRegistry} |
| [gtlp.groundmc.lobby.task.ITask](../gtlp.groundmc.lobby.task/-i-task/index.html) | Interface to describe a Task for use as a Runnable in [org.bukkit.scheduler.BukkitScheduler.scheduleSyncRepeatingTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncRepeatingTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long, long)) or [org.bukkit.scheduler.BukkitScheduler.scheduleSyncDelayedTask](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html#scheduleSyncDelayedTask(org.bukkit.plugin.Plugin, java.lang.Runnable, long)) |
| [kotlin.Int](../gtlp.groundmc.lobby.util/kotlin.-int/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [org.bukkit.inventory.Inventory](../gtlp.groundmc.lobby.util/org.bukkit.inventory.-inventory/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.Items](../gtlp.groundmc.lobby/-items/index.html) | Object holding all items with special properties that are used in this plugin. |
| [gtlp.groundmc.lobby.registry.LobbyCommandRegistry](../gtlp.groundmc.lobby.registry/-lobby-command-registry/index.html) | Registry where all commands are saved. Used by [LobbyMain](../gtlp.groundmc.lobby/-lobby-main/index.html) |
| [gtlp.groundmc.lobby.event.listener.LobbyInteractionListener](../gtlp.groundmc.lobby.event.listener/-lobby-interaction-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles player interactions in the lobby. |
| [gtlp.groundmc.lobby.inventory.LobbyInventory](../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) | Inventory for navigating the lobby |
| [gtlp.groundmc.lobby.event.listener.LobbyInventoryListener](../gtlp.groundmc.lobby.event.listener/-lobby-inventory-listener/index.html) | Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html) |
| [gtlp.groundmc.lobby.event.listener.LobbyInvincibilityListener](../gtlp.groundmc.lobby.event.listener/-lobby-invincibility-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) takes care to protect players from any unwanted damage in the lobby by cancelling any damage or damage-inducing events. |
| [gtlp.groundmc.lobby.LobbyMain](../gtlp.groundmc.lobby/-lobby-main/index.html) | The main class for this plugin. Serves as the entry point and commander of all things. |
| [gtlp.groundmc.lobby.util.LocationTypeAdapter](../gtlp.groundmc.lobby.util/-location-type-adapter/index.html) | An adapter to serialize and deserialize a [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object |
| [gtlp.groundmc.lobby.LogFormatter](../gtlp.groundmc.lobby/-log-formatter/index.html) | A custom [Formatter](#) for log files. Inspired by [SimpleFormatter](#) |
| [java.util.logging.Logger](../gtlp.groundmc.lobby.util/java.util.logging.-logger/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.database.table.Meta](../gtlp.groundmc.lobby.database.table/-meta/index.html) | Meta table to handle upgrades to the database |
| [gtlp.groundmc.lobby.task.MonitorLocaleTask](../gtlp.groundmc.lobby.task/-monitor-locale-task/index.html) | Task to monitor changes in locale changes of players. Calls the [PlayerChangeLocaleEvent](../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) for changes in locale. |
| [kotlin.collections.MutableList](../gtlp.groundmc.lobby.util/kotlin.collections.-mutable-list/index.html) (extensions in package gtlp.groundmc.lobby.util) |  |
| [gtlp.groundmc.lobby.enums.NBTIdentifier](../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) | Enum to store NBTIdentifiers for use with [gtlp.groundmc.lobby.util.NBTItemExt](../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html) |
| [gtlp.groundmc.lobby.util.NBTItemExt](../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html) | Extension of [de.tr7zw.itemnbtapi.NBTItem](#) Allows the use of [NBTIdentifier](../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) as a key. |
| [gtlp.groundmc.lobby.enums.Permission](../gtlp.groundmc.lobby.enums/-permission/index.html) | Enum to store permissions as strings. Consolidates all permissions into one enum. |
| [gtlp.groundmc.lobby.event.PlayerChangeLocaleEvent](../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html) | An event that is called when a player changes locale. |
| [gtlp.groundmc.lobby.event.listener.PreventWorldInteractionListener](../gtlp.groundmc.lobby.event.listener/-prevent-world-interaction-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) cancels any world interaction in the lobby or with items that are designed to be used in the lobby. |
| [gtlp.groundmc.lobby.Relationship](../gtlp.groundmc.lobby/-relationship/index.html) | Class holding a relationship |
| [gtlp.groundmc.lobby.database.table.Relationships](../gtlp.groundmc.lobby.database.table/-relationships/index.html) | Table holding relationships between players, including more information |
| [gtlp.groundmc.lobby.event.listener.ServerStateListener](../gtlp.groundmc.lobby.event.listener/-server-state-listener/index.html) | Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly. |
| [gtlp.groundmc.lobby.task.SetRulesTask](../gtlp.groundmc.lobby.task/-set-rules-task/index.html) | Task to set the rules. Should only be executed once. |
| [gtlp.groundmc.lobby.event.listener.SilentChatListener](../gtlp.groundmc.lobby.event.listener/-silent-chat-listener/index.html) | This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) manages the silent chat function. It allows players to toggle their chat to silence and non-silence. It also filters the chat for those users that have enabled this feature. |
| [gtlp.groundmc.lobby.task.UpdateLobbyInventoryTask](../gtlp.groundmc.lobby.task/-update-lobby-inventory-task/index.html) | Task to update the items in the [LobbyInventory](../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) that refer to worlds that are managed by Multiverse-Core and have custom player limits set. |
| [gtlp.groundmc.lobby.task.UpdateScoreboardsTask](../gtlp.groundmc.lobby.task/-update-scoreboards-task/index.html) | Task to regularly update the player's scoreboard with information about their play time, owned coins and currently active events. |
| [gtlp.groundmc.lobby.database.table.Users](../gtlp.groundmc.lobby.database.table/-users/index.html) | Table to hold players' settings and more data |
| [gtlp.groundmc.lobby.enums.VisibilityStates](../gtlp.groundmc.lobby.enums/-visibility-states/index.html) | Enum to hold the visibility states. |

