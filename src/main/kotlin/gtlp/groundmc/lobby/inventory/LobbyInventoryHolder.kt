package gtlp.groundmc.lobby.inventory

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import org.bukkit.entity.Player

/**
 * Holds the two inventories used by our plugin for a player.
 */
class LobbyInventoryHolder private constructor(player: Player) {

    /**
     * The contents of the player's inventory before entering the lobby.
     */
    var originalContents = player.inventory.contents.clone()


    companion object {

        /**
         * Creates a [LobbyInventoryHolder] for a player with all the inventories
         * in it.
         *
         * @param player the player to create the inventory for.
         * @return the [LobbyInventoryHolder] with all the inventories for the [player]
         */
        fun forPlayer(player: Player): LobbyInventoryHolder {
            LobbyMain.logger.entering(Companion::class, "forPlayer")
            return LobbyInventoryHolder(player)
        }
    }
}
