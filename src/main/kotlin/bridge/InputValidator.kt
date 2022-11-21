package bridge

class InputValidator {

    fun validateBridgeInput(bridgeSize: String) {
        validateNumericInput(bridgeSize)
        validateBridgeSize(bridgeSize.toInt())
    }

    fun validateMoveInput(direction: String)  {
        require(direction.isUpOrDown()){
            Error.MOVE_INPUT_ERROR.errorMessage
        }
    }

    fun validateRetryFlag(retryFlag: String){
        require(retryFlag.isRetryOrQuit()){
            Error.RETRY_FLAG_ERROR.errorMessage
        }
    }

    private fun validateBridgeSize(bridgeSize: Int) {
        require(bridgeSize.isInRange()){
            Error.BRIDGE_SIZE_ERROR.errorMessage
        }
    }

    private fun validateNumericInput(input: String) {
        require(input.isNumeric()){
            Error.NUMERIC_ERROR.errorMessage
        }
    }

    private fun String.isRetryOrQuit() = this == "R" || this == "Q"

    private fun String.isUpOrDown() = this == "U" || this == "D"

    private fun Int.isInRange() = this in 3..20

    private fun String.isNumeric() =
        this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
}