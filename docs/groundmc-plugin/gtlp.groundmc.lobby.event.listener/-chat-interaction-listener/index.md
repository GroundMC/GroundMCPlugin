---
title: ChatInteractionListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [ChatInteractionListener](.)

# ChatInteractionListener

`object ChatInteractionListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the chat interaction of the players.
It makes sure that the chat is not spammed by malicious players, if this
feature is enabled.

### Properties

| [timeout](timeout.html) | `val timeout: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Holds the timeout for chat messages per user in milliseconds. This is initialized only once when needed, thus lazy. |

### Functions

| [slowChat](slow-chat.html) | `fun slowChat(event: `[`AsyncPlayerChatEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/AsyncPlayerChatEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Slows down the chat by cancelling fast chat messages. |

