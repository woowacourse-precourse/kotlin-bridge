package bridge

class Movement(private val direction: String) {
    init {
        require(isLetter()) { ErrorType.DIRECTION_LETTER.errorMessage }
        require(isUpperCaes()) { ErrorType.DIRECTION_UPPER.errorMessage }
    }

    private fun isLetter(): Boolean =
        direction.all { char -> char.isLetter() }

    private fun isUpperCaes(): Boolean =
        direction.all { char -> char.isUpperCase() }
}