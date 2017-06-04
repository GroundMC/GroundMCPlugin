---
title: I18n - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18n](.)

# I18n

`object I18n`

Kotlin object to aid with internationalization (I18n)

### Types

| [ResourceBundleCache](-resource-bundle-cache/index.html) | `class ResourceBundleCache`<br>A cache for dynamically loading and storing used resource bundles. Does not implement removing items from the cache because of low memory impact |

### Properties

| [bundleCache](bundle-cache.html) | `val bundleCache: `[`ResourceBundleCache`](-resource-bundle-cache/index.html)<br>The ResourceBundleCache used in our project |
| [colorChar](color-char.html) | `val colorChar: `[`Char`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html)<br>The character used to mark styling codes Hardcoded to the most common value |

### Functions

| [getString](get-string.html) | `fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)` = Locale.US): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the localized string (if available) for a given key. Automatically parses color codes using the [colorChar](color-char.html)`fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<br>Returns the localized string (if available) for a given key. The locale is parsed using [I18nUtils.getLocaleFromString](../-i18n-utils/get-locale-from-string.html) Automatically parses color codes using the [colorChar](color-char.html) |
| [getStrings](get-strings.html) | `fun getStrings(vararg keys: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)` = Locale.US): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>`fun getStrings(vararg keys: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>Returns a list of localized strings (if available) for the given keys. Automatically parses color codes using the [colorChar](color-char.html) |

