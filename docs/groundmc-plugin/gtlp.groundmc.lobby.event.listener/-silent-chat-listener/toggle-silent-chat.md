---
title: SilentChatListener.toggleSilentChat - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [SilentChatListener](index.html) / [toggleSilentChat](.)

# toggleSilentChat

`private fun toggleSilentChat(nbtItem: `[`NBTItemExt`](../../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html)`, player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Toggles the chat silence settings for a [player](toggle-silent-chat.html#gtlp.groundmc.lobby.event.listener.SilentChatListener$toggleSilentChat(gtlp.groundmc.lobby.util.NBTItemExt, org.bukkit.entity.Player)/player).
This method saves the state for the next login and sends the respective
message to the player.

### Parameters

`nbtItem` - the item that has been used to toggle this setting

`player` - the player that toggles the setting