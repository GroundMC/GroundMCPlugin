package gtlp.groundmc.lobby.util

import java.io.OutputStream

class DummyOutputStream : OutputStream() {
    override fun write(b: Int) {
        // Dummy write
    }

    override fun write(b: ByteArray?) {
        // Dummy write
    }

    override fun write(b: ByteArray?, off: Int, len: Int) {
        // Dummy write
    }
}