---
title: CommandLobby.makeTp - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandLobby](index.html) / [makeTp](.)

# makeTp

`private fun makeTp(args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Modifies the item the [sender](make-tp.html#gtlp.groundmc.lobby.commands.CommandLobby$makeTp(kotlin.Array((kotlin.String)), org.bukkit.command.CommandSender)/sender) has in his hand, so that it can be used as
a fast travel item in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html).

Uses the current [sender](make-tp.html#gtlp.groundmc.lobby.commands.CommandLobby$makeTp(kotlin.Array((kotlin.String)), org.bukkit.command.CommandSender)/sender)s position for the teleport destination.

### Parameters

`args` - the arguments that accompany this command

`sender` - the player that sent the command

**Return**
`true` when the item has successfully been modified, `false` otherwise.

