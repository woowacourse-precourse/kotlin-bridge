package bridge.validator

import bridge.ERROR_INVALID_INPUT_MESSAGE

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
                println(ERROR_INVALID_INPUT_MESSAGE)
                continue
            }
        }
    }
}