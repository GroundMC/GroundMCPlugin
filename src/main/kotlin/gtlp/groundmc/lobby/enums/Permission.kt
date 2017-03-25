package gtlp.groundmc.lobby.enums

/**
 * Enum to store permissions as strings
 * Consolidates all permissions into one enum.
 */
enum class Permission constructor(val id: String) {
    ADMIN("groundmc.lobby.admin"),
    HIDE_PLAYERS("groundmc.lobby.hide_players"),
    SILENT("groundmc.lobby.silent"),
    VANISH("groundmc.lobby.vanish");
}