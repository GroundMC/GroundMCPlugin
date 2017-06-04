---
title: PlayerEventListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event](../index.html) / [PlayerEventListener](.)

# PlayerEventListener

`class PlayerEventListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly.

### Constructors

| [&lt;init&gt;](-init-.html) | `PlayerEventListener()`<br>Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly. |

### Functions

| [cancelItemDrop](cancel-item-drop.html) | `fun cancelItemDrop(event: `[`PlayerDropItemEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerDropItemEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents players dropping items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html) on them. |
| [filterChat](filter-chat.html) | `fun filterChat(event: `[`AsyncPlayerChatEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/AsyncPlayerChatEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Filters the recipients of a chat message by removing all players that want a silent chat. |
| [getDirectionXZ](get-direction-x-z.html) | `fun `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`.getDirectionXZ(): `[`Vector`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/util/Vector.html)<br>Calculates a normalized vector based on the [Location.yaw](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html#yaw) on the XZ-plane. |
| [hidePlayers](hide-players.html) | `fun hidePlayers(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html). |
| [launchPlayerForward](launch-player-forward.html) | `fun launchPlayerForward(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Launches a player forward when stepping on a golden pressure plate. |
| [onPlayerChangeWorld](on-player-change-world.html) | `fun onPlayerChangeWorld(event: `[`PlayerChangedWorldEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerChangedWorldEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves and restores a player's inventory when travelling between the lobby world and another world. |
| [onPlayerLogin](on-player-login.html) | `fun onPlayerLogin(event: `[`PlayerJoinEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerJoinEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles a player joining the server. |
| [onPlayerLogout](on-player-logout.html) | `fun onPlayerLogout(event: `[`PlayerQuitEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerQuitEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cleans up when a player leaves the server. |
| [openInventory](open-inventory.html) | `fun openInventory(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the inventory that matches the item. |
| [silentChat](silent-chat.html) | `fun silentChat(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates the chat silence setting. |
| [slowChat](slow-chat.html) | `fun slowChat(event: `[`AsyncPlayerChatEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/AsyncPlayerChatEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Slows down the chat by cancelling fast chat messages. |

