package bridge

class Command(private val execution: String) {
    init {
        require(isLetter()) { ErrorType.COMMAND_LETTER.errorMessage }
        require(isUpperCaese()) { ErrorType.COMMAND_UPPER.errorMessage }
        require(isLength()) { ErrorType.COMMAND_LENGTH.errorMessage }
        require(isRightCommand()) { ErrorType.COMMAND.errorMessage }
    }

    private fun isLetter(): Boolean =
        execution.all { char -> char.isLetter() }

    private fun isUpperCaese(): Boolean =
        execution.all { char -> char.isUpperCase() }

    private fun isLength(): Boolean =
        execution.length == COMMAND_LENGTH

    private fun isRightCommand(): Boolean =
        execution == RESTART || execution ==QUIT

    companion object {
        const val COMMAND_LENGTH = 1
        const val RESTART = "R"
        const val QUIT = "Q"
    }
}