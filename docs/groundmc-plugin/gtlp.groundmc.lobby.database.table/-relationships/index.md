---
title: Relationships - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Relationships](.)

# Relationships

`object Relationships : Table`

Table holding relationships between players, including more information

### Properties

| [since](since.html) | `val since: Column<`[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)`>`<br>The timestamp at which the relationship was created. |
| [userId1](user-id1.html) | `val userId1: Column<UUID>`<br>The [UUID](#) of the first player in the relationship. Usually the initiator. |
| [userId2](user-id2.html) | `val userId2: Column<UUID>`<br>The [UUID](#) of the second player in the relationship. |

### Functions

| [addRelationship](add-relationship.html) | `fun addRelationship(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, friend: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a relationship between [player](add-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$addRelationship(org.bukkit.entity.Player, org.bukkit.entity.Player)/player) and [friend](add-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$addRelationship(org.bukkit.entity.Player, org.bukkit.entity.Player)/friend)`fun addRelationship(relationship: `[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Adds a relationship between [Relationship.user1](../../gtlp.groundmc.lobby/-relationship/user1.html) and [Relationship.user2](../../gtlp.groundmc.lobby/-relationship/user2.html) |
| [areFriends](are-friends.html) | `fun areFriends(player: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, friend: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>`fun areFriends(player: UUID, friend: UUID): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Queries the database for a relationship between [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player) and [friend](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend) |
| [getRelationship](get-relationship.html) | `fun getRelationship(player: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, friend: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`): `[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`?`<br>`fun getRelationship(player: UUID, friend: UUID): `[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`?`<br>Gets the relationship between [player](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player)  and [friend](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend) |
| [getRelationships](get-relationships.html) | `fun getRelationships(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`>`<br>Queries the database for a relationships of [player](get-relationships.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationships(org.bukkit.entity.Player)/player) |
| [removeRelationship](remove-relationship.html) | `fun removeRelationship(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`, friend: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes a relationship between [player](remove-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$removeRelationship(org.bukkit.entity.Player, org.bukkit.OfflinePlayer)/player) and [friend](remove-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$removeRelationship(org.bukkit.entity.Player, org.bukkit.OfflinePlayer)/friend) |

