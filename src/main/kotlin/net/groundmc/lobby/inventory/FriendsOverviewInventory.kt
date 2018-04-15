package net.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.bridge.CloudServer
import de.dytanic.cloudnet.lib.player.CloudPlayer
import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.i18n.I18nUtils
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.objects.Relationship
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.OnlineOfflinePlayerComparator
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.joda.time.format.DateTimeFormat
import java.util.*

/**
 * Layout:
 *
 * F F F F F F F F F
 * F F F F F F F F F
 * F F F F F F F F F
 * R x x < H > x x x
 *
 * F = Friend or placeholder
 * x = placeholder
 * H = info item
 * R = friend request item
 * < = previous page (where applicable)
 * > = next page (where applicable)
 */
object FriendsOverviewInventory {

    private const val INVENTORY_SIZE = 4 * 9
    private const val PAGE_SIZE = INVENTORY_SIZE - 9
    private const val INFO_ITEM_INDEX = PAGE_SIZE + 4
    private const val REQUEST_ITEM_INDEX = PAGE_SIZE // Zero based

    internal const val TITLE = "Friends"


    fun create(player: Player): Inventory = Bukkit.createInventory(player, INVENTORY_SIZE, TITLE)
            .apply {
                fillFriendInventory(this, player)
            }

    fun friendDetails(player: Player, item: NBTItemExt): Inventory? {
        val relationship = item.getObject(NBTIdentifier.RELATIONSHIP,
                Relationship::class) ?: return null
        return Bukkit.createInventory(player, 2 * 9, relationship.user2.name)
                .apply {
                    // Skull
                    val friendOnline = CloudAPI.getInstance().getOnlinePlayer(relationship.user2.uniqueId)
                    setItem(4, getFriendSkull(relationship, player, friendOnline))

                    // Teleport if online
                    setItem(11,
                            (if (friendOnline != null) NBTItemExt(Material.EYE_OF_ENDER)
                            else NBTItemExt(Material.ENDER_PEARL))
                                    .setBoolean(NBTIdentifier.PREFIX, true)
                                    .setObject(NBTIdentifier.RELATIONSHIP, relationship)
                                    .setInteger(NBTIdentifier.TYPE, GMCType.TP.ordinal)
                                    .setDisplayName(I18NStrings.FRIENDS_JUMP.format(player,
                                            (if (friendOnline != null) ChatColor.GREEN.toString() + relationship.user2.name
                                            else ChatColor.RED.toString() + relationship.user2.name)))
                                    .item)

                    // Delete item
                    setItem(15, NBTItemExt(Material.BARRIER)
                            .setBoolean(NBTIdentifier.PREFIX, true)
                            .setObject(NBTIdentifier.RELATIONSHIP, relationship)
                            .setInteger(NBTIdentifier.TYPE, GMCType.REMOVE_FRIEND.ordinal)
                            .setDisplayName(I18NStrings.RELATIONSHIP_REMOVE.get(player))
                            .item)
                }
    }

    private fun getFriendSkull(relationship: Relationship, player: Player, friendOnline: CloudPlayer?) =
            NBTItemExt(ItemStack(Material.SKULL_ITEM, 1,
                    SkullType.PLAYER.ordinal.toShort()))
                    .setBoolean(NBTIdentifier.PREFIX, true)
                    .setObject(NBTIdentifier.RELATIONSHIP, relationship)
                    .setDisplayName(relationship.user2.name)
                    .setLore({
                        if (friendOnline != null) {
                            it += I18NStrings.ONLINE.get(player)
                            it += if (CloudServer.getInstance().groupData.name == CloudAPI.getInstance().getServerGroup(friendOnline.server).name) {
                                "${ChatColor.GREEN}${friendOnline.server}"
                            } else {
                                "${ChatColor.RED}${friendOnline.server}"
                            }
                        } else {
                            it += I18NStrings.OFFLINE.get(player)
                        }
                        it += I18NStrings.RELATIONSHIP_SINCE.format(player.locale,
                                relationship.since.toString(DateTimeFormat.mediumDate()
                                        .withLocale(I18nUtils.getLocaleFromCommandSender(player))))
                    }).setMeta {
                        val newMeta = it as SkullMeta
                        val profile = Bukkit.createProfile(relationship.user2.uniqueId, relationship.user2.name)
                        profile.complete(true)
                        newMeta.playerProfile = profile
                    }.item

    private fun fillFriendInventory(inventory: Inventory, player: Player) {
        LOGGER.entering(FriendsOverviewInventory::class, "fillFriendInventory", inventory, player)
        val onlinePlayers = CloudAPI.getInstance().onlinePlayers.associate { it.uniqueId to it }
        val relationships = Relationships.getRelationships(player)
        Collections.sort(
                relationships,
                OnlineOfflinePlayerComparator(onlinePlayers))
        val page = if (NBTIdentifier.itemHasPrefix(inventory.getItem(INFO_ITEM_INDEX))) {
            val infoItem = NBTItemExt(inventory.getItem(INFO_ITEM_INDEX))
            if (infoItem.hasKey(NBTIdentifier.PAGE)) {
                (infoItem.getInteger(NBTIdentifier.PAGE) ?: 0)
            } else 0
        } else 0

        if (relationships.isNotEmpty()) {
            relationships.chunked(PAGE_SIZE)[page].forEach {
                inventory.addItem(getFriendSkull(it, player, CloudAPI.getInstance().getOnlinePlayer(it.user2.uniqueId)))
            }
        }

        val pages = (relationships.size / PAGE_SIZE)
        inventory.setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.PAGE, page + 1)
                .setDisplayName(" ")
                .setLore(mutableListOf("${I18NStrings.ONLINE.get(player)}: ${Relationships.getOnlineFriends(player).size}",
                        I18NStrings.FRIENDS_PAGE.format(player, page + 1, pages + 1)))
                .item)

        inventory.setItem(REQUEST_ITEM_INDEX, NBTItemExt(Material.PAPER)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setType(GMCType.FRIEND_REQUESTS)
                .setDisplayName(I18NStrings.FRIENDREQUEST_TITLE.get(player))
                .item)

        // Next page
        if (page < pages) {
            inventory.setItem(INFO_ITEM_INDEX + 1, NBTItemExt(Material.ARROW)
                    .setBoolean(NBTIdentifier.PREFIX, true)
                    .setInteger(NBTIdentifier.PAGE, page + 1)
                    .setDisplayName(I18NStrings.FRIENDS_NEXT_PAGE.get(player))
                    .item)
        }

        // Previous page
        if (page > 0) {
            inventory.setItem(INFO_ITEM_INDEX - 1, NBTItemExt(Material.ARROW)
                    .setBoolean(NBTIdentifier.PREFIX, true)
                    .setInteger(NBTIdentifier.PAGE, page - 1)
                    .setDisplayName(I18NStrings.FRIENDS_PREVIOUS_PAGE.get(player))
                    .item)
        }
        LOGGER.exiting(FriendsOverviewInventory::class, "fillFriendInventory")
    }

    fun openPage(player: Player, item: ItemStack): Inventory = Bukkit.createInventory(player, INVENTORY_SIZE, TITLE).apply {
        setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.PAGE, NBTItemExt(item).getInteger(NBTIdentifier.PAGE)!!)
                .item)
        fillFriendInventory(this, player)
    }
}
