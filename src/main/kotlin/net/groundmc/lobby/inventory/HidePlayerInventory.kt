package net.groundmc.lobby.inventory

import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.enums.VisibilityStates
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.objects.Items
import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.DyeColor
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.material.Dye

/**
 * Inventory with clickable items to hide other players
 */
object HidePlayerInventory {

    /**
     * Title of the inventory ("Hide")
     */
    const val TITLE = "Hide"

    private const val size = 9

    private val fillContents = Array<ItemStack>(size) { Items.FILLER.item }

    /**
     * Creates an inventory for a player that is used to select the visibility
     * state of other players.
     *
     * @param player the player to create the inventory for
     * @return the created inventory
     */
    fun create(player: Player): Inventory =
            Bukkit.createInventory(player, size, TITLE).apply {
                val hideState = Users[player][Users.hiddenStatus]

                contents = fillContents

                setItem(0, NBTItemExt(Dye(DyeColor.LIME).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
                    if (hideState == VisibilityStates.ALL) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18NStrings.VISIBILITY_ALL.get(player)
                }.item)

                setItem(4, NBTItemExt(Dye(DyeColor.PURPLE).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.FRIENDS.ordinal)
                    if (hideState == VisibilityStates.FRIENDS) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18NStrings.VISIBILITY_FRIENDS.get(player)
                }.item)

                setItem(8, NBTItemExt(Dye(DyeColor.GRAY).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.NONE.ordinal)
                    if (hideState == VisibilityStates.NONE) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18NStrings.VISIBILITY_NONE.get(player)
                }.item)
            }
}
