package bridge.validator

import bridge.util.DOWN_MOVE_STRING
import bridge.util.ERROR_INVALID_MOVE_MESSAGE
import bridge.util.ERROR_INVALID_SIZE_MESSAGE
import bridge.util.UP_MOVE_STRING

object InputValidator {
    fun validateInValidBridgeSize(input: Int) {
        val hasInvalidBridgeSize = (input < 3 || input > 20)
        if (hasInvalidBridgeSize) throw IllegalArgumentException()
    }

    fun validateBridgeSize(): Int {
        while (true) {
            try {
                val bridgeSize = readLine()!!.toInt()
                validateInValidBridgeSize(bridgeSize)
                return bridgeSize
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_SIZE_MESSAGE)
                continue
            }
        }
    }

    fun validateInvalidMoveInput(input: String) {
        val hasInvalidMoveInput = (input != UP_MOVE_STRING && input != DOWN_MOVE_STRING)
        if (hasInvalidMoveInput) throw IllegalArgumentException()
    }

    fun validateMoveInput(): String {
        while (true) {
            try {
                val moveInput = readLine()!!
                validateInvalidMoveInput(moveInput)
                return moveInput
            } catch (e: IllegalArgumentException) {
                println(ERROR_INVALID_MOVE_MESSAGE)
                continue
            }
        }
    }
}