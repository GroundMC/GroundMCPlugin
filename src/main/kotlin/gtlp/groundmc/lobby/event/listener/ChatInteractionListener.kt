package gtlp.groundmc.lobby.event.listener

import com.google.common.cache.CacheBuilder
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import java.util.concurrent.TimeUnit

/**
 * This [Listener] handles the chat interaction of the players.
 * It makes sure that the chat is not spammed by malicious players, if this
 * feature is enabled.
 */
object ChatInteractionListener : Listener {

    private const val key = "lastChatMsg"

    private val nextMessage by lazy {
        CacheBuilder.newBuilder()
                .expireAfterWrite(Meta[Config.SLOWCHAT_TIMEOUT]
                        ?: 0, TimeUnit.MILLISECONDS)
                .build<Player, Unit>()
    }

    /**
     * Slows down the chat by cancelling fast chat messages.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun slowChat(event: AsyncPlayerChatEvent) {
        if (event.isCancelled) return

        if (Meta[Config.SLOWCHAT_ENABLED] == true) {
            if (nextMessage.getIfPresent(event.player) != null) {
                event.isCancelled = true
                event.player.sendMessage(I18n.getString("too_many_messages", event.player.locale))
                LobbyMain.logger.finest("${event.player} sent messages too quickly!")
            } else {
                nextMessage.put(event.player, Unit)
            }
        }
    }
}
