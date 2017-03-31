package gtlp.groundmc.lobby.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import org.bukkit.Location


object LocationTypeAdapter : TypeAdapter<Location>() {
    override fun write(writer: JsonWriter, location: Location?) {
        if (location == null) {
            writer.nullValue()
            return
        }
        writer.value(Gson().toJson(location.serialize()))
    }

    override fun read(reader: JsonReader): Location {
        val read = reader.nextString()

        @Suppress("unchecked_cast")
        return Location.deserialize(Gson().fromJson(read, Map::class.java) as Map<String, Any>)
    }

}