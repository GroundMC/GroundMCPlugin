---
title: PreventWorldInteractionListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [PreventWorldInteractionListener](.)

# PreventWorldInteractionListener

`object PreventWorldInteractionListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) cancels any world interaction in the lobby or with items
that are designed to be used in the lobby.

Interactions include dropping items, placing blocks or picking up items.

### Functions

| [cancelBlockPlace](cancel-block-place.html) | `fun cancelBlockPlace(event: `[`BlockPlaceEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/block/BlockPlaceEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents players to place blocks with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html) on them. |
| [cancelItemDrop](cancel-item-drop.html) | `fun cancelItemDrop(event: `[`PlayerDropItemEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerDropItemEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents players dropping items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html) on them. |
| [preventBlockBreaking](prevent-block-breaking.html) | `fun preventBlockBreaking(event: `[`BlockBreakEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/block/BlockBreakEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents non-admin players from breaking blocks in the hub. |
| [preventItemPickup](prevent-item-pickup.html) | `fun preventItemPickup(event: `[`EntityPickupItemEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityPickupItemEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents non-admin players from picking up items when they are in the hub. |

