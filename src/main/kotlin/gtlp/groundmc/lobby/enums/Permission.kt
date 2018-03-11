package gtlp.groundmc.lobby.enums

import org.bukkit.Bukkit

/**
 * Enum to store permissions as strings.
 * Consolidates all permissions into one enum.
 */
enum class Permission constructor(
        /**
         * The permission object used by Bukkit.
         * Can be used in plugins that manage permissions.
         */
        val permission: org.bukkit.permissions.Permission
) {
    /**
     * The administrator permission.
     * Players with this permission have full control over the functionality
     * of the plugin.
     */
    ADMIN(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.admin")),

    /**
     * Players with this permission are allowed to hide other players from their view.
     */
    HIDE_PLAYERS(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.hide_players")),

    /**
     * Players with this permission are allowed to silence their chat.
     */
    SILENT(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.silent")),

    /**
     * Players with this permission are allowed to vanish and become invisible to other players.
     */
    VANISH(Bukkit.getServer().pluginManager.getPermission("groundmc.lobby.vanish"));
}
