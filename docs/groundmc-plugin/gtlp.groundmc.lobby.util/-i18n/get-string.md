---
title: I18n.getString - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18n](index.html) / [getString](.)

# getString

`fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)` = Locale.US): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Returns the localized string (if available) for a given key.
Automatically parses color codes using the [colorChar](color-char.html)

### Parameters

`key` - A string representing the common name for a localized string, used in resources

`locale` - The locale to translate to. If not given, [Locale.US](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#US)

**Return**
The localized and parsed string or null, if the key has no translation

`fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Returns the localized string (if available) for a given key.
The locale is parsed using [I18nUtils.getLocaleFromString](../-i18n-utils/get-locale-from-string.html)
Automatically parses color codes using the [colorChar](color-char.html)

### Parameters

`key` - A string representing the common name for a localized string, used in resources

`locale` - The locale to translate to as a string.

**Return**
The localized and parsed string or null, if the key has no translation

