package bridge.utils

import bridge.resources.ERROR_INPUT_ALLOWED_KEYS
import bridge.resources.ERROR_INPUT_NUMBER
import bridge.resources.ERROR_INPUT_NUMBER_IN_RANGE

fun String.toIntOrError(): Int {
    require(this.toIntOrNull() != null) { ERROR_INPUT_NUMBER }
    return this.toInt()
}

fun String.toIntInRangeOrError(min: Int, max: Int): Int {
    this.toIntOrError().let {
        require(it in min..max) { ERROR_INPUT_NUMBER_IN_RANGE }
        return it
    }
}

fun String.toInListOrError(
    list: List<String>
): String {
    require(this in list) { ERROR_INPUT_ALLOWED_KEYS }
    return this
}

inline fun <T> infinityRead(call: () -> T): T {
    while (true) {
        try {
            return call()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
