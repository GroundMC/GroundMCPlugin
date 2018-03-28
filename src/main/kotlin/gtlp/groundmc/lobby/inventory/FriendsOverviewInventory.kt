package gtlp.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.I18NStrings
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

    private const val PAGE_SIZE = 3 * 9
    private const val INFO_ITEM_INDEX = PAGE_SIZE + 5

    internal const val TITLE = "Friends"

    fun create(player: Player): Inventory = Bukkit.createInventory(player, 4 * 9, TITLE)
            .apply {
                Relationships.getRelationships(player).subList(0, PAGE_SIZE).forEach {
                    addItem(NBTItemExt(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort())).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        val newMeta = meta as SkullMeta
                        newMeta.owningPlayer = it.user2.offlinePlayer
                        meta = newMeta
                        displayName = it.user2.name
                        val newLore = lore
                        newLore += (if (
                                CloudAPI.getInstance().getOnlinePlayer(it.user2.uniqueId) != null
                        ) "${ChatColor.GREEN}Online" else "${ChatColor.RED}Offline")
                        newLore += I18NStrings.RELATIONSHIP_SINCE.format(player.locale,
                                it.since.toString(DateTimeFormat.mediumDate()
                                        .withLocale(I18nUtils.getLocaleFromCommandSender(player))))
                                ?: ""
                        newLore += I18NStrings.FRIENDS_PAGE.format(player, 1,
                                Relationships.getRelationships(player).size / PAGE_SIZE)
                                ?: ""
                        lore = newLore
                    }.item)
                }
                setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    val newLore = lore
                    newLore += "Page: 1/${Relationships.getRelationships(player).size / PAGE_SIZE}"
                    newLore += "Online: ${Relationships.getOnlineFriends(player).size}"
                    lore = newLore
                }.item)

                contents.forEachIndexed { index, itemStack ->
                    if (itemStack == null) {
                        setItem(index, Items.FILLER.item)
                    }
                }
            }
}
