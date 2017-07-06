---
TITLE: InventoryClickEventListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event](../index.html) / [InventoryClickEventListener](.)

# InventoryClickEventListener

`class InventoryClickEventListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)

### Constructors

| [&lt;init&gt;](-init-.html) | `InventoryClickEventListener()`<br>Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html) |

### Functions

| [cancelInventoryClick](cancel-inventory-click.html) | `fun cancelInventoryClick(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Denies default actions when clicking on items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html). Although falsely named, this also opens the [gtlp.groundmc.lobby.inventory.LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html). |
| [selectHideState](select-hide-state.html) | `fun selectHideState(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates the state of players to hide, when clicked on an option in the [gtlp.groundmc.lobby.inventory.HidePlayerInventory](../../gtlp.groundmc.lobby.inventory/-hide-player-inventory/index.html). |
| [teleportPlayer](teleport-player.html) | `fun teleportPlayer(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles an [InventoryClickEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html) and teleports a player to the location defined in the item that the player clicked on, if it is compatible. |

