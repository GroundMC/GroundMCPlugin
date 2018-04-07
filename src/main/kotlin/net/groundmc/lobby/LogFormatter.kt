package net.groundmc.lobby

import java.io.PrintWriter
import java.io.StringWriter
import java.util.*
import java.util.logging.Formatter
import java.util.logging.LogRecord
import java.util.logging.SimpleFormatter

/**
 * A custom [Formatter] for log files.
 * Inspired by [SimpleFormatter]
 */
class LogFormatter : Formatter() {

    /**
     * A value of [Date].
     * It is more efficient to set the date every time than to construct a new
     * [Date] object.
     */
    private val date = Date()

    /**
     * The format string used by this [Formatter].
     */
    private val format = "%1\$tF %1\$tT %3\$s: [%2\$s] %4\$s%5\$s%n"

    /**
     * Format the given log record and return the formatted string.
     * <p>
     * The resulting formatted String will normally include a
     * localized and formatted version of the LogRecord's message field.
     * It is recommended to use the [Formatter.formatMessage]
     * convenience method to localize and format the message field.
     *
     * @param record the log record to be formatted.
     * @return the formatted log record
     */
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
