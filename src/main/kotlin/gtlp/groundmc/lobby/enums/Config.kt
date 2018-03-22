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

package gtlp.groundmc.lobby.enums

import org.bukkit.Location

class Config<T>(val key: String, val type: Class<T>) {

    init {
        values.add(this)
    }

    companion object {
        var values = mutableListOf<Config<*>>()
        val DATABASE_VERSION = Config("db.version", Int::class.javaObjectType)
        val COINS_DAILY = Config("coins.daily", Int::class.javaObjectType)
        val SLOWCHAT_ENABLED = Config("slowchat.enabled", Boolean::class.javaObjectType)
        val SLOWCHAT_TIMEOUT = Config("slowchat.timeout", Long::class.javaObjectType)
        val HUB_LOCATION = Config("hub.location", Location::class.javaObjectType)
        val JUMPPADS_MATERIAL = Config("jumppads.material", List::class.javaObjectType)
        val JUMPPADS_MULTIPLIER = Config("jumppads.multiplier", Double::class.javaObjectType)
        val JUMPPADS_Y = Config("jumppads.y", Double::class.javaObjectType)
        val INVENTORY_CONTENT = Config("inventory.content", List::class.javaObjectType)
    }
}
