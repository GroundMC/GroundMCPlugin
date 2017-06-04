---
title: I18nUtils - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18nUtils](.)

# I18nUtils

`object I18nUtils`

Utility class for internationalization. This class provides a
central location to do specialized formatting in both
a default and a locale specific manner.

**Version**
$Revision: 1.2 $

### Functions

| [getLocaleFromCommandSender](get-locale-from-command-sender.html) | `fun getLocaleFromCommandSender(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)<br>Parses the locale from a [CommandSender](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html) to translate messages to the [sender](get-locale-from-command-sender.html#gtlp.groundmc.lobby.util.I18nUtils$getLocaleFromCommandSender(org.bukkit.command.CommandSender)/sender) |
| [getLocaleFromString](get-locale-from-string.html) | `fun getLocaleFromString(localeString: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)<br>Convert a string based locale into a Locale Object. Assumes the string has form "{language}*{country}*{variant}". Examples: "en", "de_DE", "_GB", "en_US_WIN", "de__POSIX", "fr_MAC" |

