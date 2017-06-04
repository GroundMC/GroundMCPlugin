package gtlp.groundmc.lobby.enums

/**
 * Enum to store permissions as strings.
 * Consolidates all permissions into one enum.
 */
enum class Permission constructor(val id: String) {
    /**
     * The administrator permission.
     * Players with this permission usually have full control over the functionality
     * of the plugin.
     */
    ADMIN("groundmc.lobby.admin"),

    /**
     * Players with this permission are allowed to hide other players from their view.
     */
    HIDE_PLAYERS("groundmc.lobby.hide_players"),

    /**
     * Players with this permission are allowed to silence their chat.
     */
    SILENT("groundmc.lobby.silent"),

    /**
     * Players with this permission are allowed to vanish and become invisible to other players.
     */
    VANISH("groundmc.lobby.vanish");
}
