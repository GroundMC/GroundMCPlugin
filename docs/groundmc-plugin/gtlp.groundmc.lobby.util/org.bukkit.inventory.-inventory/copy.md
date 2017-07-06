---
title: copy - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [org.bukkit.inventory.Inventory](index.html) / [copy](.)

# copy

`fun `[`Inventory`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html)`.copy(): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?>`

Extension to [Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html).

Creates a real copy of the contents of an inventory.
This makes sure that changes to the inventory are not reflected in the
resulting array.

**Receiver**
the inventory you want the contents to be copied from

**Return**
an array of the items in this inventory. Preserves `null`.

