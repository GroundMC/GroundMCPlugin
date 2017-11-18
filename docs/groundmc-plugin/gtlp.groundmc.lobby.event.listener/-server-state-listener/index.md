---
title: ServerStateListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [ServerStateListener](.)

# ServerStateListener

`object ServerStateListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly.

### Functions

| [addDailyBonus](add-daily-bonus.html) | `fun addDailyBonus(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds the daily bonus coins to the balance of [player](add-daily-bonus.html#gtlp.groundmc.lobby.event.listener.ServerStateListener$addDailyBonus(org.bukkit.entity.Player)/player), if eligible. |
| [addItemsToInventory](add-items-to-inventory.html) | `fun addItemsToInventory(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Generates and adds items to a player's inventory according to their permissions. |
| [onPlayerChangeLocale](on-player-change-locale.html) | `fun onPlayerChangeLocale(event: `[`PlayerChangeLocaleEvent`](../../gtlp.groundmc.lobby.event/-player-change-locale-event/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles changes in a player's locale. |
| [onPlayerChangeWorld](on-player-change-world.html) | `fun onPlayerChangeWorld(event: `[`PlayerChangedWorldEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerChangedWorldEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves and restores a player's inventory when travelling between the lobby world and another world. |
| [onPlayerLogin](on-player-login.html) | `fun onPlayerLogin(event: `[`PlayerJoinEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerJoinEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles a player joining the server. |
| [onPlayerLogout](on-player-logout.html) | `fun onPlayerLogout(event: `[`PlayerQuitEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerQuitEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cleans up when a player leaves the server. |

