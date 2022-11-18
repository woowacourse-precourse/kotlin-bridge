package bridge

class Command(private val execution: String) {
    init {
        require(isLetter()) { ErrorType.COMMAND_LETTER.errorMessage }
    }

    private fun isLetter(): Boolean =
        execution.all { char -> char.isLetter() }
}