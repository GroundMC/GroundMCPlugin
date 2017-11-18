package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.I18n
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.metadata.FixedMetadataValue
import org.joda.time.Instant

object ChatInteractionListener : Listener {

    private val timeout: Long by lazy {
        LobbyMain.instance.config.getLong("slowchat.timeout")
    }

    /**
     * Slows down the chat by cancelling fast chat messages.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
    fun slowChat(event: AsyncPlayerChatEvent) {
        if (LobbyMain.instance.config.getBoolean("slowchat.enabled")) {
            val key = "lastChatMsg"
            if (event.player.hasMetadata(key) && (Instant.now() - event.player.getMetadata(key).first { it.owningPlugin == LobbyMain.instance }.asLong()) < Instant(timeout)) {
                event.isCancelled = true
                event.player.sendMessage(I18n.getString("too_many_messages", event.player.locale))
                LobbyMain.logger.finest("${event.player} sent messages too quickly!")
            } else {
                event.player.setMetadata(key, FixedMetadataValue(LobbyMain.instance, Instant().millis))
            }
        }
    }

}