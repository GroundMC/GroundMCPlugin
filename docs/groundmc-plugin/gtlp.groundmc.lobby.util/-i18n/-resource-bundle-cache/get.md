---
title: I18n.ResourceBundleCache.get - groundmc-plugin
---

[groundmc-plugin](../../../index.html) / [gtlp.groundmc.lobby.util](../../index.html) / [I18n](../index.html) / [ResourceBundleCache](index.html) / [get](.)

# get

`fun get(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locale: Locale): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Returns the localized string (if available) for a given key
Adds locales and their resource bundles to the cache, if necessary

### Parameters

`key` - A string representing the common name for a localized string, used in resources

`locale` - The locale to translate to. If not given, English (US)

**Return**
The localized string or null, if the key has no translation

