package net.groundmc.lobby.objects

import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.enums.VisibilityStates
import net.groundmc.lobby.i18n.I18NStrings
import org.bukkit.ChatColor
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.meta.SkullMeta

/**
 * Object holding all items with special properties that are used in
 * this plugin.
 */
object Items {

    /**
     * The item that is used to serve as the fast travel item.
     */
    val COMPASS_ITEM: NBTItemExt
        get() = NBTItemExt(Material.COMPASS)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .setDisplayName("${ChatColor.RED}Lobby")


    /**
     * The item used to silence the chat.
     */
    private val SILENT_ITEM: NBTItemExt
        get() = NBTItemExt(Material.TNT)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
                .setBoolean(NBTIdentifier.SILENT_STATE, false)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)

    fun getSilentItem(player: Player, silent: Boolean) = SILENT_ITEM
            .setBoolean(NBTIdentifier.SILENT_STATE, silent)
            .apply {
                displayName = when {
                    silent -> I18NStrings.SILENTITEM_ON.get(player)
                    else -> I18NStrings.SILENTITEM_OFF.get(player)
                }
                if (silent) {
                    addEnchantment(Enchantment.LUCK)
                }
            }


    /**
     * The item used to open the [net.groundmc.lobby.inventory.HidePlayerInventory]
     */
    private val HIDE_PLAYERS_ITEM: NBTItemExt
        get() = NBTItemExt(Material.BLAZE_ROD)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                .setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
                .addEnchantment(Enchantment.LUCK)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)

    fun getHidePlayersItem(player: Player, hideState: VisibilityStates) =
            HIDE_PLAYERS_ITEM.apply {
                displayName = when (hideState) {
                    VisibilityStates.ALL -> I18NStrings.VISIBILITY_ALL.get(player)
                    VisibilityStates.NONE -> I18NStrings.VISIBILITY_NONE.get(player)
                    VisibilityStates.FRIENDS -> I18NStrings.VISIBILITY_FRIENDS.get(player)
                }
            }

    /**
     * The item used
     */
    val LOBBY_CHOOSE_ITEM: NBTItemExt
        get() = NBTItemExt(Material.NETHER_STAR)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.CHOOSE_LOBBY.ordinal)
                .setDisplayName("LobbySwitcher")


    /**
     * An item to fill empty inventory slots.
     */
    @Suppress("DEPRECATION")
    val FILLER: NBTItemExt
        get() = NBTItemExt(Material.STAINED_GLASS_PANE, 1, DyeColor.SILVER.woolData)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setDisplayName(" ")


    /**
     * An item used to open the [net.groundmc.lobby.inventory.FriendsOverviewInventory]
     */
    private val FRIENDS_ITEM: NBTItemExt
        get() = NBTItemExt(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.FRIENDS.ordinal)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)

    fun getFriendsItem(player: Player) = FRIENDS_ITEM
            .setDisplayName(I18NStrings.FRIENDSITEM_NAME.get(player))
            .setMeta {
                (it as SkullMeta).owningPlayer = player
            }
}
