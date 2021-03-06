package net.groundmc.lobby.util

import net.groundmc.lobby.enums.GMCType
import net.groundmc.lobby.enums.NBTIdentifier
import net.groundmc.lobby.objects.NBTItemExt
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.configuration.Configuration
import org.bukkit.inventory.ItemStack

/**
 * Upgrader to modify the configuration according to changes needed to work with the new version.
 */
object ConfigUpgrader {

    /**
     * Upgrades items in the lobby inventory section of the [config] to use a
     * [Location] object instead of a bunch of keys for storing the teleport
     * destination.
     *
     * @param config the configuration to upgrade
     */
    fun upgradeItemsToUseObject(config: Configuration) {
        LOGGER.entering(ConfigUpgrader::class, "upgradeItemsToUseObject", config)
        LOGGER.info("[Version 1] Upgrading items to use objects instead of separate keys")
        if ("inventory.content" in config && config["inventory.content"] is List<*>) {
            @Suppress("unchecked_cast")
            val contents = (config["inventory.content"] as List<ItemStack>).toTypedArray()

            contents.map(::NBTItemExt).forEachIndexed { index, it ->
                if (it.hasKey(NBTIdentifier.PREFIX) && it.getInteger(NBTIdentifier.TYPE) == GMCType.TP.ordinal) {
                    LOGGER.fine("Upgrading ${it.displayName}...")

                    val location = Location(Bukkit.getServer().getWorld(it.getString("GMCw")),
                            it.getDouble("GMCx"), it.getDouble("GMCy"), it.getDouble("GMCz"),
                            it.getDouble("GMCrx").toFloat(), it.getDouble("GMCry").toFloat())

                    LOGGER.fine("Location is $location...")

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
        LOGGER.exiting(ConfigUpgrader::class, "upgradeItemsToUseObject")
    }

    /**
     * Add configuration options for the jump pads in the hub.
     *
     * @param config the configuration to upgrade
     */
    fun addJumpPadConfiguration(config: Configuration) {
        LOGGER.entering(ConfigUpgrader::class, "addJumpPadConfiguration", config)
        if ("jumppads" !in config) {
            config["jumppads.material"] = listOf(Material.GOLD_PLATE.name)
            config["jumppads.multiplier"] = 3.0
            config["jumppads.y"] = 1
        }
        LOGGER.exiting(ConfigUpgrader::class, "addJumpPadConfiguration")
    }

}
