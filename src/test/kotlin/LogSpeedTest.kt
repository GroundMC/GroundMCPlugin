import gtlp.groundmc.lobby.LogFormatter
import org.junit.Test
import java.io.OutputStream
import java.io.PrintWriter
import java.io.StringWriter
import java.time.Duration
import java.util.*
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger
import java.util.logging.StreamHandler

class LogSpeedTest {

    @Test
    fun SpeedTestString() {
        val logHandler = StreamHandler(
                DummyOutputStream(),
                object : java.util.logging.Formatter() {

                    val date = Date()
                    val format = "%1\$tF %1\$tT %3\$s: [%2\$s] %4\$s%5\$s%n"

                    override fun format(record: LogRecord): String {
                        date.time = record.millis

                        var source: String
                        if (record.sourceClassName != null) {
                            source = record.sourceClassName
                            if (record.sourceMethodName != null) {
                                source += "#" + record.sourceMethodName
                            }
                        } else {
                            source = record.loggerName
                        }

                        var throwable = ""
                        if (record.thrown != null) {
                            val sw = StringWriter()
                            val pw = PrintWriter(sw)
                            pw.println()
                            record.thrown.printStackTrace(pw)
                            pw.close()
                            throwable = sw.toString()
                            sw.close()
                        }

                        return format.format(date, source, record.level.localizedName, formatMessage(record), throwable)
                    }
                }).apply {
            level = Level.FINEST

        }

        var cumulativeNanos = 0L
        val iterations = 200_000

        println("Testing with $iterations iterations and String...")
        val logger = Logger.getLogger("StringLogger")
        logger.useParentHandlers = false
        logger.handlers.forEach { logger::removeHandler }
        logger.addHandler(logHandler)

        logger.info("")

        for (i in 0..iterations) {
            val start = System.nanoTime()
            logger.info("iteration $i")
            cumulativeNanos += System.nanoTime() - start
        }

        println("$iterations iterations took ${Duration.ofNanos(cumulativeNanos)}")
    }

    @Test
    fun SpeedTestCurrent() {
        val logHandler = StreamHandler(
                DummyOutputStream(),
                LogFormatter()).apply {
            level = Level.FINEST

        }

        var cumulativeNanos = 0L
        val iterations = 200_000

        println("Testing with $iterations iterations and current implementation...")
        val logger = Logger.getLogger("StringBuilderLogger")
        logger.useParentHandlers = false
        logger.handlers.forEach { logger::removeHandler }
        logger.addHandler(logHandler)

        logger.info("")

        for (i in 0..iterations) {
            val start = System.nanoTime()
            logger.info("iteration $i")
            cumulativeNanos += System.nanoTime() - start
        }

        println("$iterations iterations took ${Duration.ofNanos(cumulativeNanos)}")
    }
}

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