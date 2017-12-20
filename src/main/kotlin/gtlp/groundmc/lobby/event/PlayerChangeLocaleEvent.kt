package gtlp.groundmc.lobby.event

import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * An event that is called when a player changes locale.
 */
class PlayerChangeLocaleEvent(val player: Player) : Event(true) {

    /**
     * Gets the list of handlers
     *
     * @return the list of handlers
     */
    override fun getHandlers(): HandlerList = handlersList

    companion object {
        /**
         * A list of handlers.
         * Used like any other event.
         */
        val handlersList = HandlerList()

        /**
         * Static method to return the [handlersList] to the server.
         *
         * @return the list of handlers
         */
        @JvmStatic
        fun getHandlerList(): HandlerList = handlersList
    }
}
