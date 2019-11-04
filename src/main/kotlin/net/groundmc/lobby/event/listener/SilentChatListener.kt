package net.groundmc.lobby.event.listener

import com.google.common.collect.Sets
import kotlinx.coroutines.launch
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Users
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.i18n.I18NStrings
import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.jetbrains.exposed.sql.transactions.experimental.suspendedTransactionAsync
import org.jetbrains.exposed.sql.update

/**
 * This [Listener] manages the silent chat function.
 * It allows players to toggle their chat to silence and non-silence.
 * It also filters the chat for those users that have enabled this feature.
 */
object SilentChatListener : Listener {

    /**
     * Set holding players that want their chat to be silent
     */
    val SILENCED_PLAYERS: MutableSet<Player> = Sets.newConcurrentHashSet<Player>()

    /**
     * Updates the chat silence setting.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun silentChat(event: PlayerInteractEvent) {
        if (event.item != null) {
            val nbtItem = NBTItemExt(event.item)
            if (NBTIdentifier.itemHasPrefix(event.item) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                event.isCancelled = true
                toggleSilentChat(nbtItem, event.player)
            }
        }
    }

    /**
     * Updates the chat silence setting.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun silentChat(event: InventoryClickEvent) {
        if (event.currentItem != null && event.whoClicked is Player) {
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(event.currentItem) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                event.result = Event.Result.DENY
                toggleSilentChat(nbtItem, event.whoClicked as Player)
            }
        }
    }

    /**
     * Toggles the chat silence settings for a [player].
     * This method saves the state for the next login and sends the respective
     * message to the player.
     *
     * @param nbtItem the item that has been used to toggle this setting
     * @param player the player that toggles the setting
     */
    private fun toggleSilentChat(nbtItem: NBTItemExt, player: Player) {
        LobbyMain.instance.scope.launch {
            if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)!!) {
                // silent -> loud
                SILENCED_PLAYERS.remove(player)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                nbtItem.displayName = I18NStrings.SILENTITEM_OFF.get(player)
                nbtItem.removeEnchantment(Enchantment.LUCK)
                player.sendMessage(I18NStrings.SILENTITEM_OFF.get(player))
                updateSilentStatus(player, false)
            } else {
                // loud -> silent
                SILENCED_PLAYERS.add(player)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                nbtItem.displayName = I18NStrings.SILENTITEM_ON.get(player)
                nbtItem.addEnchantment(Enchantment.LUCK)
                player.sendMessage(I18NStrings.SILENTITEM_ON.get(player))
                updateSilentStatus(player, true)
            }
            player.inventory.setItem(1, nbtItem.item)
        }
    }

    private suspend fun updateSilentStatus(player: Player, newStatus: Boolean) {
        suspendedTransactionAsync {
            Users.update({ Users.id eq player.uniqueId }) {
                it[silentStatus] = newStatus
            }
            commit()
        }
        Users.refresh(player)
    }

    /**
     * Filters the recipients of a chat message by removing all players that
     * want a silent chat.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun filterChat(event: AsyncPlayerChatEvent) {
        event.recipients.removeAll(SILENCED_PLAYERS)
        event.recipients.add(event.player)
    }

}
