package net.groundmc.lobby.enums

import org.bukkit.Location

class Config<T>(val key: String, val type: Class<T>) {

    init {
        keys.add(this)
    }

    companion object {
        var keys = mutableListOf<Config<*>>()
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
