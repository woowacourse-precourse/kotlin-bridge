package bridge.ui

import bridge.data.ERROR_DIGIT
import bridge.data.ERROR_DIRECTION
import bridge.data.ERROR_NULL
import bridge.data.ERROR_RANGE

class InputChecker {
    fun checkBridgeLength(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!isNumber(input)) throw IllegalArgumentException(ERROR_DIGIT)
        if (input.toInt() !in 3..20) throw java.lang.IllegalArgumentException(ERROR_RANGE)
    }

    fun checkDirection(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!((input == "U") or (input == "D"))) throw IllegalArgumentException(ERROR_DIRECTION)
    }

    private fun isNumber(input: String): Boolean {
        return if (input.isEmpty()) false else input.all { Character.isDigit(it) }
    }
}