---
title: CommandFriend - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandFriend](.)

# CommandFriend

`class CommandFriend : `[`ILobbyCommand`](../-i-lobby-command/index.html)

Collection of commands related to friends management

### Constructors

| [&lt;init&gt;](-init-.html) | `CommandFriend()`<br>Collection of commands related to friends management |

### Properties

| [name](name.html) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Name of the command (used as id) |

### Functions

| [addFriend](add-friend.html) | `fun addFriend(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Adds a relationship between two players. |
| [execute](execute.html) | `fun execute(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, label: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Executes a given command and returns whether the command was valid |
| [friendsStartWith](friends-start-with.html) | `fun friendsStartWith(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>Returns a list of friends that start with a certain [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html) |
| [getCommandHelp](get-command-help.html) | `fun getCommandHelp(locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Message(s) that list help content for this command |
| [getTabCompletion](get-tab-completion.html) | `fun getTabCompletion(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, command: `[`Command`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/Command.html)`, alias: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<br>Generates and returns a list of possible autocompletion entries |
| [removeFriend](remove-friend.html) | `fun removeFriend(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Removes a relationship between two players. |
| [sendOnlineFriends](send-online-friends.html) | `fun sendOnlineFriends(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Send a list of online friends to the [sender](send-online-friends.html#gtlp.groundmc.lobby.commands.CommandFriend$sendOnlineFriends(org.bukkit.entity.Player)/sender). |
| [sendStatusMessage](send-status-message.html) | `fun sendStatusMessage(sender: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Sends the status of a relationship between [sender](send-status-message.html#gtlp.groundmc.lobby.commands.CommandFriend$sendStatusMessage(org.bukkit.entity.Player, kotlin.Array((kotlin.String)))/sender) and [args](#) to [sender](send-status-message.html#gtlp.groundmc.lobby.commands.CommandFriend$sendStatusMessage(org.bukkit.entity.Player, kotlin.Array((kotlin.String)))/sender). |

