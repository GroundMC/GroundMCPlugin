---
title: I18nUtils.getLocaleFromString - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18nUtils](index.html) / [getLocaleFromString](.)

# getLocaleFromString

`fun getLocaleFromString(localeString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)

Convert a string based locale into a Locale Object.
Assumes the string has form "{language}*{country}*{variant}".
Examples: "en", "de_DE", "_GB", "en_US_WIN", "de__POSIX", "fr_MAC"

### Parameters

`localeString` - The String

**Return**
the Locale

