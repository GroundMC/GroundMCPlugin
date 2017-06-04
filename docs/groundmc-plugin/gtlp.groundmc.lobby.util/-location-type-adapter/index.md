---
title: LocationTypeAdapter - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [LocationTypeAdapter](.)

# LocationTypeAdapter

`object LocationTypeAdapter : `[`TypeAdapter`](https://google.github.io/gson/apidocs/com/google/gson/TypeAdapter.html)`<`[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`>`

An adapter to serialize and deserialize a [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object

### Functions

| [read](read.html) | `fun read(reader: `[`JsonReader`](https://google.github.io/gson/apidocs/com/google/gson/stream/JsonReader.html)`): `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`?`<br>Reads a JSON-encoded string and converts it to a [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object. |
| [write](write.html) | `fun write(writer: `[`JsonWriter`](https://google.github.io/gson/apidocs/com/google/gson/stream/JsonWriter.html)`, location: `[`Location`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Writes a [Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object to a [JsonWriter](https://google.github.io/gson/apidocs/com/google/gson/stream/JsonWriter.html). |

