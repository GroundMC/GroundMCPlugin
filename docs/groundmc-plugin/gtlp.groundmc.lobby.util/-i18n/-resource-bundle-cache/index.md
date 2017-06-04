---
title: I18n.ResourceBundleCache - groundmc-plugin
---

[groundmc-plugin](../../../index.html) / [gtlp.groundmc.lobby.util](../../index.html) / [I18n](../index.html) / [ResourceBundleCache](.)

# ResourceBundleCache

`private class ResourceBundleCache`

A cache for dynamically loading and storing used resource bundles.
Does not implement removing items from the cache because of low memory impact

### Constructors

| [&lt;init&gt;](-init-.html) | `ResourceBundleCache(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>A cache for dynamically loading and storing used resource bundles. Does not implement removing items from the cache because of low memory impact |

### Properties

| [backingMap](backing-map.html) | `val backingMap: `[`ConcurrentHashMap`](http://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ConcurrentHashMap.html)`<`[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)`, `[`ResourceBundle`](http://docs.oracle.com/javase/6/docs/api/java/util/ResourceBundle.html)`>`<br>A map holding resource bundles for locales |
| [name](name.html) | `val name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The name of this cache. |

### Functions

| [get](get.html) | `fun get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the localized string (if available) for a given key Adds locales and their resource bundles to the cache, if necessary |

