package bridge.common

import bridge.constants.ErrorMessages

fun String.toIntOrThrow(): Int {
    return requireNotNull(toIntOrNull()) { ErrorMessages.Common.InvalidNumberFormat }
}