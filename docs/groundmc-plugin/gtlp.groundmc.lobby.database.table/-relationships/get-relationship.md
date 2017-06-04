---
title: Relationships.getRelationship - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Relationships](index.html) / [getRelationship](.)

# getRelationship

`fun getRelationship(player: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, friend: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`): `[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`?`
`fun getRelationship(player: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`, friend: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): `[`Relationship`](../../gtlp.groundmc.lobby/-relationship/index.html)`?`

Gets the relationship between [player](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player)  and [friend](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend)

### Parameters

`player` - the player to query the relationship for

`friend` - the friend to get the relationship for

**Return**
a [Relationship](../../gtlp.groundmc.lobby/-relationship/index.html) object holding the relationship between [player](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/player) and [friend](get-relationship.html#gtlp.groundmc.lobby.database.table.Relationships$getRelationship(org.bukkit.OfflinePlayer, org.bukkit.OfflinePlayer)/friend), if any, otherwise null

