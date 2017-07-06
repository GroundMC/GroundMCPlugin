---
title: InventoryClickEventListener.cancelInventoryClick - groundmc-plugin
---

[groundmc-plugin](../../index.html) / [gtlp.groundmc.lobby.event.listener](../index.html) / [InventoryClickEventListener](index.html) / [cancelInventoryClick](.)

# cancelInventoryClick

`fun cancelInventoryClick(event: `[`InventoryClickEvent`](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/event/inventory/InventoryClickEvent.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Denies default actions when clicking on items with the [NBTIdentifier.PREFIX](../../gtlp.groundmc.lobby.enums/-n-b-t-identifier/-p-r-e-f-i-x.html).
Although falsely named, this also opens the [gtlp.groundmc.lobby.inventory.LobbyInventory](../../gtlp.groundmc.lobby.inventory/-lobby-inventory/index.html)
when clicking on [Items.COMPASS_ITEM](../../gtlp.groundmc.lobby/-items/-c-o-m-p-a-s-s_-i-t-e-m.html).

### Parameters

`event` - the event to handle.