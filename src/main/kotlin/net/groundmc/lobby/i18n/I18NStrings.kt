package net.groundmc.lobby.i18n

import org.bukkit.entity.Player
import java.util.*

enum class I18NStrings(val id: String) {

    COMMAND_COINS_CURRENCY("command.coins.currency"),
    COMMAND_COINS_HELP("command.coins.help"),
    COMMAND_PLAYERONLY("command.playeronly"),
    COMMAND_FRIEND_ALREADY_FRIENDS("command.friend.already_friends"),
    COMMAND_FRIEND_CANT_ADD_YOURSELF("command.friend.cant_add_yourself"),
    COMMAND_FRIEND_HELP("command.friend.help"),
    COMMAND_FRIEND_NO_FRIENDS("command.friend.no_friends"),
    COMMAND_FRIEND_NO_FRIENDS_ONLINE("command.friend.no_friends_online"),
    COMMAND_FRIEND_NO_LONGER_RELATED("command.friend.no_longer_related"),
    COMMAND_FRIEND_PLAYER_NOT_FOUND("command.friend.player_not_found"),
    COMMAND_FRIEND_SPECIFY_LEVEL_UPDATE("command.friend.specify_level_update"),
    COMMAND_FRIEND_SPECIFY_PLAYER("command.friend.specify_player"),
    COMMAND_FRIEND_SPECIFY_PLAYER_STATUS("command.friend.specify_player_status"),
    COMMAND_FRIEND_SPECIFY_PLAYER_UPDATE("command.friend.specify_player_update"),
    COMMAND_FRIEND_SUCCESSFULLY_ADDED("command.friend.successfully_added"),
    COMMAND_FRIEND_UNKNOWN_RELATIONSHIP_LEVEL("command.friend.unknown_relationship_level"),
    COMMAND_FRIEND_VALID_LEVELS("command.friend.valid_levels"),
    COMMAND_FRIENDS_HELP("command.friends.help"),
    COMMAND_FRIENDS_NO_FRIENDS("command.friends.no_friends"),
    COMMAND_LOBBY_30SECONDS("command.lobby.30seconds"),
    COMMAND_LOBBY_HELP("command.lobby.help"),
    COMMAND_LOBBY_INVENTORYDONE("command.lobby.inventorydone"),
    COMMAND_LOBBY_PLACEITEM("command.lobby.placeitem"),
    EVENT_DAILYCOINS("event.dailyCoins"),
    NOPERMISSION("nopermission"),
    RELATIONSHIP_BEST_FRIEND("relationship.best_friend"),
    RELATIONSHIP_EXISTS("relationship.exists"),
    RELATIONSHIP_FRIEND("relationship.friend"),
    RELATIONSHIP_GOOD_FRIEND("relationship.good_friend"),
    RELATIONSHIP_KNOWN("relationship.known"),
    RELATIONSHIP_NOT_RELATED("relationship.not_related"),
    RELATIONSHIP_STATUS("relationship.status"),
    RELATIONSHIP_SUCCESS("relationship.success"),
    RELATIONSHIP_WELL_KNOWN("relationship.well_known"),
    RELATIONSHIP_SINCE("relationship.since"),
    SILENTITEM_OFF("silentitem.off"),
    SILENTITEM_ON("silentitem.on"),
    SILENTMSG_OFF("silentmsg.off"),
    SILENTMSG_ON("silentmsg.on"),
    UNKNOWN_ERROR("unknown_error"),
    VANISH_OFF("vanish.off"),
    VANISH_ON("vanish.on"),
    VISIBILITY_ALL("visibility.all"),
    VISIBILITY_FRIENDS("visibility.friends"),
    VISIBILITY_NONE("visibility.none"),
    COMMAND_FRIEND_NOT_FOUND("command.friend.not_found"),
    COMMAND_LOBBY_LOCATION_SET("command.lobby.location_set"),
    TOO_MANY_MESSAGES("too_many_messages"),
    FRIENDSITEM_NAME("friendsitem.name"),
    PLAY_TIME("play_time"),
    EVENT_YES("event.yes"),
    EVENT_NO("event.no"),
    EVENT_UNSET("event.unset"),
    EVENT_CREATE("event.create"),
    FRIENDS_PAGE("friends.page"),
    RELATIONSHIP_REMOVE("relationship.remove"),
    FRIENDS_JUMP("friends.jump"),
    FRIENDS_OFFLINE("friends.offline"),
    FRIENDS_NEXT_PAGE("friends.next_page"),
    FRIENDS_PREVIOUS_PAGE("friends.previous_page"),
    FRIENDREQUEST_SENT("friendrequest.sent"),
    FRIENDREQUEST_RECEIVED("friendrequest.received"),
    FRIENDREQUEST_ACCEPT("friendrequest.accept"),
    FRIENDREQUEST_DENY("friendrequest.deny")
    ;

    fun format(locale: Locale, vararg obj: Any?) = I18n.getString(id, locale)?.format(*obj)

    fun format(locale: String, vararg obj: Any?) = I18n.getString(id, locale)?.format(*obj)

    fun format(player: Player, vararg obj: Any?) = I18n.getString(id, I18nUtils.getLocaleFromCommandSender(player))?.format(*obj)

    fun get(locale: Locale) = I18n.getString(id, locale)

    fun get(locale: String) = I18n.getString(id, locale)

    fun get() = I18n.getString(id)

    fun get(player: Player) = I18n.getString(id, I18nUtils.getLocaleFromCommandSender(player))
}
