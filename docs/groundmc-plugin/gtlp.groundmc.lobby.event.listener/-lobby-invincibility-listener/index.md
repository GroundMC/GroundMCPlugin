---
title: LobbyInvincibilityListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [LobbyInvincibilityListener](.)

# LobbyInvincibilityListener

`object LobbyInvincibilityListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) takes care to protect players from any unwanted damage in
the lobby by cancelling any damage or damage-inducing events.

### Functions

| [preventDamage](prevent-damage.html) | `fun preventDamage(event: `[`EntityDamageEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Handles the [EntityDamageEvent](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/EntityDamageEvent.html) and cancels all damage in the lobby world. |
| [removePotionEffects](remove-potion-effects.html) | `fun removePotionEffects(event: `[`PotionSplashEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/entity/PotionSplashEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes potion effects from splashed potions in the lobby world. |

