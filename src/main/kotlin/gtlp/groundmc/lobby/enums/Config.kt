package gtlp.groundmc.lobby.enums

import org.bukkit.Location

enum class Config(val key: String, val type: Class<out Any> = String::class.java) {
    DATABASE_VERSION("db.version", Int::class.javaObjectType),
    COINS_DAILY("coins.daily", Int::class.javaObjectType),
    SLOWCHAT_ENABLED("slowchat.enabled", Boolean::class.javaObjectType),
    SLOWCHAT_TIMEOUT("slowchat.timeout", Long::class.javaObjectType),
    HUB_LOCATION("hub.location", Location::class.javaObjectType),
    JUMPPADS_MATERIAL("jumppads.material", List::class.javaObjectType),
    JUMPPADS_MULTIPLIER("jumppads.multiplier", Double::class.javaObjectType),
    JUMPPADS_Y("jumppads.y", Double::class.javaObjectType),
    INVENTORY_CONTENT("inventory.content", List::class.javaObjectType)
}