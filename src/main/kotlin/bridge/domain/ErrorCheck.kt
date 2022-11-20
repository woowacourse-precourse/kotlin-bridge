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
}