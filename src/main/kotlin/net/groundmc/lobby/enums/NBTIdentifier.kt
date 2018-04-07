package net.groundmc.lobby.enums

import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.inventory.ItemStack

/**
 * Enum to store NBTIdentifiers for use with [net.groundmc.lobby.objects.NBTItemExt]
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
     * The identifier to go with [net.groundmc.lobby.enums.GMCType]
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
     * The identifier to go with [net.groundmc.lobby.enums.VisibilityStates]
     */
    HIDE_STATE("hide"),

    /**
     * The identifier that stores the current open page
     */
    PAGE("page"),

    /**
     * Identifier for the relationship that is saved temporarily.
     */
    RELATIONSHIP("friend");

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
