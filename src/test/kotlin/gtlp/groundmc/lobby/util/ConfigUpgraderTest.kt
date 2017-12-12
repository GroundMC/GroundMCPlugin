package gtlp.groundmc.lobby.util

import org.bukkit.Material
import org.bukkit.configuration.file.YamlConfiguration
import org.junit.Assert
import org.junit.Test
import java.io.File
import kotlin.test.junit.JUnitAsserter

class ConfigUpgraderTest {

    @Test
    fun addJumpPadConfiguration() {
        val config = YamlConfiguration.loadConfiguration(File("configupgrader/one.yml"))
        // Copied code from [gtlp.groundmc.lobby.util.ConfigUpgrader.addJumpPadConfiguration]
        if ("jumppads" !in config) {
            config["jumppads.material"] = listOf(Material.GOLD_PLATE.name)
            config["jumppads.multiplier"] = 3.0
            config["jumppads.y"] = 1
        }
        JUnitAsserter.assertTrue("jumppads in config", "jumppads" in config)
        Assert.assertEquals(config["jumppads.material"], listOf(Material.GOLD_PLATE.name))
        Assert.assertEquals(config["jumppads.multiplier"], 3.0)
        Assert.assertEquals(config["jumppads.y"], 1)
    }
}