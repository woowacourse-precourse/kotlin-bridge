package bridge.utils

import bridge.resources.ERROR_INPUT_NUMBER

fun String.toIntOrError(): Int {
    require(this.toIntOrNull() != null) { ERROR_INPUT_NUMBER }
    return this.toInt()
}
