package net.groundmc.lobby.database.table.legacy

import org.jetbrains.exposed.sql.Table

/**
 * Legacy table for compatibility during upgrades.
 */
object Meta0 : Table("Meta") {
    /**
     * The latest version of the database.
     * Used to track the upgrade process and to determine what upgrades to do.
     */
    private const val CURRENT_TABLE_VER = 2

    /**
     * Column to hold the current database version.
     * Updated on upgrades.
     */
    internal val version = integer("version").default(CURRENT_TABLE_VER).primaryKey()
}
