package bridge.util

import bridge.QUIT_INPUT
import bridge.RETRY_INPUT
import bridge.model.data.Direction

class InputValidator {

    fun validateBridgeInput(bridgeSize: String) {
        validateNumericInput(bridgeSize)
        validateBridgeSize(bridgeSize.toInt())
    }

    fun validateMoveInput(direction: String) {
        require(direction.isUpOrDown()) {
            Error.MOVE_INPUT_ERROR.errorMessage
        }
    }

    fun validateRetryFlag(retryFlag: String) {
        require(retryFlag.isRetryOrQuit()) {
            Error.RETRY_FLAG_ERROR.errorMessage
        }
    }

    private fun validateBridgeSize(bridgeSize: Int) {
        require(bridgeSize.isInRange()) {
            Error.BRIDGE_SIZE_ERROR.errorMessage
        }
    }

    private fun validateNumericInput(input: String) {
        require(input.isNumeric()) {
            Error.NUMERIC_ERROR.errorMessage
        }
    }

    private fun String.isRetryOrQuit() = this == RETRY_INPUT || this == QUIT_INPUT

    private fun String.isUpOrDown() = this == Direction.UP.direction || this == Direction.DOWN.direction

    private fun Int.isInRange() = this in MINIMUM_BRIDGE_SIZE..MAXIMUM_BRIDGE_SIZE

    private fun String.isNumeric() =
        this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }

    companion object {
        const val MINIMUM_BRIDGE_SIZE = 3
        const val MAXIMUM_BRIDGE_SIZE = 20
    }
}