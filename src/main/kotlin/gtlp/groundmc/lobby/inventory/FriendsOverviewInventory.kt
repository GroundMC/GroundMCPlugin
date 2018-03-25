package gtlp.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.I18nUtils
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.joda.time.format.DateTimeFormat

object FriendsOverviewInventory {
    internal const val TITLE = "Friends"

    fun create(player: Player): Inventory = Bukkit.createInventory(player, 4 * 9, TITLE)
            .apply {
                Relationships.getRelationships(player).forEach {
                    addItem(NBTItemExt(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort())).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        val newMeta = meta as SkullMeta
                        newMeta.owningPlayer = it.user2.toOfflinePlayer()
                        meta = newMeta
                        displayName = it.user2.name
                        val newLore = lore
                        newLore += (if (
                                CloudAPI.getInstance().getOnlinePlayer(it.user2.uniqueId) != null
                        ) "${ChatColor.GREEN}Online" else "${ChatColor.RED}Offline")
                        newLore += "Since ${it.since.toString(DateTimeFormat.mediumDate().withLocale(I18nUtils.getLocaleFromCommandSender(player)))}"
                        lore = newLore
                    }.item)
                }
                while (firstEmpty() != -1) {
                    setItem(firstEmpty(), Items.FILLER.item)
                }
            }
}
