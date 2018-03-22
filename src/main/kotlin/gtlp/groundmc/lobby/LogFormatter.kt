/*
 *     groundmc-plugin
 *     Copyright (C) 2018  GroundMC Network
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *     Contact:
 *     GiantTree
 *     GroundMC Network
 *     gianttree@groundmc.net
 */

package gtlp.groundmc.lobby

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
    val date = Date()

    /**
     * The format string used by this [Formatter].
     */
    val format = "%1\$tF %1\$tT %3\$s: [%2\$s] %4\$s%5\$s%n"

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
