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

    val TEMPLATE_INVENTORY: Inventory = Bukkit.createInventory(null, 6 * 9, "Lobby")

    fun create(inventoryHolder: InventoryHolder): Inventory {
        LobbyMain.logger.entering(LobbyInventory::class, "create")
        val clone = Bukkit.createInventory(inventoryHolder, TEMPLATE_INVENTORY.size, TEMPLATE_INVENTORY.title)
        clone.contents = TEMPLATE_INVENTORY.contents
        LobbyMain.logger.exiting(LobbyInventory::class, "create")
        return clone
    }
}
