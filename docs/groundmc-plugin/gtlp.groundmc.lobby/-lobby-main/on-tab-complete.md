---
title: LobbyMain.onTabComplete - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby](../index.html) / [LobbyMain](index.html) / [onTabComplete](.)

# onTabComplete

`fun onTabComplete(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`

Requests a list of possible completions for a command argument.

### Parameters

`sender` - Source of the command.  For players tab-completing a
    command inside of a command block, this will be the player, not
    the command block.

`command` - Command which was executed

`alias` - The alias used

`args` - The arguments passed to the command, including final
    partial argument to be completed and command label

**Return**
A List of possible completions for the final argument, or null
    to default to the command executor

