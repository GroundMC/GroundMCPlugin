/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby.database.table

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.util.entering
import gtlp.groundmc.lobby.util.exiting
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Table holding all past, current and future events planned for the server.
 */
object Events : Table() {

    /**
     * The unique id of the event
     */
    private val id = integer("id").default(0).primaryKey().autoIncrement()

    /**
     * The title or description of this event.
     * Will be visible in the scoreboard.
     */
    internal val title = text("title")

    /**
     * The UUID of the creator of this event.
     */
    private val creator = uuid("creator").references(Users.id).nullable()

    /**
     * The time at which this event was created.
     */
    private val creationTime = datetime("creation_time")

    /**
     * The earliest time at which this event should be visible to the players.
     */
    private val beginTime = datetime("begin_time")

    /**
     * The latest time at which this event should still be visible to
     * the players.
     */
    private val endTime = datetime("end_time")

    /**
     * Whether or not this event has been disabled.
     */
    private val active = bool("active").default(true)

    private val eventCache = CacheBuilder.newBuilder().refreshAfterWrite(5L, TimeUnit.SECONDS).build(CacheLoader.asyncReloading(
            EventCacheLoader(), Executors.newCachedThreadPool()))

    class EventCacheLoader : CacheLoader<Unit, List<ResultRow>>() {
        override fun load(key: Unit?): List<ResultRow> {
            return transaction {
                return@transaction select {
                    (beginTime less DateTime.now()) and
                            (endTime greater DateTime.now()) and
                            (active eq true)
                }
                        .orderBy(endTime, true).toList()
            }
        }
    }

    /**
     * Fetches all currently active events and returns their titles in a [List]
     *
     * @return a list of all the titles of the currently active events
     *
     * @see getCurrentEvents
     */
    fun getCurrentEventTitles(): List<String> {
        return getCurrentEvents().map { it[title] }
    }

    /**
     * Fetches all the events that are currently active.
     *
     * @return a list of all the events that are currently active
     */
    private fun getCurrentEvents(): List<ResultRow> {
        return eventCache.get(Unit)
    }

    /**
     * Disables the event at the [n]-th index that is currently visible in the
     * scoreboard and thus active.
     *
     * @param n the index of the event to disable
     *
     * @return the disabled event.
     *
     * @see getCurrentEvents
     */
    fun disable(n: Int): ResultRow {
        LobbyMain.logger.entering(Events::class, "disable")
        return transaction {
            val events = getCurrentEvents()
            LobbyMain.logger.info("Disabling ${events[n]}")
            return@transaction events[n].also {
                update({ id eq it[id] }, null, {
                    it[active] = false
                })
            }
        }
    }

    /**
     * Inserts a new event into the table.
     * If the [sender] is an instance of [Player], this will add it's
     * [Player.getUniqueId] into the table. If not, this will just leave the
     * column empty with a `null` value.
     *
     * @param eventTitle the title of the event, will be visible in the scoreboard
     * @param sender the player that created this event
     * @param beginDate the date and time at which this event will be visible
     * @param endDate the date and time at which this event will be over
     *
     * @return the success of this insert call
     */
    fun newEvent(eventTitle: String, sender: CommandSender, beginDate: DateTime, endDate: DateTime): Boolean {
        LobbyMain.logger.entering(Events::class, "newEvent")
        LobbyMain.logger.info("Creating new event: $eventTitle, $sender, $beginDate, $endDate")
        transaction {
            insert {
                it[title] = eventTitle
                it[creator] = (sender as? Player)?.uniqueId
                it[creationTime] = DateTime.now()
                it[beginTime] = beginDate
                it[endTime] = endDate
            }
        }
        LobbyMain.logger.exiting(Events::class, "newEvent")
        return true
    }
}
