---
title: CommandLobby.addItem - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.commands](../index.html) / [CommandLobby](index.html) / [addItem](.)

# addItem

`private fun addItem(sender: `[`CommandSender`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/command/CommandSender.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Opens the [LobbyInventory.TEMPLATE_INVENTORY](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/-t-e-m-p-l-a-t-e_-i-n-v-e-n-t-o-r-y.html) for the [sender](add-item.html#gtlp.groundmc.lobby.commands.CommandLobby$addItem(org.bukkit.command.CommandSender)/sender) and allows
administrators to add items to, so that they can be used in the [gtlp.groundmc.lobby.Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html).

### Parameters

`sender` - the player that sent the command

**Return**
`true` when the items have been successfully, `false` otherwise.

