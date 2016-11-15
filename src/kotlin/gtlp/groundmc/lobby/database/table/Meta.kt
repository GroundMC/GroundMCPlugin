package gtlp.groundmc.lobby.database.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll

object Meta : Table() {
    private val CURRENT_TABLE_VER = 1

    private val version = integer("version").default(CURRENT_TABLE_VER).uniqueIndex().primaryKey()

    fun upgradeDatabase() {
        val currentVersion = Meta.selectAll().first()[version]
        for (version in currentVersion..CURRENT_TABLE_VER) {
            when (version) {

            }
        }
    }
}