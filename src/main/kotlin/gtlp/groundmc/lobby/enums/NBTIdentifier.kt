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

import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.inventory.ItemStack

/**
 * Enum to store NBTIdentifiers for use with [gtlp.groundmc.lobby.util.NBTItemExt]
 */
enum class NBTIdentifier(
        /**
         * The string representation of this identifier
         */
        private val id: String
) {
    /**
     * The prefix of all identifiers
     */
    PREFIX("GMC"),

    /**
     * The identifier to go with [gtlp.groundmc.lobby.enums.GMCType]
     */
    TYPE("t"),

    /**
     * The identifier to go with a [org.bukkit.Location]
     */
    TP_LOC("loc"),

    /**
     * The identifier to go with the silent state
     */
    SILENT_STATE("silent"),

    /**
     * The identifier to go with [gtlp.groundmc.lobby.enums.VisibilityStates]
     */
    HIDE_STATE("hide");

    /**
     * Returns the prefix concatenated with the internal identifier.
     * Does not concatenate the [PREFIX] with itself.
     *
     * @return the concatenated identifier string.
     */
    override fun toString(): String {
        if (this == PREFIX) {
            return id
        }
        return "$PREFIX$id"
    }

    companion object {
        /**
         * Checks whether an item fulfills the constraint of being not-null and having
         * an element of type [Boolean] with key [PREFIX] and that that element is true.
         *
         * @return whether the [item] has an element with key [PREFIX] of type [Boolean]
         *          and is true.
         */
        fun itemHasPrefix(item: ItemStack?): Boolean = item != null && NBTItemExt(item).getBoolean(PREFIX) == true
    }
}
