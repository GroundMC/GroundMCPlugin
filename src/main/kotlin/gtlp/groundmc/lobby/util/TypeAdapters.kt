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

package gtlp.groundmc.lobby.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.bukkit.Location

/**
 * An adapter to serialize and deserialize a [Location] object
 */
object LocationTypeAdapter : TypeAdapter<Location>() {

    /**
     * Writes a [Location] object to a [JsonWriter].
     *
     * @param writer the [JsonWriter] to write to.
     * @param location the [Location] to write.
     */
    override fun write(writer: JsonWriter, location: Location?) {
        if (location != null) {
            writer.value(Gson().toJson(location.serialize()))
        } else {
            writer.nullValue()
        }
    }

    /**
     * Reads a JSON-encoded string and converts it to a [Location] object.
     *
     * @param reader the [JsonReader] to read from.
     *
     * @return the deserialized [Location] object
     */
    override fun read(reader: JsonReader): Location? {
        val read = reader.nextString()

        @Suppress("unchecked_cast")
        return Location.deserialize(Gson().fromJson(read, Map::class.java) as Map<String, Any>)
    }

}
