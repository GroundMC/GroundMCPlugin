package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.database.table.Users
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
import org.bukkit.inventory.ItemFlag
import org.bukkit.material.Dye

/**
 * Inventory with clickable items to hide other players
 */
object HidePlayerInventory {

    /**
     * Title of the inventory ("Hide")
     */
    const val TITLE = "Hide"

    /**
     * Creates an inventory for a player that is used to select the visibility
     * state of other players.
     *
     * @param player the player to create the inventory for
     * @return the created inventory
     */
    fun create(player: Player): Inventory =
            Bukkit.createInventory(player, 9, TITLE).apply {
                val hideState = Users[player][Users.hiddenStatus]

                contents.fill(Items.FILLER.item)
                setItem(0, NBTItemExt(Dye(DyeColor.LIME).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
                    if (hideState == VisibilityStates.ALL) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18n.getString("visibility.all", player.locale)
                }.item)

                setItem(4, NBTItemExt(Dye(DyeColor.PURPLE).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.FRIENDS.ordinal)
                    if (hideState == VisibilityStates.FRIENDS) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18n.getString("visibility.friends", player.locale)
                }.item)

                setItem(8, NBTItemExt(Dye(DyeColor.GRAY).toItemStack(1)).apply {
                    setBoolean(NBTIdentifier.PREFIX, true)
                    setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
                    setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.NONE.ordinal)
                    if (hideState == VisibilityStates.NONE) addEnchantment(Enchantment.LUCK)
                    addItemFlags(ItemFlag.HIDE_ENCHANTS)
                    displayName = I18n.getString("visibility.none", player.locale)
                }.item)
            }
}
