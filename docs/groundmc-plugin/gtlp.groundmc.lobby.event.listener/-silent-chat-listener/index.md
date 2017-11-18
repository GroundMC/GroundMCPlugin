---
title: SilentChatListener - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [SilentChatListener](.)

# SilentChatListener

`object SilentChatListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)

This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) manages the silent chat function.
It allows players to toggle their chat to silence and non-silence.
It also filters the chat for those users that have enabled this feature.

### Functions

| [filterChat](filter-chat.html) | `fun filterChat(event: `[`AsyncPlayerChatEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/AsyncPlayerChatEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Filters the recipients of a chat message by removing all players that want a silent chat. |
| [silentChat](silent-chat.html) | `fun silentChat(event: `[`PlayerInteractEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/player/PlayerInteractEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun silentChat(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Updates the chat silence setting. |
| [toggleSilentChat](toggle-silent-chat.html) | `fun toggleSilentChat(nbtItem: `[`NBTItemExt`](../../gtlp.groundmc.lobby.util/-n-b-t-item-ext/index.html)`, player: `[`Player`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Toggles the chat silence settings for a [player](toggle-silent-chat.html#gtlp.groundmc.lobby.event.listener.SilentChatListener$toggleSilentChat(gtlp.groundmc.lobby.util.NBTItemExt, org.bukkit.entity.Player)/player). This method saves the state for the next login and sends the respective message to the player. |

