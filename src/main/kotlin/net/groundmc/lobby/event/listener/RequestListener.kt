package net.groundmc.lobby.event.listener

import de.dytanic.cloudnet.bridge.event.bukkit.BukkitCustomChannelMessageReceiveEvent
import de.dytanic.cloudnet.lib.utility.document.Document
import net.md_5.bungee.api.chat.BaseComponent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.*

object RequestListener : Listener {
    const val CHANNEL = "groundmc"

    const val CHAT_COMPONENT = "chat_component"

    @EventHandler
    fun crossServerChat(event: BukkitCustomChannelMessageReceiveEvent) {
        if (event.channel == CHANNEL) {
            when (event.message) {
                CHAT_COMPONENT -> {
                    Bukkit.getPlayer(UUID.fromString(event.document["receiver"].asString))
                            .sendMessage(*Document.GSON.fromJson(event.document["message"], Array<BaseComponent>::class.java))
                }
            }
        }
    }
}
