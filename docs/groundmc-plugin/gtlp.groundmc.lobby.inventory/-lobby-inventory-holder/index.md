---
title: LobbyInventoryHolder - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.inventory](../index.html) / [LobbyInventoryHolder](.)

# LobbyInventoryHolder

`class LobbyInventoryHolder`

Holds the two inventories used by our plugin for a player.

### Constructors

| [&lt;init&gt;](-init-.html) | `LobbyInventoryHolder(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`)`<br>Holds the two inventories used by our plugin for a player. |

### Properties

| [hidePlayerInventory](hide-player-inventory.html) | `var hidePlayerInventory: `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)<br>The inventory for hiding players. |
| [lastLocale](last-locale.html) | `var lastLocale: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The last language a user had. Used for determining whether we need to recreate an inventory due to locale change. |
| [lobbyInventory](lobby-inventory.html) | `var lobbyInventory: `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)<br>The inventory for teleporting through the lobby |
| [originalContents](original-contents.html) | `var originalContents: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`>`<br>The contents of the player's inventory before entering the lobby. |

### Companion Object Functions

| [forPlayer](for-player.html) | `fun forPlayer(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): LobbyInventoryHolder`<br>Creates a LobbyInventoryHolder for a player with all the inventories in it. |
| [recreateInventories](recreate-inventories.html) | `fun recreateInventories(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Recreates all inventories that are currently in use. |

