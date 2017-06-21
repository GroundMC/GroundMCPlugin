package gtlp.groundmc.lobby.event

import org.bukkit.entity.Player
import org.bukkit.event.HandlerList
import org.bukkit.event.player.PlayerEvent

class PlayerChangeLocaleEvent(player: Player) : PlayerEvent(player) {

    override fun getHandlers(): HandlerList = handlersList


    companion object {
        val handlersList = HandlerList()

        @JvmStatic fun getHandlerList(): HandlerList = handlersList
    }
}
