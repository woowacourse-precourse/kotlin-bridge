package bridge.util

import bridge.common.ErrorMessage

fun String.toIntOrThrow(): Int {
    return requireNotNull(toIntOrNull()) { ErrorMessage.InvalidNumberFormat }
}