package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.DyeColor
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.material.Dye

/**
 * Created by Marvin on 11.11.2016.
 */
object HidePlayerInventory {
    fun create(player: Player): Inventory {
        val inventory = Bukkit.createInventory(player, 9)
        val limeDye = NBTItemExt(ItemStack(Dye(DyeColor.LIME).toItemStack()))
        limeDye.setBoolean(NBTIdentifier.PREFIX, true)
        limeDye.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
        limeDye.setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
        limeDye.item.amount = 1
        limeDye.setDisplayName(I18n.getString("visibility.all", player.spigot().locale))
        limeDye.item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1)

        inventory.setItem(0, limeDye.item)

        val purpleDye = NBTItemExt(ItemStack(Dye(DyeColor.PURPLE).toItemStack()))
        purpleDye.setBoolean(NBTIdentifier.PREFIX, true)
        limeDye.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
        purpleDye.setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.FRIENDS.ordinal)
        purpleDye.item.amount = 1
        purpleDye.setDisplayName(I18n.getString("visibility.friends", player.spigot().locale))

        inventory.setItem(4, purpleDye.item)

        val grayDye = NBTItemExt(ItemStack(Dye(DyeColor.GRAY).toItemStack()))
        grayDye.setBoolean(NBTIdentifier.PREFIX, true)
        limeDye.setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
        grayDye.setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.NONE.ordinal)
        grayDye.item.amount = 1
        grayDye.setDisplayName(I18n.getString("visibility.none", player.spigot().locale))

        inventory.setItem(8, grayDye.item)
        return inventory
    }
}