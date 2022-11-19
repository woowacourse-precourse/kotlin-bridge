package bridge.util.validator

import bridge.util.*

object Validator {
    fun validateIsNumber(value: String) {
        requireNotNull(value.toIntOrNull()) { BRIDGE_LENGTH_NOT_NUMBER_EXCEPTION_MESSAGE }
    }

    fun validateRange(value: Int, start: Int = 3, end: Int = 20) {
        require(value in start..end) { BRIDGE_LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE }
    }

    fun validateDirection(direction: String) {
        require(direction == UP || direction == DOWN) { INVALID_DIRECTION_EXCEPTION_MESSAGE }
    }

    fun validateRetrial(retry: String) {
        require(retry == RETRIAL || retry == QUIT) { INVALID_RETRIAL_EXCEPTION_MESSAGE }
    }
}