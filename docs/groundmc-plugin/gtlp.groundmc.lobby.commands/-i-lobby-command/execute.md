---
title: ILobbyCommand.execute - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [ILobbyCommand](index.html) / [execute](.)

# execute

`abstract fun execute(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Executes a given command and returns whether the command was valid

### Parameters

`sender` - the sender that invoked the command, could be a dummy

`command` - the command that has been invoked

`label` - the alias used to invoke this command

`args` - the arguments passed on to the command

**Return**
whether or not the command was valid

