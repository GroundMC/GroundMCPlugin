---
title: ILobbyCommand - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [ILobbyCommand](.)

# ILobbyCommand

`interface ILobbyCommand : `[`CommandExecutor`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandExecutor.html)`, `[`TabCompleter`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/TabCompleter.html)

Interface for commands compatible with the {@link LobbyCommandRegistry}

### Properties

| [name](name.html) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the command (used as id) |

### Functions

| [getCommandHelp](get-command-help.html) | `abstract fun getCommandHelp(locale: Locale): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Message(s) that list help content for this command |

### Inheritors

| [CommandCoins](../-command-coins/index.html) | `class CommandCoins : ILobbyCommand`<br>Command to manage coins, a virtual currency of literally no value |
| [CommandFriend](../-command-friend/index.html) | `class CommandFriend : ILobbyCommand`<br>Collection of commands related to friends management |
| [CommandFriends](../-command-friends/index.html) | `class CommandFriends : ILobbyCommand`<br>Command to list friends |
| [CommandLobby](../-command-lobby/index.html) | `class CommandLobby : ILobbyCommand`<br>The `/lobby` command. Allows players to teleport back to the lobby and obtain help. This also allows administrators to add more teleport destinations. |
| [CommandVanish](../-command-vanish/index.html) | `class CommandVanish : ILobbyCommand` |

