package gtlp.groundmc.lobby.enums

/**
 * Enum to store NBTIdentifiers for use with NBTItemExt
 */
enum class NBTIdentifier(identifier: String) {
    PREFIX("GMC"),
    TYPE("t"),
    TP_LOC("loc"),
    SILENT_STATE("silent"),
    HIDE_STATE("hide");

    private val id = identifier

    override fun toString(): String {
        if (this == PREFIX) {
            return id
        }
        return "$PREFIX$id"
    }
}