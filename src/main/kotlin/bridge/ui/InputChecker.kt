package bridge.ui

import bridge.data.ERROR_DIGIT
import bridge.data.ERROR_NULL
import bridge.data.ERROR_RANGE

class InputChecker {
    fun except(size: String) {
        if (size.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!isNumber(size)) throw IllegalArgumentException(ERROR_DIGIT)
        if (size.toInt() !in 3..20) throw java.lang.IllegalArgumentException(ERROR_RANGE)
    }

    fun isNumber(input: String): Boolean {
        return if (input.isNullOrEmpty()) false else input.all { Character.isDigit(it) }
    }
}