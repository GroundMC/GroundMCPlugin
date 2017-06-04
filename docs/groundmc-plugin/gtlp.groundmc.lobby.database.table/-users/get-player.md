---
title: Users.getPlayer - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.database.table](../index.html) / [Users](index.html) / [getPlayer](.)

# getPlayer

`fun getPlayer(player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): ResultRow`

Queries the database for the [ResultRow](#) of the [player](get-player.html#gtlp.groundmc.lobby.database.table.Users$getPlayer(org.bukkit.entity.Player)/player) based on [Player.getUniqueId](#)

### Parameters

`player` - the player to query the database for

**Return**
a row that contains all the columns defined in this class

`fun getPlayer(uuid: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`): ResultRow`

Queries the database for the [ResultRow](#) of a player based on the [UUID](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)

### Parameters

`uuid` - the id to query the database for

**Return**
a row that contains all the columns defined in this class

