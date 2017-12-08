---
title: gtlp.groundmc.lobby.event.listener - groundmc-plugin
---

[groundmc-plugin](../index.html) / [gtlp.groundmc.lobby.event.listener](.)

## Package gtlp.groundmc.lobby.event.listener

### Types

| [ChatInteractionListener](-chat-interaction-listener/index.html) | `object ChatInteractionListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the chat interaction of the players. It makes sure that the chat is not spammed by malicious players, if this feature is enabled. |
| [HidePlayerListener](-hide-player-listener/index.html) | `object HidePlayerListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles the visibility of other players towards the calling player. Handles the opening of the inventory, as well as the selection of the desired [VisibilityStates](../gtlp.groundmc.lobby.enums/-visibility-states/index.html) |
| [LobbyInteractionListener](-lobby-interaction-listener/index.html) | `object LobbyInteractionListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) handles player interactions in the lobby. |
| [LobbyInventoryListener](-lobby-inventory-listener/index.html) | `object LobbyInventoryListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>Listener to handle events that occur in a [org.bukkit.entity.Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)'s [org.bukkit.inventory.Inventory](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/inventory/Inventory.html) |
| [LobbyInvincibilityListener](-lobby-invincibility-listener/index.html) | `object LobbyInvincibilityListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) takes care to protect players from any unwanted damage in the lobby by cancelling any damage or damage-inducing events. |
| [PreventWorldInteractionListener](-prevent-world-interaction-listener/index.html) | `object PreventWorldInteractionListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) cancels any world interaction in the lobby or with items that are designed to be used in the lobby. |
| [ServerStateListener](-server-state-listener/index.html) | `object ServerStateListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>Listener to affect [Player](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/entity/Player.html)s directly. |
| [SilentChatListener](-silent-chat-listener/index.html) | `object SilentChatListener : `[`Listener`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html)<br>This [Listener](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/Listener.html) manages the silent chat function. It allows players to toggle their chat to silence and non-silence. It also filters the chat for those users that have enabled this feature. |

