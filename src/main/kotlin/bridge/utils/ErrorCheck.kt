package bridge.utils

import bridge.resources.ERROR_INPUT_NUMBER

fun String.toIntOrError(): Int {
    require(this.toIntOrNull() != null) { ERROR_INPUT_NUMBER }
    return this.toInt()
}

fun String.isInListOrError(
    list: List<String>,
    errorMessage: String
): String {
    require(this in list) { errorMessage }
    return this
}
