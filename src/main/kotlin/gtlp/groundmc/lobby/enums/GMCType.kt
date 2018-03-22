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

package gtlp.groundmc.lobby.enums

/**
 * Enum to determine the type of a lobby item.
 */
enum class GMCType {
    /**
     * Denotes no special type
     */
    NONE,

    /**
     * Denotes that the item is used to teleport players
     */
    TP,

    /**
     * Denotes that the item is used to silence the chat
     */
    SILENT,

    /**
     * Denotes that the item should open the [gtlp.groundmc.lobby.inventory.HidePlayerInventory]
     */
    HIDE_PLAYERS,

    /**
     * Denotes that the item should open the [gtlp.groundmc.lobby.inventory.LobbyChooser]
     */
    CHOOSE_LOBBY,

    FRIENDS;
}
