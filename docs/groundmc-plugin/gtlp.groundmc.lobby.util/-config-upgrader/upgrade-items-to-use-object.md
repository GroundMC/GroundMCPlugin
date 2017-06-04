---
title: ConfigUpgrader.upgradeItemsToUseObject - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [ConfigUpgrader](index.html) / [upgradeItemsToUseObject](.)

# upgradeItemsToUseObject

`fun upgradeItemsToUseObject(config: `[`Configuration`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/configuration/Configuration.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Upgrades items in the lobby inventory section of the [config](upgrade-items-to-use-object.html#gtlp.groundmc.lobby.util.ConfigUpgrader$upgradeItemsToUseObject(org.bukkit.configuration.Configuration)/config) to use a
[Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) object instead of a bunch of keys for storing the teleport
destination.

### Parameters

`config` - the configuration to update