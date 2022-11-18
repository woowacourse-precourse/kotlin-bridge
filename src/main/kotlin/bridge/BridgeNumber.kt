package bridge

class BridgeNumber(private val size: String) {
    init {
        require(isEmtpy()) { ERROR.format(ErrorType.EMPTY.errorMessage) }
        require(isNumber()) { ERROR.format(BRIDGE + ErrorType.NUMBER.errorMessage) }
        require(isNumberRange()) { ERROR.format(BRIDGE + ErrorType.RANGE.errorMessage) }
    }

    private fun isNumberRange(): Boolean =
        size.toInt() in MIN_LENGTH..MAX_LENGTH

    private fun isNumber(): Boolean =
        size.all { char -> char.isDigit() }

    private fun isEmtpy(): Boolean =
        size.isNotEmpty() || size.length > 0

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20
    }
}