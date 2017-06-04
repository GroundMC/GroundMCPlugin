---
title: ILobbyCommand.getTabCompletion - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [ILobbyCommand](index.html) / [getTabCompletion](.)

# getTabCompletion

`abstract fun getTabCompletion(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`

Generates and returns a list of possible autocompletion entries

### Parameters

`sender` - the sender of the command

`command` - the command to get the completion for

`alias` - the alias used for this command, if an alias was used

`args` - all arguments including the one to complete

**Return**
a list of possible autocompletion entries

