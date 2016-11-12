package gtlp.groundmc.lobby.database.table

import gtlp.groundmc.lobby.enum.VisibilityStates
import org.jetbrains.exposed.sql.Table
import javax.sql.rowset.serial.SerialBlob

/**
 * Created by Marvin on 11.11.2016.
 */
object Friends : Table() {
    val id = uuid("playerId").primaryKey().uniqueIndex()
    val silentStatus = bool("silent_status").default(false)
    val hiddenStatus = enumeration("hidden_status", VisibilityStates::class.java).default(VisibilityStates.ALL)
    val friends = blob("friends").default(SerialBlob(byteArrayOf(0)))
}