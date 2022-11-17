package bridge

class BridgeNumber(private val size: String) {
    init {
        require(isNumberRange()) { ErrorType.LENGTH.errorMessage }
    }

    private fun isNumberRange(): Boolean =
        size.toInt() !in MIN_LENGTH..MAX_LENGTH

    companion object {
        const val MIN_LENGTH = 3
        const val MAX_LENGTH = 20
    }
}