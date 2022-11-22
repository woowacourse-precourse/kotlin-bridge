package bridge.domain

import bridge.COMMAND
import bridge.utils.CommandException
import bridge.ERROR
import bridge.utils.ErrorType
import bridge.utils.QUIT
import bridge.utils.RETRY

class Command(private val execution: String) {
    init {
        CommandException(COMMAND, execution)
        require(isRightCommand()) { ERROR.format(COMMAND + ErrorType.COMMAND.errorMessage) }
    }

    private fun isRightCommand(): Boolean =
        execution == RETRY || execution == QUIT
}