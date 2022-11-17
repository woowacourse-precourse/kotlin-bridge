package bridge.util

object Validator {
    fun validateIsNumber(value: String) {
        requireNotNull(value.toIntOrNull()) { BRIDGE_LENGTH_NOT_NUMBER_EXCEPTION_MESSAGE }
    }

    fun validateRange(value: Int, start: Int = 3, end: Int = 20) {
        require(value in start..end) { BRIDGE_LENGTH_OUT_OF_RANGE_EXCEPTION_MESSAGE }
    }
}