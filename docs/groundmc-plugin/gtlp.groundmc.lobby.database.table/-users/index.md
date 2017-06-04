---
title: Users - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Users](.)

# Users

`object Users : Table`

Table to hold players' settings and more data

### Properties

| [coins](coins.html) | `val coins: Column<`[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`>`<br>The amount of coins this player has |
| [hiddenStatus](hidden-status.html) | `val hiddenStatus: Column<`[`VisibilityStates`](../../gtlp.groundmc.lobby.enums/-visibility-states/index.html)`>`<br>One of the [VisibilityStates](../../gtlp.groundmc.lobby.enums/-visibility-states/index.html) visibility settings |
| [id](id.html) | `val id: Column<`[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`>`<br>The [UUID](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html) of the player |
| [lastDailyCoinsDate](last-daily-coins-date.html) | `val lastDailyCoinsDate: Column<`[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)`>`<br>The last date at which the player has received daily coins (does not accumulate) |
| [lastName](last-name.html) | `val lastName: Column<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The last name with which this player has been seen |
| [silentStatus](silent-status.html) | `val silentStatus: Column<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Whether the chat is silent for this player or not |
| [vanishStatus](vanish-status.html) | `val vanishStatus: Column<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Whether this player is vanished or not |

### Functions

| [byName](by-name.html) | `fun byName(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): ResultRow?`<br>Queries the database for a [ResultRow](#) by the last name of a player |
| [getPlayer](get-player.html) | `fun getPlayer(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): ResultRow`<br>Queries the database for the [ResultRow](#) of the [player](get-player.html#gtlp.groundmc.lobby.database.table.Users$getPlayer(org.bukkit.entity.Player)/player) based on [Player.getUniqueId](#)`fun getPlayer(uuid: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): ResultRow`<br>Queries the database for the [ResultRow](#) of a player based on the [UUID](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html) |

