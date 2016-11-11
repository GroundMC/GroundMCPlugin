package gtlp.groundmc.lobby.util

/**
 * Enum to store NBTIdentifiers for use with NBTItemExt
 */
enum class NBTIdentifier(identifier: String) {
    PREFIX("GMC"),
    TYPE("t"),
    LOC_X("x"),
    LOC_Y("y"),
    LOC_Z("z"),
    LOC_WORLD("w"),
    SILENT_STATE("silent"),
    HIDE_STATE("hide");

    private val id = identifier

    override fun toString(): String {
        if (this == PREFIX) {
            return PREFIX.id
        }
        return "$PREFIX$id"
    }
}