---
title: setOrAdd - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [kotlin.collections.MutableList](index.html) / [setOrAdd](.)

# setOrAdd

`fun <E> `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<E>.setOrAdd(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: E): `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<E>`

Extension to [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html).

Sets the value at the specified index, if it exists.
Adds the value at the specified index, if it doesn't exist.

### Parameters

`index` - the index to set or add.

`value` - the value to set.

`E` - the type of the elements in this list.

**Return**
the list with the element set or added.

