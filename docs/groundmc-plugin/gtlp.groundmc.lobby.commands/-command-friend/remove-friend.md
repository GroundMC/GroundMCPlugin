---
title: CommandFriend.removeFriend - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandFriend](index.html) / [removeFriend](.)

# removeFriend

`private fun removeFriend(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Removes a relationship between two players.

### Parameters

`sender` - the initiator of the relationship removal

`args` - the arguments passed to this command, requires 2 to be successful ("remove" and the name of the friend).

**Return**
whether the command executed successfully.

