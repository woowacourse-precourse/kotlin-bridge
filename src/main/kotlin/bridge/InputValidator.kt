package bridge

object InputValidator {

    fun validateBridgeInput(bridgeSize: String) {
        validateNumericInput(bridgeSize)
        validateBridgeSize(bridgeSize.toInt())
    }

    fun validateMoveInput(direction: String) {
        require(direction.isUpOrDown()){
            println(Error.MOVE_INPUT_ERROR.errorMessage)
        }
    }

    private fun validateBridgeSize(bridgeSize: Int) =
        require(bridgeSize.isInRange()) {
            println(Error.BRIDGE_RANGE_ERROR.errorMessage)
        }

    private fun validateNumericInput(input: String) {
        require(input.isNumeric()) {
            println(Error.NUMERIC_ERROR.errorMessage)
        }
    }

    private fun String.isUpOrDown() = this == "U" || this == "D"

    private fun Int.isInRange() = this in 3..20

    private fun String.isNumeric() =
        this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }

}