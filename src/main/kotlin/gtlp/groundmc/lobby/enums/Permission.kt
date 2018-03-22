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

import org.bukkit.Bukkit

/**
 * Enum to store permissions as strings.
 * Consolidates all permissions into one enum.
 */
enum class Permission constructor(
        /**
         * The permission object used by Bukkit.
         * Can be used in plugins that manage permissions.
         */
        val permission: org.bukkit.permissions.Permission
) {
    /**
     * The administrator permission.
     * Players with this permission have full control over the functionality
     * of the plugin.
     */
    ADMIN(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.admin")),

    /**
     * Players with this permission are allowed to hide other players from their view.
     */
    HIDE_PLAYERS(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.hide_players")),

    /**
     * Players with this permission are allowed to silence their chat.
     */
    SILENT(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.silent")),

    /**
     * Players with this permission are allowed to vanish and become invisible to other players.
     */
    VANISH(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.vanish"));
}
