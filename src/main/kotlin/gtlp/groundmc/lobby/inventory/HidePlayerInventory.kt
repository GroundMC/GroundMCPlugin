package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.enums.VisibilityStates
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.DyeColor
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemFlag
import org.bukkit.material.Dye

/**
 * Inventory with clickable items to hide other players
 */
object HidePlayerInventory {

    /**
     * Creates an inventory for a player that is used to select the visibility
     * state of other players.
     *
     * @param player the player to create the inventory for
     * @return the created inventory
     */
    fun create(player: Player): Inventory {
        LobbyMain.logger.entering(HidePlayerInventory::class, "create")
        val inventory = Bukkit.createInventory(player, 9)

        (0..inventory.size - 1).forEach { i ->
            inventory.setItem(i, Items.FILLER.item)
        }

        val limeDye = NBTItemExt(Dye(DyeColor.LIME).toItemStack(1)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.ALL.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.all", player.spigot().locale)
        }

        inventory.setItem(0, limeDye.item)

        val purpleDye = NBTItemExt(Dye(DyeColor.PURPLE).toItemStack(1)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.FRIENDS.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.friends", player.spigot().locale)
        }

        inventory.setItem(4, purpleDye.item)

        val grayDye = NBTItemExt(Dye(DyeColor.GRAY).toItemStack(1)).apply {
            setBoolean(NBTIdentifier.PREFIX, true)
            setInteger(NBTIdentifier.TYPE, GMCType.HIDE_PLAYERS.ordinal)
            setInteger(NBTIdentifier.HIDE_STATE, VisibilityStates.NONE.ordinal)
            addItemFlags(ItemFlag.HIDE_ENCHANTS)
            item.amount = 1
            displayName = I18n.getString("visibility.none", player.spigot().locale)
        }

        inventory.setItem(8, grayDye.item)

        LobbyMain.logger.exiting(HidePlayerInventory::class, "create")
        return inventory
    }
}
