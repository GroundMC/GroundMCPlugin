---
title: NBTItemExt - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [NBTItemExt](.)

# NBTItemExt

`class NBTItemExt : NBTItem, `[`Cloneable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-cloneable/index.html)

Extension of [de.tr7zw.itemnbtapi.NBTItem](#)
Allows the use of [NBTIdentifier](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) as a key.

### Constructors

| [&lt;init&gt;](-init-.html) | `NBTItemExt(item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`)`<br>Extension of [de.tr7zw.itemnbtapi.NBTItem](#) Allows the use of [NBTIdentifier](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html) as a key. |

### Properties

| [displayName](display-name.html) | `var displayName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>The displayed name for this item. This member allows easy read and write access. |
| [lore](lore.html) | `var lore: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>The lore of this item. This member allow easy read and write access. |
| [meta](meta.html) | `var meta: `[`ItemMeta`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/meta/ItemMeta.html)<br>The metadata of this item. This member allows easy read and write access. |

### Functions

| [addEnchantment](add-enchantment.html) | `fun addEnchantment(enchantment: `[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`, level: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 1, ignoreLevelRestrictions: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): NBTItemExt`<br>Adds the specified enchantment to this item meta. |
| [addItemFlags](add-item-flags.html) | `fun addItemFlags(vararg flags: `[`ItemFlag`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemFlag.html)`): NBTItemExt`<br>Adds flags to this item. |
| [clone](clone.html) | `fun clone(): NBTItemExt`<br>Clones this item by creating a new instance of this item. |
| [getBoolean](get-boolean.html) | `fun getBoolean(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`<br>Gets a boolean value for an identifier |
| [getDouble](get-double.html) | `fun getDouble(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`?`<br>Gets a double value for an identifier |
| [getInteger](get-integer.html) | `fun getInteger(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?`<br>Gets an integer value for an identifier |
| [getObject](get-object.html) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getObject(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, kClass: `[`KClass`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.reflect/-k-class/index.html)`<T>): T?`<br>Gets an object value for an identifier |
| [getString](get-string.html) | `fun getString(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Gets a string value for an identifier |
| [hasKey](has-key.html) | `fun hasKey(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?`<br>Checks whether this item has a key with a value mapped to it. |
| [removeEnchantment](remove-enchantment.html) | `fun removeEnchantment(enchantment: `[`Enchantment`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html)`): NBTItemExt`<br>Removes the specified enchantment from this item meta. |
| [removeItemFlags](remove-item-flags.html) | `fun removeItemFlags(vararg flags: `[`ItemFlag`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemFlag.html)`): NBTItemExt`<br>Removes flags to this item. |
| [removeKey](remove-key.html) | `fun removeKey(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Removes a key-value pair from this item |
| [setBoolean](set-boolean.html) | `fun setBoolean(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): NBTItemExt`<br>Sets a boolean value for a key. |
| [setDouble](set-double.html) | `fun setDouble(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, value: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): NBTItemExt`<br>Sets a double value for a key. |
| [setInteger](set-integer.html) | `fun setInteger(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, value: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): NBTItemExt`<br>Sets an integer value for a key. |
| [setObject](set-object.html) | `fun setObject(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, value: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`): NBTItemExt`<br>Sets a object value for a key. |
| [setString](set-string.html) | `fun setString(identifier: `[`NBTIdentifier`](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): NBTItemExt`<br>Sets a string value for a key. |
| [toString](to-string.html) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Creates a string representation of this item. |

