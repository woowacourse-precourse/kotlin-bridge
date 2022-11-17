package bridge

class BridgeNumber(private val size: String) {
    init {
        require(isNumberRange()) { ErrorType.LENGTH.errorMessage }
        require(isNumber()) { ErrorType.NUMBER.errorMessage }
        require(isEmtpy()) { ErrorType.EMPTY.errorMessage }
    }

    private fun isNumberRange(): Boolean =
        size.toInt() !in MIN_LENGTH..MAX_LENGTH

    private fun isNumber(): Boolean =
        size.any { char -> char.isLetter() }

    private fun isEmtpy(): Boolean =
        size.isEmpty() || size.equals("")

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20
    }
}