---
title: NBTIdentifier - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.enums](../index.html) / [NBTIdentifier](.)

# NBTIdentifier

`enum class NBTIdentifier`

Enum to store NBTIdentifiers for use with [gtlp.groundmc.lobby.util.NBTItemExt](../../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html)

### Enum Values

| [PREFIX](-p-r-e-f-i-x.html) | The prefix of all identifiers |
| [TYPE](-t-y-p-e.html) | The identifier to go with [gtlp.groundmc.lobby.enums.GMCType](../-g-m-c-type/index.html) |
| [TP_LOC](-t-p_-l-o-c.html) | The identifier to go with a [org.bukkit.Location](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Location.html) |
| [SILENT_STATE](-s-i-l-e-n-t_-s-t-a-t-e.html) | The identifier to go with the silent state |
| [HIDE_STATE](-h-i-d-e_-s-t-a-t-e.html) | The identifier to go with [gtlp.groundmc.lobby.enums.VisibilityStates](../-visibility-states/index.html) |

### Constructors

| [&lt;init&gt;](-init-.html) | `NBTIdentifier(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Enum to store NBTIdentifiers for use with [gtlp.groundmc.lobby.util.NBTItemExt](../../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html) |

### Properties

| [id](id.html) | `val id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The string representation of this identifier |

### Functions

| [toString](to-string.html) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the prefix concatenated with the internal identifier. Does not concatenate the [PREFIX](-p-r-e-f-i-x.html) with itself. |

### Companion Object Functions

| [itemHasPrefix](item-has-prefix.html) | `fun itemHasPrefix(item: `[`ItemStack`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/ItemStack.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks whether an item fulfills the constraint of being not-null and having an element of type [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) with key [PREFIX](-p-r-e-f-i-x.html) and that that element is true. |

