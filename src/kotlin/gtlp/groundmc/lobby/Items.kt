package gtlp.groundmc.lobby

import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.VisibilityStates
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

/**
 * Created by Marv1 on 14.11.2016.
 */
object Items {
    val COMPASS_ITEM: NBTItemExt
        get() {
            val nbtItem = NBTItemExt(ItemStack(Material.COMPASS))
            nbtItem.setBoolean(NBTIdentifier.PREFIX, true)
            nbtItem.addItemFlags(ItemFlag.HIDE_ENCHANTS)
            nbtItem.displayName = ChatColor.RED.toString() + "Lobby"
            return nbtItem
        }
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
}