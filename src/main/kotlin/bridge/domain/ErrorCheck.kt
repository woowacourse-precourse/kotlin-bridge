package bridge.domain

import bridge.domain.ErrorType.Companion.makeError

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
}