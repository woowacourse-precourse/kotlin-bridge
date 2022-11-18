package bridge.validator

object InputValidator {
    fun validateBridgeSize(input: Int) {
        val hasInvalidBridgeSize = (input < 3 || input > 20)
        if (hasInvalidBridgeSize) throw IllegalArgumentException()
    }
}