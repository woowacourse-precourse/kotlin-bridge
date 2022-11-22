package bridge.exceptions

import bridge.exceptions.ErrorMessage.ERROR
import bridge.exceptions.ErrorMessage.ILLEGAL_BRIDGE_SIZE_RANGE
import bridge.exceptions.ErrorMessage.ILLEGAL_MOVE_KEY
import bridge.exceptions.ErrorMessage.ILLEGAL_RESTART_KEY
import bridge.exceptions.ErrorMessage.ONLY_INPUT_NUMBER


object InputExceptions {
    fun validateBridgeSize(input: String) {
        validateStringToNumber(input)
        if (input.toInt() !in 3..20) {
            throw IllegalArgumentException(ERROR + ILLEGAL_BRIDGE_SIZE_RANGE)
        }
    }

    private fun validateStringToNumber(number: String) {
        try {
            number.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException(ERROR + ONLY_INPUT_NUMBER)
        }
    }

    fun validateInputMove(input: String) {
        if (input == "U" || input == "D") {
            return
        }
        throw IllegalArgumentException(ERROR + ILLEGAL_MOVE_KEY)
    }

    fun validateInputRestart(input: String) {
        if (input == "R" || input == "Q") {
            return
        }
        throw IllegalArgumentException(ERROR + ILLEGAL_RESTART_KEY)
    }
}