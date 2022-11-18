package bridge.validator

import bridge.util.ERROR_INVALID_INPUT_MESSAGE

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

    fun validateInvalidMoveInput(input: String) {
        val hasInvalidMoveInput = (input != "U" && input != "D")
        if (hasInvalidMoveInput) throw IllegalArgumentException()
    }

    fun validateMoveInput(): String {
        while (true) {
            try {
                val moveInput = readLine()!!
                validateInvalidMoveInput(moveInput)
                return moveInput
            } catch (e: IllegalArgumentException) {
                println("[ERROR] U와 D만 이동 입력이 가능합니다.")
                continue
            }
        }

    }

}