package net.groundmc.lobby.enums

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
     * Denotes that the item should open the [net.groundmc.lobby.inventory.HidePlayerInventory]
     */
    HIDE_PLAYERS,

    /**
     * Denotes that the item should open the [net.groundmc.lobby.inventory.LobbyChooser]
     */
    CHOOSE_LOBBY,

    /**
     * Denotes that the item should open the [net.groundmc.lobby.inventory.FriendsOverviewInventory]
     */
    FRIENDS,

    REMOVE_FRIEND,

    FRIEND_REQUESTS;

    companion object {

        val BY_ID = mutableMapOf<Int, GMCType>()

        // Put after all needed values and variables, otherwise they will be null
        // (no idea why, though)
        init {
            values().forEach {
                BY_ID[it.ordinal] = it
            }
        }

    }
}
