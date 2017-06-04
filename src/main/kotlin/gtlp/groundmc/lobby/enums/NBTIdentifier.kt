package gtlp.groundmc.lobby.enums

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
}
