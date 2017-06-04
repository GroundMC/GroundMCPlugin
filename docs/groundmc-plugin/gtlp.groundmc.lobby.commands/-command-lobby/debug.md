---
title: CommandLobby.debug - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandLobby](index.html) / [debug](.)

# debug

`private fun debug(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

*Forcefully* rotates the log file and tells the player the location of
the last log file that can be sent for assistance to the creator of this
plugin.

### Parameters

`sender` - the player that sent the command

**Return**
is always true to not trigger the command help of Spigot.

