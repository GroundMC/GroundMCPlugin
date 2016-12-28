package gtlp.groundmc.lobby.event

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.attribute.Attribute
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.*
import org.bukkit.util.Vector
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import org.joda.time.DateTime

/**
 * Created by Marv1 on 14.11.2016.
 */
class PlayerEventListener : Listener {

    @EventHandler
    fun onPlayerChangeWorld(event: PlayerChangedWorldEvent) {
        if (event.from == LobbyMain.hubWorld) {
            event.player.inventory.apply {
                setItem(0, null)
                setItem(1, null)
                setItem(2, null)
            }
        } else if (event.player.world == LobbyMain.hubWorld) {
            addItemsToInventory(event.player)
        }
    }

    @EventHandler
    fun onPlayerLogin(event: PlayerJoinEvent) {
        addItemsToInventory(event.player)
        event.player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).baseValue = 16.0

        val playerRow = Users.getPlayer(event.player)
        if (playerRow[Users.lastDailyCoinsDate].plusDays(1).isBeforeNow) {
            event.player.sendMessage(I18n.getString("event.dailyCoins", event.player.spigot().locale)?.format(LobbyMain.dailyCoins))
            event.player.playSound(event.player.location, Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f)
            transaction {
                Users.update({ Users.id eq event.player.uniqueId }) {
                    it[Users.lastName] = event.player.name
                    it[Users.coins] = playerRow[Users.coins] + LobbyMain.dailyCoins
                    it[Users.lastDailyCoinsDate] = DateTime.now()
                }
                commit()
            }
        }
    }

    private fun addItemsToInventory(player: Player) {
        transaction {
            LobbyMain.lobbyInventoryMap[player] = LobbyInventoryHolder.forPlayer(player)
            if (Users.select { Users.id.eq(player.uniqueId) }.count() == 0) {
                Users.insert {
                    it[Users.id] = player.uniqueId
                }
            }
            val inventory = player.inventory
            inventory.setItem(0, Items.COMPASS_ITEM.item.clone())
            if (player.hasPermission(Permission.SILENT.id) || player.hasPermission(Permission.ADMIN.id)) {
                val silentItem = NBTItemExt(Items.SILENT_ITEM.item.clone())
                val silent = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.silentStatus]
                silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off")
                silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    silentItem.addEnchantment(Enchantment.LUCK)
                }
                inventory.setItem(1, silentItem.item)
            }
            if (player.hasPermission(Permission.HIDE_PLAYERS.id) || player.hasPermission(Permission.ADMIN.id)) {
                val nbtItem = Items.HIDE_PLAYERS_ITEM.clone()
                val hideState = Users.select { Users.id.eq(player.uniqueId) }.first()[Users.hiddenStatus]
                LobbyMain.lobbyInventoryMap[player]!!.hidePlayerInventory.contents.filterNotNull().first { NBTItemExt(it).getInteger(NBTIdentifier.HIDE_STATE) == hideState.ordinal }.apply {
                    this.itemMeta = NBTItemExt(this).addEnchantment(Enchantment.LUCK).item.itemMeta
                    nbtItem.displayName = itemMeta.displayName
                    nbtItem.addEnchantment(Enchantment.LUCK)

                }
                inventory.setItem(2, nbtItem.item)
            }
            if (!player.hasPermission(Permission.ADMIN.id)) {
                player.gameMode = GameMode.ADVENTURE
            } else {
                player.gameMode = GameMode.CREATIVE
            }
        }
    }

    @EventHandler
    fun onPlayerLogout(event: PlayerQuitEvent) {
        LobbyMain.lobbyInventoryMap.remove(event.player)
        LobbyMain.SILENCED_PLAYERS.remove(event.player)
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
                        Users.update({ Users.id eq event.player.uniqueId }) {
                            it[Users.silentStatus] = false
                        }
                    }
                } else {
                    LobbyMain.SILENCED_PLAYERS.add(event.player)
                    nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                    nbtItem.displayName = I18n.getString("silentitem.on", event.player.spigot().locale)
                    nbtItem.addEnchantment(Enchantment.LUCK)
                    event.player.sendMessage(I18n.getString("silentmsg.on", event.player.spigot().locale))
                    transaction {
                        Users.update({ Users.id eq event.player.uniqueId }) {
                            it[Users.silentStatus] = true
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

    @EventHandler
    fun launchPlayerForward(event: PlayerInteractEvent) {
        if (event.clickedBlock != null) {
            if (event.clickedBlock.type == Material.GOLD_PLATE && event.player.world == LobbyMain.hubWorld && event.action == Action.PHYSICAL) {
                event.player.velocity = event.player.location.getDirectionXZ().setY(0.5).multiply(3)
                event.isCancelled = true
            }
        }
    }

    fun Location.getDirectionXZ(): Vector {
        val vector = Vector()

        val rotX = this.yaw.toDouble()

        vector.y = 0.0

        vector.x = -Math.sin(Math.toRadians(rotX))
        vector.z = Math.cos(Math.toRadians(rotX))

        return vector.normalize()
    }
}
