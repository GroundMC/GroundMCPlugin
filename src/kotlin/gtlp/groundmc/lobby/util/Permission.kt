package gtlp.groundmc.lobby.util

/**
 * Created by Marv1 on 24.10.2016.
 */
enum class Permission constructor(identifier: String) {
    ADMIN("groundmc.lobby.admin"),
    HIDE_PLAYERS("groundmc.lobby.hide_players"),
    SILENT("groundmc.lobby.silent");

    override fun toString(): String = id

    private var id: String = identifier
}