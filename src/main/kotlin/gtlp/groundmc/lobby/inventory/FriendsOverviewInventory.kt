package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.database.table.Relationships
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object FriendsOverviewInventory {
    internal const val TITLE = "Friends"

    fun create(player: Player): Inventory =
            Bukkit.createInventory(player, 4 * 9, TITLE)
                    .apply {
                        (0 until size).forEach {
                            setItem(it, Items.FILLER.item)
                        }
                        Relationships.getRelationships(player).forEach {
                            addItem(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort()).apply {
                                itemMeta = (itemMeta as SkullMeta).apply { owningPlayer = it.user2 }
                                itemMeta.displayName = it.user2.name
                            })
                        }
                    }
}
