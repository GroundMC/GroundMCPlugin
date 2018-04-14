package net.groundmc.lobby.util

import net.groundmc.lobby.i18n.I18NStrings
import org.junit.jupiter.api.Assertions.assertNotNull
import java.util.*
import kotlin.test.Test

class I18NStringsTest {

    @Test
    fun getEnglish() {
        val bundle = ResourceBundle.getBundle("lang.lobby", Locale.US)
        I18NStrings.values().forEach {
            assertNotNull(bundle.getString(it.id))
        }
    }

    @Test
    fun getGerman() {
        val bundle = ResourceBundle.getBundle("lang.lobby", Locale.GERMAN)
        I18NStrings.values().forEach {
            assertNotNull(bundle.getString(it.id))
        }
    }
}
