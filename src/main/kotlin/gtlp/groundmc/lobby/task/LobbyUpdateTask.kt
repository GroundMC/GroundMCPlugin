package gtlp.groundmc.lobby.task

import com.onarandombox.MultiverseCore.MultiverseCore
import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import gtlp.groundmc.lobby.inventory.LobbyInventory
import gtlp.groundmc.lobby.util.NBTItemExt
import gtlp.groundmc.lobby.util.setOrAdd
import org.bukkit.Bukkit
import org.bukkit.ChatColor

object LobbyUpdateTask : ITask {
    override val delay: Long = 20
    override val period: Long = 30

    override fun run() {
        if (!Bukkit.getPluginManager().isPluginEnabled("Multiverse-Core")) {
            Bukkit.getServer().scheduler.cancelTask(LobbyMain.tasks[this] as Int)
        }

        val multiVerse = Bukkit.getPluginManager().getPlugin("Multiverse-Core") as MultiverseCore
        val worldManager = multiVerse.mvWorldManager

        for (i in 0..LobbyInventory.TEMPLATE_INVENTORY.contents.size - 1) {
            val it = NBTItemExt(LobbyInventory.TEMPLATE_INVENTORY.contents[i])
            if (it.hasKey(NBTIdentifier.PREFIX) && it.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                if (it.getString(NBTIdentifier.LOC_WORLD) != LobbyMain.hubLocation.get().world.name) {
                    val mvWorld = worldManager.getMVWorld(it.getString(NBTIdentifier.LOC_WORLD))
                    val nPlayers = mvWorld.cbWorld.players.size
                    val playerLimit = mvWorld.playerLimit
                    if (playerLimit < 0) {
                        return
                    }

                    val color = when (Math.floor((nPlayers.toDouble() / playerLimit) * 3)) {
                        0.0 -> ChatColor.WHITE.toString()
                        1.0 -> ChatColor.GREEN.toString()
                        2.0 -> ChatColor.GOLD.toString()
                        3.0 -> ChatColor.RED.toString()
                        else -> ChatColor.BLACK.toString()
                    }

                    val meta = it.item.itemMeta
                    if (!meta.hasLore()) {
                        meta.lore = mutableListOf()
                    }
                    meta.lore = meta.lore.setOrAdd(0, "$color$nPlayers/$playerLimit")
                    it.item.itemMeta = meta
                    LobbyInventory.TEMPLATE_INVENTORY.setItem(i, it.item)
                }
            }
        }
    }
}