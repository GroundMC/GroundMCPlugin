package net.groundmc.lobby.event.listener

import com.google.common.cache.CacheBuilder
import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.util.LOGGER
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
                event.player.sendMessage(I18NStrings.TOO_MANY_MESSAGES.get(event.player))
                LOGGER.finest("${event.player} sent messages too quickly!")
            } else {
                nextMessage.put(event.player, Unit)
            }
        }
    }
}
