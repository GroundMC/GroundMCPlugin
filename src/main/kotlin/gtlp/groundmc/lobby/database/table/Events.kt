package gtlp.groundmc.lobby.database.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

object Events : Table() {
    private val id = integer("id").primaryKey().autoIncrement()

    private val title = text("title")

    val creator = uuid("creator").references(Users.id)

    val creationTime = datetime("creation_time")

    private val beginTime = datetime("begin_time")

    private val endTime = datetime("end_time").nullable()


    fun getCurrentEvents(): List<String> {
        return transaction {
            return@transaction select { (beginTime less DateTime.now()) and (endTime greater DateTime.now()) }
                    .orderBy(endTime, true).map { it[title] }
        }
    }
}