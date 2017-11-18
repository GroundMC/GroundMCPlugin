---
title: LobbyInventoryListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [LobbyInventoryListener](.)

# LobbyInventoryListener

`object LobbyInventoryListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)

### Functions

| [cancelInventoryClick](cancel-inventory-click.html) | `fun cancelInventoryClick(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Denies default actions when clicking on items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html). |
| [openLobbyInventory](open-lobby-inventory.html) | `fun openLobbyInventory(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the [gtlp.groundmc.lobby.inventory.LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) when clicking on [Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html) in an inventory in the lobby world.`fun openLobbyInventory(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Opens the [gtlp.groundmc.lobby.inventory.LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html) when clicking with [Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html) in the lobby world. |
| [teleportPlayer](teleport-player.html) | `fun teleportPlayer(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles an [InventoryClickEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html) and teleports a player to the location defined in the item that the player clicked on, if it is compatible. |

