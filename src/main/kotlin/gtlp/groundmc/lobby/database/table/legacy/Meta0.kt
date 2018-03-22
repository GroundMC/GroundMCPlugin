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

package gtlp.groundmc.lobby.database.table.legacy

import org.jetbrains.exposed.sql.Table

/**
 * Legacy table for compatibility during upgrades.
 */
object Meta0 : Table("Meta") {
    /**
     * The latest version of the database.
     * Used to track the upgrade process and to determine what upgrades to do.
     */
    private const val CURRENT_TABLE_VER = 2

    /**
     * Column to hold the current database version.
     * Updated on upgrades.
     */
    internal val version = integer("version").default(CURRENT_TABLE_VER).primaryKey()
}
