---
TITLE: InventoryClickEventListener.cancelInventoryClick - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event](../index.html) / [InventoryClickEventListener](index.html) / [cancelInventoryClick](.)

# cancelInventoryClick

`fun cancelInventoryClick(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Denies default actions when clicking on items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html).
Although falsely named, this also opens the [gtlp.groundmc.lobby.inventory.LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html).

### Parameters

`event` - the event to handle.
