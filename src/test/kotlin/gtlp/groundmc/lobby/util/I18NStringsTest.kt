package gtlp.groundmc.lobby.util

import org.junit.jupiter.api.Assertions.assertNotNull
import java.util.*
import kotlin.test.Test

class I18NStringsTest {

    @Test
    fun get() {
        I18NStrings.values().forEach {
            assertNotNull(it.get(Locale.US))
        }
    }
}
