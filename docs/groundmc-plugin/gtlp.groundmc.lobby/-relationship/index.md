---
title: Relationship - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby](../index.html) / [Relationship](.)

# Relationship

`data class Relationship : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)

Class holding a relationship

### Constructors

| [&lt;init&gt;](-init-.html) | `Relationship(user1Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, user2Name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, since: `[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)` = DateTime.now())`<br>The constructor to create a Relationship out of two usernames.`Relationship(user1Id: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`, user2Id: `[`UUID`](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)`, since: `[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)` = DateTime.now())`<br>The constructor to create a Relationship out of two users' [UUID](http://docs.oracle.com/javase/6/docs/api/java/util/UUID.html)s.`Relationship(user1: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, user2: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)`, since: `[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)` = DateTime.now())`<br>Class holding a relationship |

### Properties

| [since](since.html) | `val since: `[`DateTime`](http://www.joda.org/joda-time/apidocs/org/joda/time/DateTime.html)<br>The time at which this relationship was created. |
| [user1](user1.html) | `val user1: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)<br>The first user of this relationship. Usually the initiator. |
| [user2](user2.html) | `val user2: `[`OfflinePlayer`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/OfflinePlayer.html)<br>The second user of this relationship. |

