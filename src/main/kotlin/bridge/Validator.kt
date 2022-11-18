package bridge

import bridge.constants.*

class Validator {
    fun isNumber(input: String): Boolean {
        if (!input.all { Character.isDigit(it) }) {
            OutputView().printErrorMessage(ERROR_BRIDGE_INPUT)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateBridgeSize(input: String): Boolean {
        val size = input.toInt()
        if (size < 3 || size > 20) {
            OutputView().printErrorMessage(ERROR_BRIDGE_INPUT)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateUpAndDown(input: String): Boolean {
        if (input != "U" && input != "D") {
            OutputView().printErrorMessage(ERROR_MOVE_INPUT)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateRetryAndQuit(input: String): Boolean {
        if (input != "R" && input != "Q") {
            OutputView().printErrorMessage(ERROR_RETRY_OR_QUIT)
            throw IllegalArgumentException()
        }
        return true
    }
}