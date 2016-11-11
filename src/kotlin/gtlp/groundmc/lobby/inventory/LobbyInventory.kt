package gtlp.groundmc.lobby.inventory

import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

/**
 * Created by Marv1 on 10.06.2016.
 */
internal class LobbyInventory {

    companion object {
        fun cloneInventory(inventory: Inventory, holder: InventoryHolder): Inventory {
            val clone = Bukkit.createInventory(holder, inventory.size, inventory.title)
            clone.contents = inventory.contents
            return clone
        }
    }
}
