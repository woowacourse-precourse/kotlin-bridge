package bridge

class Command(private val execution: String) {
    init {
        CommandException(COMMAND, execution)
        require(isRightCommand()) { ERROR.format(COMMAND + ErrorType.COMMAND.errorMessage) }
    }

    private fun isRightCommand(): Boolean =
        execution == RESTART || execution == QUIT

    companion object {
        const val RESTART = "R"
        const val QUIT = "Q"
    }
}