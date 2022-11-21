package bridge.utils

import bridge.resources.ERROR_INPUT_NUMBER

fun String.toIntOrError(): Int {
    require(this.toIntOrNull() != null) { ERROR_INPUT_NUMBER }
    return this.toInt()
}

fun String.toIntInRangeOrError(min: Int, max: Int): Int {
    this.toIntOrError().let {
        if (it !in min..max) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER)
        }
        return it
    }
}

fun String.toInListOrError(
    list: List<String>,
    errorMessage: String
): String {
    require(this in list) { errorMessage }
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
