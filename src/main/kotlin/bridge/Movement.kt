package bridge

class Movement(private val direction: String) {
    init {
        require(isLetter()) { ErrorType.DIRECTION_LETTER.errorMessage }
        require(isUpperCaese()) { ErrorType.DIRECTION_UPPER.errorMessage }
        require(isLength()) { ErrorType.DIRECTION_LENGTH.errorMessage }
        require(isRightDirection()) { ErrorType.DIRECTION.errorMessage }
    }

    private fun isLetter(): Boolean =
        direction.all { char -> char.isLetter() }

    private fun isUpperCaese(): Boolean =
        direction.all { char -> char.isUpperCase() }

    private fun isLength(): Boolean =
        direction.length == DIRECTION_LENGTH

    private fun isRightDirection(): Boolean =
        direction == UP || direction == DOWN

    companion object {
        const val DIRECTION_LENGTH = 1
        const val UP = "U"
        const val DOWN = "D"
    }
}