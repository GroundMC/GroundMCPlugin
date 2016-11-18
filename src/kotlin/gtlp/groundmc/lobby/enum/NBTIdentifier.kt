package gtlp.groundmc.lobby.enum

/**
 * Enum to store NBTIdentifiers for use with NBTItemExt
 */
enum class NBTIdentifier(identifier: String) {
    PREFIX("GMC"),
    TYPE("t"),
    LOC_X("x"),
    LOC_Y("y"),
    LOC_Z("z"),
    ROT_X("rx"),
    ROT_Y("ry"),
    LOC_WORLD("w"),
    SILENT_STATE("silent"),
    HIDE_STATE("hide");

    private val id = identifier

    override fun toString(): String {
        if (this == PREFIX) {
            return id
        }
        return "${PREFIX}$id"
    }
}