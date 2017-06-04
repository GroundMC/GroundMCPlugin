---
title: LobbyCommandRegistry - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.registry](../index.html) / [LobbyCommandRegistry](.)

# LobbyCommandRegistry

`object LobbyCommandRegistry`

Registry where all commands are saved.
Used by [LobbyMain](../../gtlp.groundmc.lobby/-lobby-main/index.html)

### Properties

| [commands](commands.html) | `val commands: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`ILobbyCommand`](../../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html)`>`<br>A map of command strings to their respective command object. |

### Functions

| [getCommand](get-command.html) | `fun getCommand(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ILobbyCommand`](../../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html)`?`<br>Gets the command for the command string |
| [hasCommand](has-command.html) | `fun hasCommand(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks whether this registry contains a command. |
| [registerCommand](register-command.html) | `fun registerCommand(cmd: `[`ILobbyCommand`](../../gtlp.groundmc.lobby.commands/-i-lobby-command/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Registers a command by adding it to the map. |

