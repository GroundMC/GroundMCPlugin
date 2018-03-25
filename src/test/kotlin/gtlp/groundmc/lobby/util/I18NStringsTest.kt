package gtlp.groundmc.lobby.util

import org.junit.jupiter.api.Assertions.assertNotNull
import java.util.*
import kotlin.test.Test
import kotlin.test.assertNotEquals

class I18NStringsTest {

    @Test
    fun getEnglish() {
        I18NStrings.values().forEach {
            assertNotNull(it.get(Locale.US))
        }
    }

    @Test
    fun getGerman() {
        I18NStrings.values().forEach {
            assertNotNull(it.get(Locale.GERMAN))
            println("Checking:")
            println(it.get(Locale.GERMAN))
            println(it.get(Locale.US))
            println()
            assertNotEquals(it.get(Locale.US), it.get(Locale.GERMAN))
        }
    }
}
