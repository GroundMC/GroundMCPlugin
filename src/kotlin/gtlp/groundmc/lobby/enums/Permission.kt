package gtlp.groundmc.lobby.enums

/**
 * Enum to store permissions as strings
 * Consolidates all permissions into one enum.
 */
enum class Permission constructor(identifier: String) {
    ADMIN("groundmc.lobby.admin"),
    HIDE_PLAYERS("groundmc.lobby.hide_players"),
    SILENT("groundmc.lobby.silent");

    override fun toString(): String = id

    private val id: String = identifier
}