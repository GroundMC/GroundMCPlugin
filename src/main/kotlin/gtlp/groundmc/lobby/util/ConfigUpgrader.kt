package gtlp.groundmc.lobby.util

import gtlp.groundmc.lobby.LobbyMain
import gtlp.groundmc.lobby.enums.GMCType
import gtlp.groundmc.lobby.enums.NBTIdentifier
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.Configuration
import org.bukkit.inventory.ItemStack

object ConfigUpgrader {
    fun upgradeItemsToUseObject(config: Configuration) {
        LobbyMain.logger.entering(ConfigUpgrader::class, "upgradeItemsToUseObject")
        LobbyMain.logger.info("[Version 1] Upgrading items to use objects instead of separate keys")
        if ("inventory.content" in config && config["inventory.content"] is List<*>) {
            @Suppress("unchecked_cast")
            val contents = (config["inventory.content"] as List<ItemStack>).toTypedArray()

            contents.map(::NBTItemExt).forEachIndexed { index, it ->
                if (it.hasKey(NBTIdentifier.PREFIX) && it.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                    LobbyMain.logger.fine("Upgrading ${it.displayName}...")

                    val location = Location(Bukkit.getServer().getWorld(it.getString("GMCw")),
                            it.getDouble("GMCx"), it.getDouble("GMCy"), it.getDouble("GMCz"),
                            it.getDouble("GMCrx").toFloat(), it.getDouble("GMCry").toFloat())

                    LobbyMain.logger.fine("Location is $location...")

                    it.removeKey("GMCx")
                    it.removeKey("GMCy")
                    it.removeKey("GMCz")
                    it.removeKey("GMCw")
                    it.removeKey("GMCrx")
                    it.removeKey("GMCry")
                    it.setObject(NBTIdentifier.TP_LOC, location)
                }
                contents[index] = it.item
            }

            config["inventory.content"] = contents
        }
        LobbyMain.logger.exiting(ConfigUpgrader::class, "upgradeItemsToUseObject")
    }

}