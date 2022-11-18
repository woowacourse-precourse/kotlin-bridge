package bridge

class CommandException(private val message: String, private val key: String) {

    init {
        require(isEmpty()) { ERROR.format(ErrorType.EMPTY.errorMessage) }
        require(isLetter()) { ERROR.format(message + ErrorType.LETTER.errorMessage) }
        require(isUpperCaese()) { ERROR.format(message + ErrorType.UPPER.errorMessage) }
        require(isLength()) { ERROR.format(message + ErrorType.LENGTH.errorMessage) }
    }

    private fun isLetter(): Boolean =
        key.all { char -> char.isLetter() }

    private fun isUpperCaese(): Boolean =
        key.all { char -> char.isUpperCase() }

    private fun isLength(): Boolean =
        key.length == ONE

    private fun isEmpty(): Boolean =
        key.isNotEmpty() || key.length > ZERO

    companion object {
        const val ZERO = 0
        const val ONE = 1
    }
}