package bridge.util

import bridge.constants.ErrorMessage

fun String.toIntOrThrow(): Int {
    return requireNotNull(toIntOrNull()) { ErrorMessage.InvalidNumberFormat }
}