package gtlp.groundmc.lobby.database.table

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime

object Events : Table() {
    private val id = integer("id").default(0).primaryKey().autoIncrement()

    private val title = text("title")

    val creator = uuid("creator").references(Users.id)

    val creationTime = datetime("creation_time")

    private val beginTime = datetime("begin_time")

    private val endTime = datetime("end_time").nullable()

    private val active = bool("active").default(true)


    fun getCurrentEventTitles(): List<String> {
        return getCurrentEvents().map { it[title] }
    }

    private fun getCurrentEvents(): List<ResultRow> {
        return transaction {
            return@transaction select {
                (beginTime less DateTime.now()) and
                        (endTime greater DateTime.now()) and
                        (active eq true)
            }
                    .orderBy(endTime, true).toList()
        }
    }

    fun disable(index: Int) {
        transaction {
            val events = getCurrentEvents()
            events[index].also {
                update({ id eq it[id] }, null, {
                    it[active] = false
                })
            }
        }
    }
}