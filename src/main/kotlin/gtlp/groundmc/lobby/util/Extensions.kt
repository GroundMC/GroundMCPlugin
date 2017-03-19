package gtlp.groundmc.lobby.util

import java.util.logging.Logger
import kotlin.reflect.KClass


fun Logger.exiting(kClass: KClass<*>, sourceMethod: String) {
    exiting(kClass.qualifiedName, sourceMethod)
}

fun Logger.entering(kClass: KClass<*>, sourceMethod: String) {
    entering(kClass.qualifiedName, sourceMethod)
}

val Int.megabytes: Int
    get() = this * 1024.kilobytes

val Int.kilobytes: Int
    get() = this * 1024