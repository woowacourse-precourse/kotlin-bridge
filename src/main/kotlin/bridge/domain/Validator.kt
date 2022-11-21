package bridge.domain

import bridge.util.ErrorMessage.ERROR_NOT_VALID_COMMAND
import bridge.util.ErrorMessage.ERROR_NOT_VALID_NUMBER
import java.lang.IllegalArgumentException

object Validator {

    fun isValidBridgeSize(input: String): Int {
        val regex = Regex("^[3-9]\$|^1[0-9]\$|^20\$")
        if (!input.matches(regex)) {
            throw IllegalArgumentException(ERROR_NOT_VALID_NUMBER)
        }

        return input.toInt()
    }

    fun isValidMoving(input: String): String {
        if (!(input == Command.UP.value() || input == Command.DOWN.value())) {
            throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
        }

        return input
    }

    fun isValidRetryCommand(input: String): String {
        if (!(input == Command.RETRY.value() || input == Command.QUIT.value())) {
            throw IllegalArgumentException(ERROR_NOT_VALID_COMMAND)
        }

        return input
    }
}
