package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import org.bukkit.entity.Player

/**
 * Holds the two inventories used by our plugin for a player.
 */
class LobbyInventoryHolder private constructor(player: Player) {
    var lobbyInventory = LobbyInventory.create(player)
    var hidePlayerInventory = HidePlayerInventory.create(player)
    var lastLocale = player.spigot().locale
    var originalContents = player.inventory.contents.clone()


    companion object {
        fun forPlayer(player: Player): LobbyInventoryHolder {
            LobbyMain.logger.entering(Companion::class, "forPlayer")
            return LobbyInventoryHolder(player)
        }

        fun recreateInventories() {
            for ((player, inventories) in LobbyMain.lobbyInventoryMap) {
                inventories.lobbyInventory = LobbyInventory.create(player)
            }
        }
    }
}