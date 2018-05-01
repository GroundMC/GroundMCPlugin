package net.groundmc.lobby.inventory

import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.objects.Items
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.util.LOGGER
import net.groundmc.lobby.util.entering
import net.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

/**
 * Inventory for navigating the lobby
 */
internal object LobbyInventory {

    /**
     * Title of the inventory ("Lobby")
     */
    const val TITLE = "Lobby"

    /**
     * The template to clone the contents off of.
     */
    val TEMPLATE_INVENTORY: Inventory = Bukkit.createInventory(null, 6 * 9, "Template")

    /**
     * Variable to hold the time the [TEMPLATE_INVENTORY] was updated last.
     */
    private var lastPull = 0

    /**
     * Constant to hold the time in milliseconds after which the
     * [TEMPLATE_INVENTORY] is updated.
     */
    private const val updateTime = 2000

    /**
     * Creates an inventory for teleporting around.
     * Clones the [TEMPLATE_INVENTORY]
     *
     * @param inventoryHolder the player to create the inventory for
     * @return the cloned inventory, for use by [inventoryHolder]
     */
    fun create(inventoryHolder: InventoryHolder): Inventory {
        pullTemplate()
        val clone = Bukkit.createInventory(inventoryHolder, TEMPLATE_INVENTORY.size, TITLE)
        clone.contents = TEMPLATE_INVENTORY.contents
        return clone
    }

    /**
     * Pulls the [TEMPLATE_INVENTORY] from the config.
     * Returns if less that [updateTime] milliseconds have passed since the
     * last pull.
     */
    private fun pullTemplate() {
        LOGGER.entering(LobbyInventory::class, "pullTemplate")
        if (System.currentTimeMillis() - lastPull < updateTime) {
            return
        }
        @Suppress("unchecked_cast")
        TEMPLATE_INVENTORY.contents = (Meta[Config.INVENTORY_CONTENT] as List<ItemStack?>).toTypedArray()
        (0 until TEMPLATE_INVENTORY.contents.size).forEach {
            val item = TEMPLATE_INVENTORY.getItem(it)
            if (item == null) {
                TEMPLATE_INVENTORY.setItem(it, Items.FILLER.item)
            } else if (!NBTIdentifier.itemHasPrefix(item)) {
                TEMPLATE_INVENTORY.setItem(it, NBTItemExt(item).setBoolean(NBTIdentifier.PREFIX, true).item)
            }
        }
        LOGGER.exiting(LobbyInventory::class, "pullTemplate")
    }
}
