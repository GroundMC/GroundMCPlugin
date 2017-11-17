---
title: I18n.getStrings - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18n](index.html) / [getStrings](.)

# getStrings

`fun getStrings(vararg keys: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: Locale = Locale.US): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`

Returns a list of localized strings (if available) for the given keys.
Automatically parses color codes using the [colorChar](color-char.html)

### Parameters

`keys` - A collection of strings representing the common names for the localized strings, used in resources

`locale` - The locale to translate to. If not given, [Locale.US](#)

**Return**
The localized and parsed strings with null where strings could not be localized

**See Also**

[getString](get-string.html)

`fun getStrings(vararg keys: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`

Returns a list of localized strings (if available) for the given keys.
Automatically parses color codes using the [colorChar](color-char.html)

### Parameters

`keys` - A collection of strings representing the common names for the localized strings, used in resources

`locale` - The locale to translate to.

**Return**
The localized and parsed strings with null where strings could not be localized

**See Also**

[getString](get-string.html)

