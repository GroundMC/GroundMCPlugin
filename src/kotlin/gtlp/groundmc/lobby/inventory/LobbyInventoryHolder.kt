package gtlp.groundmc.lobby.inventory

import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

/**
 * Created by Marvin on 11.11.2016.
 */
class LobbyInventoryHolder private constructor(inventory1: Inventory, inventory2: Inventory) {
    var lobbyInventory = inventory1
    var hidePlayerInventory = inventory2


    companion object {
        fun forPlayer(player: Player): LobbyInventoryHolder {
            return LobbyInventoryHolder(LobbyInventory.create(player), HidePlayerInventory.create(player))
        }
    }
}