package bridge

class Command(private val execution: String) {
    init {
        require(isLetter()) { ErrorType.COMMAND_LETTER.errorMessage }
        require(isUpperCaese()) { ErrorType.COMMAND_UPPER.errorMessage }
        require(isLength()) { ErrorType.COMMAND_LENGTH.errorMessage }
    }

    private fun isLetter(): Boolean =
        execution.all { char -> char.isLetter() }

    private fun isUpperCaese(): Boolean =
        execution.all { char -> char.isUpperCase() }

    private fun isLength(): Boolean =
        execution.length == COMMAND_LENGTH

    companion object {
        const val COMMAND_LENGTH = 1
    }
}