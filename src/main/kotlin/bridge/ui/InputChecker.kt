package bridge.ui

import bridge.data.*

class InputChecker {
    fun checkBridgeLength(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!isNumber(input)) throw IllegalArgumentException(ERROR_DIGIT)
        if (input.toInt() !in THREE..TWENTY) throw java.lang.IllegalArgumentException(ERROR_RANGE)
    }

    fun checkDirection(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!((input == UP) or (input == DOWN))) throw IllegalArgumentException(ERROR_DIRECTION)
    }

    fun checkUserCommand(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException(ERROR_NULL)
        if (!((input == RETRY) or (input == QUIT))) throw IllegalArgumentException(ERROR_COMMAND)
    }

    private fun isNumber(input: String): Boolean {
        return if (input.isEmpty()) false else input.all { Character.isDigit(it) }
    }
}