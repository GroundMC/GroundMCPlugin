package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.inventory.HidePlayerInventory
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.ChatColor
import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.SkullType
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * Object holding all items with special properties that are used in
 * this plugin.
 */
object Items {

    /**
     * The item that is used to serve as the fast travel item.
     */
    val COMPASS_ITEM: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.COMPASS)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            displayName = "${ChatColor.RED}Lobby"
        }

    /**
     * The item used to silence the chat.
     */
    val SILENT_ITEM: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.TNT)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
            setBoolean(NBTIdentifier.SILENT_STATE, false)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            displayName = I18n.getString("silentitem.off")
        }

    /**
     * The item used to open the [HidePlayerInventory]
     */
    val HIDE_PLAYERS_ITEM: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.BLAZE_ROD)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
            addEnchantment(Enchantment.LUCK)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            displayName = I18n.getString("visibility.all")
        }

    /**
     * The item used
     */
    val LOBBY_CHOOSE_ITEM: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.NETHER_STAR)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.CHOOSE_LOBBY.ordinal)
            displayName = "LobbySwitcher"
        }

    /**
     * An item to fill empty inventory slots.
     */
    @Suppress("DEPRECATION")
    val FILLER: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.SILVER.woolData.toShort())).apply {
            displayName = " "
        }

    /**
     * An item used to open the [gtlp.groundmc.lobby.inventory.FriendsOverviewInventory]
     */
    val FRIENDS_ITEM: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.SKULL_ITEM, 1, SkullType.PLAYER.ordinal.toShort())).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.FRIENDS.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            displayName = I18n.getString("friendsitem.name")
        }
}
