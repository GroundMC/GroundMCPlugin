package gtlp.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import gtlp.groundmc.lobby.Friend
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

/**
 * Layout:
 *
 * F F F F F F F F F
 * F F F F F F F F F
 * F F F F F F F F F
 * x x x < H > x x x
 *
 * F = Friend or placeholder
 * x = placeholder
 * H = info item
 * < = previous page (where applicable)
 * > = next page (where applicable)
 */
object FriendsOverviewInventory {

    private const val PAGE_SIZE = 3 * 9
    private const val INFO_ITEM_INDEX = PAGE_SIZE + 4

    internal const val TITLE = "Friends"

    fun create(player: Player): Inventory = Bukkit.createInventory(player, 4 * 9, TITLE)
            .apply {
                fillFriendInventory(player)
            }

    fun friendInfo(player: Player, friend: Friend) = Bukkit.createInventory(player, 2 * 9, friend.name)
            .apply {

            }

    private fun Inventory.fillFriendInventory(player: Player) {
        val relationships = Relationships.getRelationships(player)
        val page = if (NBTIdentifier.itemHasPrefix(getItem(INFO_ITEM_INDEX))) {
            val infoItem = NBTItemExt(getItem(INFO_ITEM_INDEX))
            if (infoItem.hasKey(NBTIdentifier.PAGE)) {
                (infoItem.getInteger(NBTIdentifier.PAGE) ?: 0)
            } else 0
        } else 0

        relationships.chunked(PAGE_SIZE)[page].forEach {
            addItem(NBTItemExt(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort())).apply {
                setBoolean(NBTIdentifier.PREFIX, true)
                setObject(NBTIdentifier.FRIEND, it.user2)
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
                lore = newLore
            }.item)
        }

        setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.PAGE, page + 1)
            val newLore = lore
            newLore += "Online: ${Relationships.getOnlineFriends(player).size}"
            newLore += I18NStrings.FRIENDS_PAGE.format(player, page + 1,
                    (relationships.size / PAGE_SIZE) + 1)
                    ?: ""
            lore = newLore
        }.item)

        contents.forEachIndexed { index, itemStack ->
            if (itemStack == null) {
                setItem(index, Items.FILLER.item)
            }
        }
    }
}
