package bridge

import bridge.constants.ERROR_BRIDGE_INPUT

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
}