---
title: NBTItemExt.addEnchantment - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [NBTItemExt](index.html) / [addEnchantment](.)

# addEnchantment

`fun addEnchantment(enchantment: `[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, level: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, ignoreLevelRestrictions: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`NBTItemExt`](index.html)

Adds the specified enchantment to this item meta.

### Parameters

`enchantment` - Enchantment to add

`level` - Level for the enchantment

`ignoreLevelRestrictions` - this indicates the enchantment should be
    applied, ignoring the level limit

**Return**
this item to allow chaining

**See Also**

[ItemMeta.addEnchant](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/meta/ItemMeta.html#addEnchant(org.bukkit.enchantments.Enchantment, int, boolean))

