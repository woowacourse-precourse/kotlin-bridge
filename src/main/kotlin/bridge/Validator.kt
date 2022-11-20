package bridge

import bridge.constants.BridgeSize
import bridge.constants.Error

class Validator {
    fun isNumber(input: String): Boolean {
        if (!input.all { Character.isDigit(it) }) {
            OutputView().printErrorMessage(Error.BRIDGE_INPUT.message)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateBridgeSize(input: String): Boolean {
        val size = input.toInt()
        if (size < BridgeSize.START.size || size > BridgeSize.END.size) {
            OutputView().printErrorMessage(Error.BRIDGE_INPUT.message)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateUpAndDown(input: String): Boolean {
        if (input != "U" && input != "D") {
            OutputView().printErrorMessage(Error.MOVE_INPUT.message)
            throw IllegalArgumentException()
        }
        return true
    }

    fun validateRetryAndQuit(input: String): Boolean {
        if (input != "R" && input != "Q") {
            OutputView().printErrorMessage(Error.RETRY_OR_QUIT.message)
            throw IllegalArgumentException()
        }
        return true
    }
}