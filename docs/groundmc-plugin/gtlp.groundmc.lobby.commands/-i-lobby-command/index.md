---
title: ILobbyCommand - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [ILobbyCommand](.)

# ILobbyCommand

`interface ILobbyCommand`

Interface for commands compatible with the {@link LobbyCommandRegistry}

### Properties

| [name](name.html) | `abstract val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the command (used as id) |

### Functions

| [execute](execute.html) | `abstract fun execute(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Executes a given command and returns whether the command was valid |
| [getCommandHelp](get-command-help.html) | `abstract fun getCommandHelp(locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Message(s) that list help content for this command |
| [getTabCompletion](get-tab-completion.html) | `abstract fun getTabCompletion(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>Generates and returns a list of possible autocompletion entries |

### Inheritors

| [CommandCoins](../-command-coins/index.html) | `class CommandCoins : ILobbyCommand`<br>Command to manage coins, a virtual currency of literally no value |
| [CommandFriend](../-command-friend/index.html) | `class CommandFriend : ILobbyCommand`<br>Collection of commands related to friends management |
| [CommandFriends](../-command-friends/index.html) | `class CommandFriends : ILobbyCommand`<br>Command to list friends |
| [CommandLobby](../-command-lobby/index.html) | `class CommandLobby : ILobbyCommand`<br>The `/lobby` command. Allows players to teleport back to the lobby and obtain help. This also allows administrators to add more teleport destinations. |
| [CommandVanish](../-command-vanish/index.html) | `class CommandVanish : ILobbyCommand` |

