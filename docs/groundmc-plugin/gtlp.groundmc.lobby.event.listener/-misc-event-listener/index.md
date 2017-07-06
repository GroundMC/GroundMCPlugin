---
title: MiscEventListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [MiscEventListener](.)

# MiscEventListener

`class MiscEventListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

Listener to handle miscellaneous events.

### Constructors

| [&lt;init&gt;](-init-.html) | `MiscEventListener()`<br>Listener to handle miscellaneous events. |

### Functions

| [cancelBlockPlace](cancel-block-place.html) | `fun cancelBlockPlace(event: `[`BlockPlaceEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/block/BlockPlaceEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Prevents players to place blocks with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html) on them. |
| [removePotionEffects](remove-potion-effects.html) | `fun removePotionEffects(event: `[`PotionSplashEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/PotionSplashEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes potion effects from splashed potions in the lobby world. |

