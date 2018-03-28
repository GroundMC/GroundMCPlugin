

package gtlp.groundmc.lobby.enums

/**
 * Enum to determine the type of a lobby item.
 */
enum class GMCType {
    /**
     * Denotes no special type
     */
    NONE,

    /**
     * Denotes that the item is used to teleport players
     */
    TP,

    /**
     * Denotes that the item is used to silence the chat
     */
    SILENT,

    /**
     * Denotes that the item should open the [gtlp.groundmc.lobby.inventory.HidePlayerInventory]
     */
    HIDE_PLAYERS,

    /**
     * Denotes that the item should open the [gtlp.groundmc.lobby.inventory.LobbyChooser]
     */
    CHOOSE_LOBBY,

    /**
     * Denotes that the item should open the [gtlp.groundmc.lobby.inventory.FriendsOverviewInventory]
     */
    FRIENDS,

    REMOVE_FRIEND;
}
