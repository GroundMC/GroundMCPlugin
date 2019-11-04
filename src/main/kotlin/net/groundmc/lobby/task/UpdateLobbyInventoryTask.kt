package net.groundmc.lobby.task

import com.onarandombox.MultiverseCore.MultiverseCore
import net.groundmc.lobby.LobbyMain
import net.groundmc.lobby.database.table.Meta
import net.groundmc.lobby.enums.Config
import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.inventory.LobbyInventory
import net.groundmc.lobby.objects.NBTItemExt
import net.groundmc.lobby.util.LOGGER
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import kotlin.math.floor

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
            LOGGER.config("Multiverse-Core not found or enabled, disabling interop.")
            LobbyMain.instance.tasks[this]?.cancel()
            return
        }

        val multiVerse = Bukkit.getPluginManager().getPlugin("Multiverse-Core") as MultiverseCore
        val worldManager = multiVerse.mvWorldManager

        LobbyInventory.TEMPLATE_INVENTORY.filterNotNull().forEach {
            val nbtItem = NBTItemExt(it)
            if (NBTIdentifier.itemHasPrefix(it) && nbtItem.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                val world = nbtItem.getObject(NBTIdentifier.TP_LOC, Location::class)!!.world
                if (world != Meta[Config.HUB_LOCATION]?.world) {
                    val mvWorld = worldManager.getMVWorld(world)
                    val nPlayers = mvWorld.cbWorld.players.size
                    val playerLimit = mvWorld.playerLimit
                    if (playerLimit < 0) {
                        return
                    }

                    val color = when (floor((nPlayers.toDouble() / playerLimit.toDouble()))) {
                        0.0 -> ChatColor.WHITE.toString()
                        0.3 -> ChatColor.GREEN.toString()
                        0.6 -> ChatColor.GOLD.toString()
                        0.9 -> ChatColor.RED.toString()
                        else -> ChatColor.BLACK.toString()
                    }

                    nbtItem.lore = mutableListOf("$color$nPlayers/$playerLimit")
                }
            }
        }
    }
}
