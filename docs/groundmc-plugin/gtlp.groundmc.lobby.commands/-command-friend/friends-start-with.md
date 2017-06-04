---
title: CommandFriend.friendsStartWith - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandFriend](index.html) / [friendsStartWith](.)

# friendsStartWith

`private fun friendsStartWith(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`, args: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<out `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`

Returns a list of friends that start with a certain [CharSequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char-sequence/index.html)

### Parameters

`sender` - the sender to find the friends of

`args` - the arguments given to this command, uses [kotlin.collections.last](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/last.html) to determine the beginning of the names

**Return**
a list of all friends that begin with [kotlin.collections.last](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/last.html)

