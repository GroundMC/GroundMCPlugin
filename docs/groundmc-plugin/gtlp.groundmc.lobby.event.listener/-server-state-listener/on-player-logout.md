---
title: ServerStateListener.onPlayerLogout - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [ServerStateListener](index.html) / [onPlayerLogout](.)

# onPlayerLogout

`fun onPlayerLogout(event: `[`PlayerQuitEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerQuitEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Cleans up when a player leaves the server.
Removes any message that should be sent on joining the server.

### Parameters

`event` - the event to handle