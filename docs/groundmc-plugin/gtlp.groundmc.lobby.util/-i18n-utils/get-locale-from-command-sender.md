---
title: I18nUtils.getLocaleFromCommandSender - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.util](../index.html) / [I18nUtils](index.html) / [getLocaleFromCommandSender](.)

# getLocaleFromCommandSender

`fun getLocaleFromCommandSender(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Locale`](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html)

Parses the locale from a [CommandSender](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html) to translate messages to the [sender](get-locale-from-command-sender.html#gtlp.groundmc.lobby.util.I18nUtils$getLocaleFromCommandSender(org.bukkit.command.CommandSender)/sender)

### Parameters

`sender` - the sender of a command to translate messages for

**Return**
the locale that has been parsed or [Locale.getDefault](http://docs.oracle.com/javase/6/docs/api/java/util/Locale.html#getDefault()),
if the [sender](get-locale-from-command-sender.html#gtlp.groundmc.lobby.util.I18nUtils$getLocaleFromCommandSender(org.bukkit.command.CommandSender)/sender) is not a player (e.g. the command has been sent from the console)

