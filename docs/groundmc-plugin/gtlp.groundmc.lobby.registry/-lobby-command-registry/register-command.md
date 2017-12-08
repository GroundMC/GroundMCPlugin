---
title: LobbyCommandRegistry.registerCommand - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.registry](../index.html) / [LobbyCommandRegistry](index.html) / [registerCommand](.)

# registerCommand

`fun registerCommand(cmd: `[`ILobbyCommand`](../../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Registers the [org.bukkit.command.CommandExecutor](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandExecutor.html) and
[org.bukkit.command.TabCompleter](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/TabCompleter.html) for the given [ILobbyCommand](../../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html)

### Parameters

`cmd` - the command to register