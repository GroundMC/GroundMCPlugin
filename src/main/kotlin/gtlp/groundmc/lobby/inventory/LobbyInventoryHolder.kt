package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

/**
 * Holds the two inventories used by our plugin for a player.
 */
class LobbyInventoryHolder private constructor(inventory1: Inventory, inventory2: Inventory) {
    var lobbyInventory = inventory1
    var hidePlayerInventory = inventory2


    companion object {
        fun forPlayer(player: Player): LobbyInventoryHolder {
            LobbyMain.logger.entering(Companion::class, "forPlayer")
            return LobbyInventoryHolder(LobbyInventory.create(player), HidePlayerInventory.create(player))
        }

        fun recreateInventories() {
            for ((player, inventories) in LobbyMain.lobbyInventoryMap) {
                inventories.lobbyInventory = LobbyInventory.create(player)
            }
        }
    }
}