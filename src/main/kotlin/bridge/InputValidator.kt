package bridge

class InputValidator {

    fun validateBridgeInput(bridgeSize: String): Error {
        var error = Error.NO_ERROR

        when {
            validateNumericInput(bridgeSize) != Error.NO_ERROR -> error = Error.NUMERIC_ERROR
            validateBridgeSize(bridgeSize.toInt()) != Error.NO_ERROR -> error = Error.BRIDGE_SIZE_ERROR
        }
        return error
    }

    fun validateMoveInput(direction: String) = if (direction.isUpOrDown()) {
        Error.NO_ERROR
    } else {
        Error.MOVE_INPUT_ERROR
    }

    fun validateRetryFlag(retryFlag: String) = if (retryFlag.isRetryOrQuit()) {
        Error.NO_ERROR
    } else {
        Error.MOVE_INPUT_ERROR
    }

    private fun validateBridgeSize(bridgeSize: Int) = if (bridgeSize.isInRange()) {
        Error.NO_ERROR
    } else {
        Error.BRIDGE_SIZE_ERROR
    }

    private fun validateNumericInput(input: String) = if (input.isNumeric()) {
        Error.NO_ERROR
    } else {
        Error.NUMERIC_ERROR
    }

    private fun String.isRetryOrQuit() = this == "R" || this == "Q"

    private fun String.isUpOrDown() = this == "U" || this == "D"

    private fun Int.isInRange() = this in 3..20

    private fun String.isNumeric() =
        this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
}