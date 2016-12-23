package gtlp.groundmc.lobby.enum

/**
 * Enumeration of levels of relationships
 */
enum class RelationshipLevel(val limit: Int, val i18nKey: String) {
    KNOWN(Int.MAX_VALUE, "relationship.known"),
    WELL_KNOWN(Int.MAX_VALUE, "relationship.well_known"),
    FRIEND(100, "relationship.friend"),
    GOOD_FRIEND(20, "relationship.good_friend"),
    BEST_FRIEND(5, "relationship.best_friend");
}