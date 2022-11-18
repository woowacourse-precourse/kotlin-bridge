package bridge

class Command(private val execution: String) {
    init {
        require(isLetter()) { ErrorType.COMMAND_LETTER.errorMessage }
        require(isUpperCaese()) { ErrorType.COMMAND_UPPER.errorMessage }
    }

    private fun isLetter(): Boolean =
        execution.all { char -> char.isLetter() }

    private fun isUpperCaese(): Boolean =
        execution.all { char -> char.isUpperCase() }
}