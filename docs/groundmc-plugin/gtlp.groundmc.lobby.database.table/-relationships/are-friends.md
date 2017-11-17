---
title: Relationships.areFriends - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Relationships](index.html) / [areFriends](.)

# areFriends

`fun areFriends(player: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, friend: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Queries the database for a relationship between [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player) and [friend](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend)

### Parameters

`player` - the player to query the relationship for

`friend` - the possible friend of [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player)

**Return**
whether there exists a relationship between [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player) and [friend](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend)

`fun areFriends(player: UUID, friend: UUID): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Queries the database for a relationship between [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(java.util.UUID, java.util.UUID)/player) and [friend](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(java.util.UUID, java.util.UUID)/friend)

### Parameters

`player` - the player to query the relationship for

`friend` - the possible friend of [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(java.util.UUID, java.util.UUID)/player)

**Return**
whether there exists a relationship between [player](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(java.util.UUID, java.util.UUID)/player) and [friend](are-friends.html#gtlp.groundmc.lobby.database.table.Relationships$areFriends(java.util.UUID, java.util.UUID)/friend)

**See Also**

areFriends

