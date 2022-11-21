package bridge.domain.error

import bridge.domain.error.ErrorType.Companion.makeError
import bridge.domain.resource.*

object ErrorCheck {
    fun checkIsInteger(value: String?) {
        try {
            value!!.toInt()
        } catch (e: Exception) {
            makeError(ErrorType.NOT_INTEGER)
        }
    }

    fun checkInRange(value: Int) {
        if (value < RANGE_START || value > RANGE_END) {
            makeError(ErrorType.OUT_OF_RANGE)
        }
    }

    fun checkValidMovement(move: String) {
        val option = listOf(MOVE_UP, MOVE_DOWN)

        if (!option.contains(move)) {
            makeError(ErrorType.INVALID_OPTION)
        }
    }

    fun checkValidCommand(restart: String) {
        val option = listOf(GAME_RESTART, GAME_END)

        if (!option.contains(restart)) {
            makeError(ErrorType.INVALID_OPTION)
        }
    }
}