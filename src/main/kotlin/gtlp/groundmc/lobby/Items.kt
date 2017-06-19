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
        get() {
            val nbtItem = NBTItemExt(ItemStack(Material.COMPASS))
            nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
            nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            nbtItem.displayName = ChatColor.RED.toString() + "Lobby"
            return nbtItem
        }

    /**
     * The item used to silence the chat.
     */
    val SILENT_ITEM: NBTItemExt
        get() {
            val nbtItem = NBTItemExt(ItemStack(Material.TNT))
            nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
            nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.SILENT.ordinal)
            nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
            nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            nbtItem.displayName = I18n.getString("silentitem.off")
            return nbtItem
        }

    /**
     * The item used to open the [HidePlayerInventory]
     */
    val HIDE_PLAYERS_ITEM: NBTItemExt
        get() {
            val nbtItem = NBTItemExt(ItemStack(Material.BLAZE_ROD))
            nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
            nbtItem.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            nbtItem.setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
            nbtItem.addEnchantment(Enchantment.LUCK)
            nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            nbtItem.displayName = I18n.getString("visibility.all")
            return nbtItem
        }

    /**
     * An item to fill empty inventory slots.
     */
    @Suppress("DEPRECATION")
    val FILLER: NBTItemExt
        get() = NBTItemExt(ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.SILVER.woolData.toShort())).apply {
            displayName = " "
        }
}
