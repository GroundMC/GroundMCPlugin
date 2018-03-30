package gtlp.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import gtlp.groundmc.lobby.Relationship
import gtlp.groundmc.lobby.database.table.Relationships
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.I18NStrings
import gtlp.groundmc.lobby.util.I18nUtils
import gtlp.groundmc.lobby.util.NBTItemExt
import gtlp.groundmc.lobby.util.OnlineOfflinePlayerComparator
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
                fillFriendInventory(this, player)
            }

    fun friendDetails(player: Player, item: NBTItemExt): Inventory? {
        val relationship = item.getObject(NBTIdentifier.RELATIONSHIP,
                Relationship::class) ?: return null
        return Bukkit.createInventory(player, 2 * 9, relationship.user2.name)
                .apply {
                    // Skull
                    val friendOnline = CloudAPI.getInstance().getOnlinePlayer(relationship.user2.uniqueId) != null
                    setItem(4, getFriendSkull(relationship, player, friendOnline))

                    // Teleport if online
                    setItem(11,
                            (if (friendOnline) NBTItemExt(Material.EYE_OF_ENDER)
                            else NBTItemExt(Material.ENDER_PEARL))
                                    .apply {
                                        setBoolean(NBTIdentifier.PREFIX, true)
                                        setObject(NBTIdentifier.RELATIONSHIP, relationship)
                                        setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)

                                        displayName = I18NStrings.FRIENDS_JUMP.format(player,
                                                (if (friendOnline) ChatColor.GREEN.toString() + relationship.user2.name
                                                else ChatColor.RED.toString() + relationship.user2.name))
                                    }.item)

                    // Delete item
                    setItem(15, NBTItemExt(Material.BARRIER).apply {
                        setBoolean(NBTIdentifier.PREFIX, true)
                        setObject(NBTIdentifier.RELATIONSHIP, relationship)
                        setInteger(NBTIdentifier.TYPE, GMCType.REMOVE_FRIEND.ordinal)

                        displayName = I18NStrings.RELATIONSHIP_REMOVE.get(player)
                    }.item)
                }
    }

    private fun getFriendSkull(relationship: Relationship, player: Player, friendOnline: Boolean): ItemStack {
        return NBTItemExt(ItemStack(Material.SKULL_ITEM, 1,
                SkullType.PLAYER.ordinal.toShort())).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setObject(NBTIdentifier.RELATIONSHIP, relationship)
            val newMeta = meta as SkullMeta
            newMeta.owningPlayer = relationship.user2.offlinePlayer
            meta = newMeta
            displayName = relationship.user2.name
            val newLore = lore
            newLore += if (friendOnline) "${ChatColor.GREEN}Online" else "${ChatColor.RED}Offline"
            newLore += I18NStrings.RELATIONSHIP_SINCE.format(player.locale,
                    relationship.since.toString(DateTimeFormat.mediumDate()
                            .withLocale(I18nUtils.getLocaleFromCommandSender(player))))
                    ?: ""
            lore = newLore
        }.item
    }

    private fun fillFriendInventory(inventory: Inventory, player: Player) {
        val relationships = Relationships.getRelationships(player)
                .sortedWith(OnlineOfflinePlayerComparator())
        val page = if (NBTIdentifier.itemHasPrefix(inventory.getItem(this.INFO_ITEM_INDEX))) {
            val infoItem = NBTItemExt(inventory.getItem(this.INFO_ITEM_INDEX))
            if (infoItem.hasKey(NBTIdentifier.PAGE)) {
                (infoItem.getInteger(NBTIdentifier.PAGE) ?: 0)
            } else 0
        } else 0

        if (relationships.isNotEmpty()) {
            relationships.chunked(PAGE_SIZE)[page].forEach {
                inventory.addItem(this.getFriendSkull(it, player, CloudAPI.getInstance().getOnlinePlayer(it.user2.uniqueId) != null))
            }
        }

        inventory.setItem(this.INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS).apply {
            this.setBoolean(NBTIdentifier.PREFIX, true)
            this.setInteger(NBTIdentifier.PAGE, page + 1)
            val newLore = this.lore
            newLore += "Online: ${Relationships.getOnlineFriends(player).size}"
            newLore += I18NStrings.FRIENDS_PAGE.format(player, page + 1,
                    (relationships.size / this@FriendsOverviewInventory.PAGE_SIZE) + 1)
                    ?: ""
            this.lore = newLore
        }.item)
    }
}
