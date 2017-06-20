package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

/**
 * Inventory for navigating the lobby
 */
internal object LobbyInventory {

    const val TITLE = "Lobby"

    /**
     * The template to clone the contents off of.
     */
    val TEMPLATE_INVENTORY: Inventory = Bukkit.createInventory(null, 6 * 9, TITLE)

    /**
     * Creates an inventory for teleporting around.
     * Clones the [TEMPLATE_INVENTORY]
     *
     * @param inventoryHolder the player to create the inventory for
     * @return the cloned inventory, for use by [inventoryHolder]
     */
    fun create(inventoryHolder: InventoryHolder): Inventory {
        LobbyMain.logger.entering(LobbyInventory::class, "create")
        val clone = Bukkit.createInventory(inventoryHolder, TEMPLATE_INVENTORY.size, TITLE)
        clone.contents = TEMPLATE_INVENTORY.contents
        LobbyMain.logger.exiting(LobbyInventory::class, "create")
        return clone
    }
}
