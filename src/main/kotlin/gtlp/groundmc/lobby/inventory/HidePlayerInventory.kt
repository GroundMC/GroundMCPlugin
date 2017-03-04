package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.enum.GMCType
import gtlp.groundmc.lobby.enum.NBTIdentifier
import gtlp.groundmc.lobby.enum.VisibilityStates
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.DyeColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.material.Dye

/**
 * Created by Marvin on 11.11.2016.
 */
object HidePlayerInventory {
    fun create(player: Player): Inventory {
        val inventory = Bukkit.createInventory(player, 9)

        (0..inventory.size - 1).forEach { i ->
            inventory.setItem(i, Items.FILLER.item)
        }

        val limeDye = NBTItemExt(ItemStack(Dye(DyeColor.LIME).toItemStack())).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.all", player.spigot().locale)
        }

        inventory.setItem(0, limeDye.item)

        val purpleDye = NBTItemExt(ItemStack(Dye(DyeColor.PURPLE).toItemStack())).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.FRIENDS.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.friends", player.spigot().locale)
        }

        inventory.setItem(4, purpleDye.item)

        val grayDye = NBTItemExt(ItemStack(Dye(DyeColor.GRAY).toItemStack())).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.NONE.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.none", player.spigot().locale)
        }

        inventory.setItem(8, grayDye.item)


        return inventory
    }
}