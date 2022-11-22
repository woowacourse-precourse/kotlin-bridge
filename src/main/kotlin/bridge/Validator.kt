package bridge

import bridge.constants.BridgeSize
import bridge.constants.Error

class Validator {
    fun validateBridgeSize(input: String) {
        isNumber(input)
        validateRange(input)
    }

    private fun isNumber(input: String) {
        if (!input.all { Character.isDigit(it) }) {
            OutputView().printErrorMessage(Error.BRIDGE_INPUT.message)
            throw IllegalArgumentException()
        }
    }

    private fun validateRange(input: String) {
        val size = input.toInt()
        if (size < BridgeSize.START.size || size > BridgeSize.END.size) {
            OutputView().printErrorMessage(Error.BRIDGE_INPUT.message)
            throw IllegalArgumentException()
        }
    }

    fun validateUpAndDown(input: String) {
        if (input != "U" && input != "D") {
            OutputView().printErrorMessage(Error.MOVE_INPUT.message)
            throw IllegalArgumentException()
        }
    }

    fun validateRetryAndQuit(input: String) {
        if (input != "R" && input != "Q") {
            OutputView().printErrorMessage(Error.RETRY_OR_QUIT.message)
            throw IllegalArgumentException()
        }
    }
}