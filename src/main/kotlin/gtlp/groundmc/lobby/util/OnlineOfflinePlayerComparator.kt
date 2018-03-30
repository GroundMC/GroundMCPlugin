package gtlp.groundmc.lobby.util

import gtlp.groundmc.lobby.Relationship

/**
 * Comparator that sorts players that are online in front of players who are offline.
 *
 * Then it sorts according to their names using [String.compareTo].
 *
 * `null` objects are sorted after non-null objects.
 */
class OnlineOfflinePlayerComparator : Comparator<Relationship> {
    override fun compare(o1: Relationship?, o2: Relationship?): Int {
        when {
            o1 == null && o2 == null -> return 0
            o1 != null && o2 == null -> return 1
            o1 == null && o2 != null -> return -1
        }
        val player1 = o1!!.user2.cloudPlayer
        val player2 = o2!!.user2.cloudPlayer
        return when {
            player1 != null && player2 != null -> o1.user2.name.compareTo(o2.user2.name)
            player1 != null && player2 == null -> -1
            player1 == null && player2 != null -> 1
            else -> o1.user2.name.compareTo(o2.user2.name)
        }
    }
}
