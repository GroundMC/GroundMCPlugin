/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby.event.listener

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Users
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.util.I18n
import gtlp.groundmc.lobby.util.NBTItemExt
import kotlinx.coroutines.experimental.async
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

/**
 * This [Listener] manages the silent chat function.
 * It allows players to toggle their chat to silence and non-silence.
 * It also filters the chat for those users that have enabled this feature.
 */
object SilentChatListener : Listener {
    /**
     * Updates the chat silence setting.
     *
     * @param event the event to handle
     */
    @EventHandler(priority = EventPriority.LOWEST)
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
        if (event.action != Action.PHYSICAL && event.currentItem != null && event.whoClicked is Player) {
            val nbtItem = NBTItemExt(event.currentItem)
            if (NBTIdentifier.itemHasPrefix(event.currentItem) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.SILENT.ordinal) {
                event.isCancelled = true
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
        async {
            if (nbtItem.getBoolean(NBTIdentifier.SILENT_STATE)!!) {
                // silent -> loud
                LobbyMain.SILENCED_PLAYERS.remove(player)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, false)
                nbtItem.displayName = I18n.getString("silentitem.off", player.locale)
                nbtItem.removeEnchantment(Enchantment.LUCK)
                player.sendMessage(I18n.getString("silentmsg.off", player.locale))
                transaction {
                    Users.update({ Users.id eq player.uniqueId }) {
                        it[silentStatus] = false
                    }
                }
            } else {
                // loud -> silent
                LobbyMain.SILENCED_PLAYERS.add(player)
                nbtItem.setBoolean(NBTIdentifier.SILENT_STATE, true)
                nbtItem.displayName = I18n.getString("silentitem.on", player.locale)
                nbtItem.addEnchantment(Enchantment.LUCK)
                player.sendMessage(I18n.getString("silentmsg.on", player.locale))
                transaction {
                    Users.update({ Users.id eq player.uniqueId }) {
                        it[silentStatus] = true
                    }
                }
            }
            player.inventory.setItem(1, nbtItem.item)
        }
    }

    /**
     * Filters the recipients of a chat message by removing all players that
     * want a silent chat.
     *
     * @param event the event to handle
     */
    @EventHandler
    fun filterChat(event: AsyncPlayerChatEvent) {
        if (event.isCancelled) {
            return
        }
        event.recipients.removeAll(LobbyMain.SILENCED_PLAYERS)
        event.recipients.add(event.player)
    }

}
