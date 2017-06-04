---
title: CommandFriend.sendStatusMessage - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandFriend](index.html) / [sendStatusMessage](.)

# sendStatusMessage

`private fun sendStatusMessage(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Sends the status of a relationship between [sender](send-status-message.html#gtlp.groundmc.lobby.commands.CommandFriend$sendStatusMessage(org.bukkit.entity.Player, kotlin.Array((kotlin.String)))/sender) and [args](#) to [sender](send-status-message.html#gtlp.groundmc.lobby.commands.CommandFriend$sendStatusMessage(org.bukkit.entity.Player, kotlin.Array((kotlin.String)))/sender).

### Parameters

`sender` - the requester of the status message

`args` - the arguments passed to this command, requires 2 to be successful ("status" and the name of the friend).

**Return**
whether the command executed successfully.

