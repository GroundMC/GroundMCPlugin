package gtlp.groundmc.lobby.enums

enum class Config(val key: String) {
    DATABASE_VERSION("db.version"),
    COINS_DAILY("coins.daily"),
    SLOWCHAT_ENABLED("slowchat.enabled"),
    SLOWCHAT_TIMEOUT("slowchat.timeout"),
}