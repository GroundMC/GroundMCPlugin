package gtlp.groundmc.lobby.enum

/**
 * Enumeration of levels of relationships
 */
enum class RelationshipLevel(val limit: Int) {
    KNOWN(Int.MAX_VALUE),
    WELL_KNOWN(Int.MAX_VALUE),
    FRIEND(100),
    GOOD_FRIEND(20),
    BEST_FRIEND(5);
}