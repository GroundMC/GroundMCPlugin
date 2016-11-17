package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Friends
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.GameMode
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * Created by Marv1 on 14.11.2016.
 */
class PlayerEventListener : Listener {
    @EventHandler
    fun onPlayerLogin(event: PlayerJoinEvent) {
        transaction {
            LobbyMain.lobbyInventoryMap[event.player] = LobbyInventoryHolder.forPlayer(event.player)
            if (gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(event.player.uniqueId) }.count() == 0) {
                gtlp.groundmc.lobby.database.table.Friends.insert {
                    it[id] = event.player.uniqueId
                }
            }
            val inventory = event.player.inventory
            inventory.setItem(0, Items.COMPASS_ITEM.item.clone())
            if (event.player.hasPermission(Permission.SILENT.id) || event.player.hasPermission(Permission.ADMIN.id)) {
                val silentItem = NBTItemExt(Items.SILENT_ITEM.item.clone())
                val silent = gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(event.player.uniqueId) }.first()[Friends.silentStatus]
                silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off")
                silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    silentItem.addEnchantment(Enchantment.LUCK)
                }
                inventory.setItem(1, silentItem.item)
            }
            if (event.player.hasPermission(Permission.HIDE_PLAYERS.id) || event.player.hasPermission(Permission.ADMIN.id)) {
                val nbtItem = Items.HIDE_PLAYERS_ITEM.clone()
                val hideState = gtlp.groundmc.lobby.database.table.Friends.select { Friends.id.eq(event.player.uniqueId) }.first()[Friends.hiddenStatus]
                LobbyMain.lobbyInventoryMap[event.player]!!.hidePlayerInventory.contents.filterNotNull().first { NBTItemExt(it).getInteger(NBTIdentifier.HIDE_STATE) == hideState.ordinal }.apply {
                    this.itemMeta = NBTItemExt(this).addEnchantment(Enchantment.LUCK).item.itemMeta
                    nbtItem.displayName = itemMeta.displayName
                    nbtItem.addEnchantment(Enchantment.LUCK)

                }
                inventory.setItem(2, nbtItem.item)
            }
            if (!event.player.hasPermission(Permission.ADMIN.id)) {
                event.player.gameMode = GameMode.ADVENTURE
            } else {
                event.player.gameMode = GameMode.CREATIVE
            }
        }
    }

    @EventHandler
    fun onPlayerLogout(event: PlayerQuitEvent) {
        LobbyMain.lobbyInventoryMap.remove(event.player)
    }

    @EventHandler
    fun cancelItemDrop(event: PlayerDropItemEvent) {
        val nbtItem = NBTItemExt(event.itemDrop.itemStack)
        if (nbtItem.hasKey(NBTIdentifier.PREFIX)) {
            event.isCancelled = true
        }
    }

    @EventHandler
    fun filterChat(event: AsyncPlayerChatEvent) {
        if (event.isCancelled) {
            return
        }
        event.recipients.removeAll(LobbyMain.SILENCED_PLAYERS)
        event.recipients.add(event.player)
    }

    @EventHandler
    fun hidePlayers(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.HIDE_PLAYERS.ordinal) {
                val inventoryView = event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
            }
        }
    }

    @EventHandler
    fun silentChat(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (nbtItem.hasKey(NBTIdentifier.PREFIX) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)) {
                    LobbyMain.SILENCED_PLAYERS.remove(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                    nbtItem.displayName = I18n.getString("silentitem.off", event.player.spigot().locale)
                    nbtItem.removeEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.off", event.player.spigot().locale))
                    transaction {
                        Friends.update({ Friends.id eq event.player.uniqueId }) {
                            it[Friends.silentStatus] = false
                        }
                    }
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    nbtItem.displayName = I18n.getString("silentitem.on", event.player.spigot().locale)
                    nbtItem.addEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.spigot().locale))
                    transaction {
                        Friends.update({ Friends.id eq event.player.uniqueId }) {
                            it[Friends.silentStatus] = true
                        }
                    }
                }
                event.player.inventory.setItem(1, nbtItem.item)
            }
        }
    }

    @EventHandler
    fun openInventory(event: PlayerInteractEvent) {
        when (event.item) {
            Items.COMPASS_ITEM.item -> event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.lobbyInventory)
            Items.HIDE_PLAYERS_ITEM.item -> event.player.openInventory(LobbyMain.lobbyInventoryMap[event.player]?.hidePlayerInventory)
        }
    }
}