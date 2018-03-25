package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object FriendsOverviewInventory {
    internal const val TITLE = "Friends"

    fun create(player: Player): Inventory = Bukkit.createInventory(player, 4 * 9, TITLE)
            .apply {
                Relationships.getRelationships(player).forEach {
                    addItem(NBTItemExt(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort())).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        val newMeta = meta as SkullMeta
                        newMeta.owningPlayer = it.user2
                        meta = newMeta
                        displayName = it.user2.name
                        val newLore = lore
                        newLore += (if (it.user2.isOnline) "${ChatColor.GREEN}Online" else "${ChatColor.RED}Offline")
                        lore = newLore
                    }.item)
                }
                while (firstEmpty() != -1) {
                    setItem(firstEmpty(), Items.FILLER.item)
                }
            }
}
