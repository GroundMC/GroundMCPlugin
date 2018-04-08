package net.groundmc.lobby.event.listener

import de.dytanic.cloudnet.bridge.event.bukkit.BukkitCustomChannelMessageReceiveEvent
import de.dytanic.cloudnet.lib.utility.document.Document
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.objects.Friend
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.ComponentBuilder
import net.md_5.bungee.api.chat.TextComponent
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
                CHAT_COMPONENT -> handleChat(event)
            }
        }
    }

    private fun handleChat(event: BukkitCustomChannelMessageReceiveEvent) {
        when (event.document["message"].asString) {
            I18NStrings.FRIENDREQUEST_RECEIVED.id -> handleFriendRequest(event.document)
        }
    }

    private fun handleFriendRequest(document: Document) {
        val receiver = Bukkit.getPlayer(UUID.fromString(document["receiver"].asString))
        val sender = Friend.fromUniqueId(UUID.fromString(document["sender"].asString))
        receiver.sendMessage(
                *ComponentBuilder("")
                        .append(TextComponent.fromLegacyText(I18NStrings.FRIENDREQUEST_RECEIVED.format(receiver, sender.name)))
                        .append(TextComponent.fromLegacyText(I18NStrings.FRIENDREQUEST_ACCEPT.get(receiver)).apply {
                            this.forEach {
                                it.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friend add ${sender.uniqueId}")
                            }
                        })
                        .append(" | ").color(ChatColor.WHITE)
                        .append(TextComponent.fromLegacyText(I18NStrings.FRIENDREQUEST_DENY.get(receiver)).apply {
                            this.forEach {
                                it.clickEvent = ClickEvent(ClickEvent.Action.RUN_COMMAND, "/friend remove ${sender.uniqueId}")
                            }
                        }).create()
        )
    }
}
