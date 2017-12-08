---
title: HidePlayerListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [HidePlayerListener](.)

# HidePlayerListener

`object HidePlayerListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the visibility of other players towards the calling
player.
Handles the opening of the inventory, as well as the selection of the desired
[VisibilityStates](../../gtlp.groundmc.lobby.enums/-visibility-states/index.html)

### Functions

| [openHidePlayInventory](open-hide-play-inventory.html) | `fun openHidePlayInventory(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html). |
| [openHidePlayerInventory](open-hide-player-inventory.html) | `fun openHidePlayerInventory(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html). |
| [selectHideState](select-hide-state.html) | `fun selectHideState(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates the state of players to hide, when clicked on an option in the [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html). |

