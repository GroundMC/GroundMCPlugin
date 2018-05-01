package net.groundmc.lobby.inventory

import de.dytanic.cloudnet.api.CloudAPI
import de.dytanic.cloudnet.lib.player.CloudPlayer
import net.groundmc.lobby.database.table.FriendRequests
import net.groundmc.lobby.database.table.Relationships
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.i18n.I18nUtils
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.joda.time.format.DateTimeFormat

object FriendRequestsInventory {

    private const val INVENTORY_SIZE = 4 * 9
    private const val PAGE_SIZE = INVENTORY_SIZE - 9
    private const val INFO_ITEM_INDEX = PAGE_SIZE + 4

    private const val REQUEST_INVENTORY_SIZE = 2 * 9

    internal const val TITLE = "Friend requests"

    fun create(player: Player): Inventory = Bukkit.createInventory(player, INVENTORY_SIZE, TITLE).apply {
        fillRequestInventory(this, player)
    }

    private fun fillRequestInventory(inventory: Inventory, player: Player) {
        LOGGER.entering(FriendRequestsInventory::class, "fillRequestInventory", inventory, player)
        val friendRequests = FriendRequests.getRequestsFor(player.uniqueId).sortedWith(
                Comparator { o1, o2 ->
                    o1.requestTime.compareTo(o2.requestTime)
                }
        )
        val page = if (NBTIdentifier.itemHasPrefix(inventory.getItem(INFO_ITEM_INDEX))) {
            val infoItem = NBTItemExt(inventory.getItem(INFO_ITEM_INDEX))
            if (infoItem.hasKey(NBTIdentifier.PAGE)) {
                (infoItem.getInteger(NBTIdentifier.PAGE) ?: 0)
            } else 0
        } else 0

        if (friendRequests.isNotEmpty()) {
            friendRequests.chunked(PAGE_SIZE)[page].forEach {
                inventory.addItem(getRequestSkull(it, player, CloudAPI.getInstance().getOnlinePlayer(it.requester)))
            }
        }

        val pages = (friendRequests.size / PAGE_SIZE)
        inventory.setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.PAGE, page + 1)
                .setDisplayName(" ")
                .setLore(mutableListOf("${I18NStrings.ONLINE.get(player)}: ${Relationships.getOnlineFriends(player).size}",
                        I18NStrings.FRIENDS_PAGE.format(player, page + 1, pages + 1)))
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
        LOGGER.exiting(FriendRequestsInventory::class, "fillRequestInventory")
    }

    private fun getRequestSkull(request: FriendRequests.FriendRequest, player: Player, requester: CloudPlayer?) =
            NBTItemExt(ItemStack(Material.SKULL_ITEM, 1,
                    SkullType.PLAYER.ordinal.toShort()))
                    .setBoolean(NBTIdentifier.PREFIX, true)
                    .setDisplayName(Users[request.requester][Users.lastName])
                    .setObject(NBTIdentifier.RELATIONSHIP, request)
                    .setLore({
                        it += if (requester != null) {
                            I18NStrings.ONLINE.get(player)
                        } else {
                            I18NStrings.OFFLINE.get(player)
                        }
                        it += request.requestTime.toString(DateTimeFormat.mediumDate()
                                .withLocale(I18nUtils.getLocaleFromCommandSender(player)))
                    }).setMeta {
                        val newMeta = it as SkullMeta
                        val profile = Bukkit.createProfile(request.requester, Users[request.requester][Users.lastName])
                        profile.complete(true)
                        newMeta.playerProfile = profile
                    }.item

    fun openPage(player: Player, item: ItemStack): Inventory = Bukkit.createInventory(player, INVENTORY_SIZE, TITLE).apply {
        setItem(INFO_ITEM_INDEX, NBTItemExt(Material.COMPASS)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.PAGE, NBTItemExt(item).getInteger(NBTIdentifier.PAGE)!!)
                .item)
        fillRequestInventory(this, player)
    }

    fun requestDetails(player: Player, item: NBTItemExt): Inventory? {
        LOGGER.entering(FriendRequestsInventory::class, "requestDetails", player, item)
        val request = item.getObject(NBTIdentifier.RELATIONSHIP,
                FriendRequests.FriendRequest::class) ?: return null
        return Bukkit.createInventory(player, REQUEST_INVENTORY_SIZE, Users[request.requester][Users.lastName])
                .apply {
                    // Skull
                    val friendOnline = CloudAPI.getInstance().getOnlinePlayer(request.requester)
                    setItem(4, getRequestSkull(request, player, friendOnline))

                    // Accept
                    setItem(11, NBTItemExt(ItemStack(Material.WOOL, 1, DyeColor.LIME.ordinal.toShort()))
                            .setBoolean(NBTIdentifier.PREFIX, true)
                            .setObject(NBTIdentifier.RELATIONSHIP, request)
                            .setType(GMCType.FRIEND_REQUEST_ACCEPT)
                            .setDisplayName(I18NStrings.FRIENDREQUEST_ACCEPT.get(player))
                            .item)

                    // Deny
                    setItem(15, NBTItemExt(ItemStack(Material.WOOL, 1, DyeColor.RED.ordinal.toShort()))
                            .setBoolean(NBTIdentifier.PREFIX, true)
                            .setType(GMCType.FRIEND_REQUEST_DENY)
                            .setObject(NBTIdentifier.RELATIONSHIP, request)
                            .setDisplayName(I18NStrings.FRIENDREQUEST_DENY.get(player))
                            .item)
                }
    }
}
