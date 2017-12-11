package gtlp.groundmc.lobby.task

import com.onarandombox.MultiverseCore.MultiverseCore
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.database.table.Meta
import gtlp.groundmc.lobby.enums.Config
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.inventory.ItemStack

/**
 * Task to update the items in the [LobbyInventory] that refer to worlds that
 * are managed by Multiverse-Core and have custom player limits set.
 *
 * @refer [MultiverseCore]
 */
object UpdateLobbyInventoryTask : ITask {
    override val delay = 20L
    override val period = 30L

    override fun run() {
        if (!Bukkit.getPluginManager().isPluginEnabled("Multiverse-Core")) {
            Bukkit.getServer().scheduler.cancelTask(LobbyMain.tasks[this]!!)
            return
        }

        val multiVerse = Bukkit.getPluginManager().getPlugin("Multiverse-Core") as MultiverseCore
        val worldManager = multiVerse.mvWorldManager

        LobbyInventory.TEMPLATE_INVENTORY.forEach { it: ItemStack? ->
            if (it == null) {
                return
            }
            val nbtItem = NBTItemExt(it)
            if (NBTIdentifier.itemHasPrefix(it) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                val world = nbtItem.getObject(NBTIdentifier.TP_LOC, Location::class)!!.world
                if (world != (Meta[Config.HUB_LOCATION] as Location).world) {
                    val mvWorld = worldManager.getMVWorld(world)
                    val nPlayers = mvWorld.cbWorld.players.size
                    val playerLimit = mvWorld.playerLimit
                    if (playerLimit < 0) {
                        return
                    }

                    val color = when (Math.floor((nPlayers.toDouble() / playerLimit))) {
                        0.0 -> ChatColor.WHITE.toString()
                        0.3 -> ChatColor.GREEN.toString()
                        0.6 -> ChatColor.GOLD.toString()
                        0.9 -> ChatColor.RED.toString()
                        else -> ChatColor.BLACK.toString()
                    }

                    nbtItem.lore = listOf("$color$nPlayers/$playerLimit")
                }
            }
        }
    }
}