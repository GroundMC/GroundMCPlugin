package gtlp.groundmc.lobby

import java.io.PrintWriter
import java.io.StringWriter
import java.util.*
import java.util.logging.Formatter
import java.util.logging.LogRecord

class LogFormatter : Formatter() {

    val date = Date()
    val format = "%1\$tF %1\$tT %3\$s: [%2\$s] %4\$s%5\$s%n"

    override fun format(record: LogRecord): String {
        date.time = record.millis

        val source = StringBuffer()
        if (record.sourceClassName != null) {
            source.append(record.sourceClassName)
            if (record.sourceMethodName != null) {
                source.append('#')
                source.append(record.sourceMethodName)
            }
        } else {
            source.append(record.loggerName)
        }

        val throwable = StringBuffer()
        if (record.thrown != null) {
            val sw = StringWriter()
            val pw = PrintWriter(sw)
            pw.println()
            record.thrown.printStackTrace(pw)
            pw.close()
            throwable.append(sw)
            sw.close()
        }

        return format.format(date, source, record.level.localizedName, formatMessage(record), throwable)
    }
}