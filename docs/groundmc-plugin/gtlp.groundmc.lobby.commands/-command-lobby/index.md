---
title: CommandLobby - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandLobby](.)

# CommandLobby

`class CommandLobby : `[`ILobbyCommand`](../-i-lobby-command/index.html)

The `/lobby` command.
Allows players to teleport back to the lobby and obtain help.
This also allows administrators to add more teleport destinations.

### Constructors

| [&lt;init&gt;](-init-.html) | `CommandLobby()`<br>The `/lobby` command. Allows players to teleport back to the lobby and obtain help. This also allows administrators to add more teleport destinations. |

### Properties

| [name](name.html) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the command (used as id) |

### Functions

| [addItem](add-item.html) | `fun addItem(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Opens the [LobbyInventory.TEMPLATE_INVENTORY](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/-t-e-m-p-l-a-t-e_-i-n-v-e-n-t-o-r-y.html) for the [sender](add-item.html#gtlp.groundmc.lobby.commands.CommandLobby$addItem(org.bukkit.command.CommandSender)/sender) and allows administrators to add items to, so that they can be used in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html). |
| [debug](debug.html) | `fun debug(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>*Forcefully* rotates the log file and tells the player the location of the last log file that can be sent for assistance to the creator of this plugin. |
| [getCommandHelp](get-command-help.html) | `fun getCommandHelp(locale: Locale): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Message(s) that list help content for this command |
| [makeTp](make-tp.html) | `fun makeTp(args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Modifies the item the [sender](make-tp.html#gtlp.groundmc.lobby.commands.CommandLobby$makeTp(kotlin.Array((kotlin.String)), org.bukkit.command.CommandSender)/sender) has in his hand, so that it can be used as a fast travel item in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html). |
| [onCommand](on-command.html) | `fun onCommand(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onTabComplete](on-tab-complete.html) | `fun onTabComplete(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [saveTemplate](save-template.html) | `fun saveTemplate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Saves the template in the plugin-wide configuration |
| [setLobby](set-lobby.html) | `fun setLobby(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Sets the [LobbyMain.hubLocation](../../gtlp.groundmc.lobby/-lobby-main/hub-location.html) to the [sender](set-lobby.html#gtlp.groundmc.lobby.commands.CommandLobby$setLobby(org.bukkit.command.CommandSender)/sender)s current location. |

