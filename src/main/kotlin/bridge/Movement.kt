package bridge

class Movement(private val direction: String) {
    init {
        require(isLetter()) { ErrorType.DIRECTION_LETTER.errorMessage }
    }

    private fun isLetter(): Boolean =
        direction.all { char -> char.isLetter() }
}