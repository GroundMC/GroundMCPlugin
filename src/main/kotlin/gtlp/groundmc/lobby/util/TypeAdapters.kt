

package gtlp.groundmc.lobby.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.bukkit.Location
import org.joda.time.DateTime

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

object DateTimeAdapter : TypeAdapter<DateTime>() {

    override fun write(writer: JsonWriter, dateTime: DateTime?) {
        if (dateTime != null) {
            writer.value(dateTime.toString())
        } else {
            writer.nullValue()
        }
    }

    override fun read(reader: JsonReader): DateTime {
        return DateTime(reader.nextString())
    }

}
