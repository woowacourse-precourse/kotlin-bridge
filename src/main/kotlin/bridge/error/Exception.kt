package bridge.error

import bridge.error.ErrorMessage.ERROR_NOT_NUMBERS
import bridge.error.ErrorMessage.ERROR_NOT_RETRY_QUIT
import bridge.error.ErrorMessage.ERROR_NOT_UP_DOWN
import bridge.error.ErrorMessage.ERROR_NO_GAME
import bridge.error.ErrorMessage.ERROR_NUM_NOT_IN_RANGE

object Exception {
    fun String.inputTypeException(): Int {
        try {
            return this.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_NOT_NUMBERS)
        }
    }

    fun Int.inputRangeException() {
        require(this in 3..20) { ERROR_NUM_NOT_IN_RANGE }
    }

    fun Int.inputNoGameException() {
        require(this > 0) { ERROR_NO_GAME }
    }

    fun String.inputUpDownException() {
        require(this in listOf("U", "D")) { ERROR_NOT_UP_DOWN }
    }

    fun String.inputRetryQuitException() {
        require(this in listOf("R", "Q")) { ERROR_NOT_RETRY_QUIT }
    }
}