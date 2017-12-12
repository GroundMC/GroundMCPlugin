package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.Items
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
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
     * Creates an inventory for teleporting around.
     * Clones the [TEMPLATE_INVENTORY]
     *
     * @param inventoryHolder the player to create the inventory for
     * @return the cloned inventory, for use by [inventoryHolder]
     */
    fun create(inventoryHolder: InventoryHolder): Inventory {
        LobbyMain.logger.entering(LobbyInventory::class, "create")
        pullTemplate()
        val clone = Bukkit.createInventory(inventoryHolder, TEMPLATE_INVENTORY.size, TITLE)
        clone.contents = TEMPLATE_INVENTORY.contents
        LobbyMain.logger.exiting(LobbyInventory::class, "create")
        return clone
    }

    /**
     * Pulls the [TEMPLATE_INVENTORY] from the config.
     */
    private fun pullTemplate() {
        @Suppress("unchecked_cast")
        TEMPLATE_INVENTORY.contents = (Meta[Config.INVENTORY_CONTENT] as List<ItemStack?>).toTypedArray()
        (0 until TEMPLATE_INVENTORY.contents.size).forEach {
            if (TEMPLATE_INVENTORY.getItem(it) == null) {
                TEMPLATE_INVENTORY.setItem(it, Items.FILLER.item)
            }
        }
    }
}
