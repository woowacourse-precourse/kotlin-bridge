package bridge.common

import bridge.constants.ErrorMessage

fun String.toIntOrThrow(): Int {
    return requireNotNull(toIntOrNull()) { ErrorMessage.InvalidNumberFormat }
}

fun println(format: String, vararg args: Any?) {
    kotlin.io.println(String.format(format, *args))
}

fun println(format: Any, vararg args: Any?) {
    kotlin.io.println(String.format(format.toString(), *args))
}