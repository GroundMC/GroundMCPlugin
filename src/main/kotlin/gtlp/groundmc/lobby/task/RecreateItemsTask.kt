package gtlp.groundmc.lobby.task

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.Permission
import gtlp.groundmc.lobby.inventory.LobbyInventoryHolder
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.SkullMeta
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object RecreateItemsTask : ITask {
    override val delay = 20L
    override val period = 40L

    override fun run() {
        Bukkit.getOnlinePlayers().forEach { player ->
            if (player.world == LobbyMain.hubLocation.get().world) {
                if (player.spigot().locale != LobbyMain.lobbyInventoryMap[player]?.lastLocale) {
                    val originalContents = LobbyMain.lobbyInventoryMap[player]?.originalContents?.clone()
                    LobbyMain.lobbyInventoryMap[player] = LobbyInventoryHolder.forPlayer(player)
                    LobbyMain.lobbyInventoryMap[player]?.originalContents = originalContents!!
                    addItemsToInventory(player)
                }
            }
        }
    }

    fun addItemsToInventory(player: Player) {
        transaction {
            if (gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(player.uniqueId) }.count() == 0) {
                gtlp.groundmc.lobby.database.table.Users.insert {
                    it[id] = player.uniqueId
                    it[lastName] = player.name
                }
            }
            val inventory = player.inventory
            inventory.clear()

            inventory.setItem(0, Items.COMPASS_ITEM.clone().item)

            if (player.hasPermission(Permission.SILENT.id) || player.hasPermission(Permission.ADMIN.id)) {
                val silentItem = Items.SILENT_ITEM.clone()
                val silent = gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(player.uniqueId) }.first()[Users.silentStatus]
                silentItem.displayName = I18n.getString(if (silent) "silentitem.on" else "silentitem.off", player.spigot().locale)
                silentItem.setBoolean(NBTIdentifier.SILENT_STATE, silent)
                if (silent) {
                    silentItem.addEnchantment(Enchantment.LUCK)
                }
                inventory.setItem(1, silentItem.item)
            }

            if (player.hasPermission(Permission.HIDE_PLAYERS.id) || player.hasPermission(Permission.ADMIN.id)) {
                val nbtItem = Items.HIDE_PLAYERS_ITEM.clone().apply { displayName = I18n.getString("visibility.all", player.spigot().locale) }
                val hideState = gtlp.groundmc.lobby.database.table.Users.select { Users.id.eq(player.uniqueId) }.first()[Users.hiddenStatus]
                LobbyMain.lobbyInventoryMap[player]!!.hidePlayerInventory.contents.filterNotNull().first { NBTItemExt(it).getInteger(NBTIdentifier.HIDE_STATE) == hideState.ordinal }.apply {
                    this.itemMeta = NBTItemExt(this).addEnchantment(Enchantment.LUCK).item.itemMeta
                    nbtItem.displayName = itemMeta.displayName
                    nbtItem.addEnchantment(Enchantment.LUCK)

                }
                inventory.setItem(2, nbtItem.item)
            }
            inventory.setItem(5, Items.FRIENDS_ITEM.clone().apply {
                val skullMeta = Bukkit.getItemFactory().asMetaFor(item.itemMeta, this.item) as SkullMeta
                skullMeta.owner = player.name
                item.itemMeta = skullMeta

            }.item)
        }
    }
}