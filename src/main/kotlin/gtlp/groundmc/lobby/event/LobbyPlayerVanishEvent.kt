package gtlp.groundmc.lobby.event

import org.bukkit.entity.Player
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

/**
 * Event that is called whenever the vanishing state of a player changes.
 */
class LobbyPlayerVanishEvent(
        /**
         * The player that this event is called for
         */
        player: Player,
        /**
         * The new vanishing state of the player
         */
        val vanished: Boolean) : PlayerEvent(player) {

    override fun getHandlers(): HandlerList {
        return handlers
    }

    /**
     * The handlers that handle this event
     */
    private val handlers = HandlerList()
}
