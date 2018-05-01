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
import org.bukkit.inventory.ItemFlag

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
    val SILENT_ITEM: NBTItemExt
        get() = NBTItemExt(Material.TNT)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
                .setBoolean(NBTIdentifier.SILENT_STATE, false)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .setDisplayName(I18NStrings.SILENTITEM_OFF.get())


    /**
     * The item used to open the [net.groundmc.lobby.inventory.HidePlayerInventory]
     */
    val HIDE_PLAYERS_ITEM: NBTItemExt
        get() = NBTItemExt(Material.BLAZE_ROD)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                .setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
                .addEnchantment(Enchantment.LUCK)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .setDisplayName(I18NStrings.VISIBILITY_ALL.get())


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
    val FRIENDS_ITEM: NBTItemExt
        get() = NBTItemExt(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal)
                .setBoolean(NBTIdentifier.PREFIX, true)
                .setInteger(NBTIdentifier.TYPE, GMCType.FRIENDS.ordinal)
                .addItemFlags(ItemFlag.HIDE_ENCHANTS)
                .setDisplayName(I18NStrings.FRIENDSITEM_NAME.get())

}
