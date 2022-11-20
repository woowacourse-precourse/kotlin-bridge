package bridge

import bridge.view.OutputView.throwException

object InputValidator {
    fun checkBridgeLength(input: String) {
        checkIsNotBlank(input)
        checkIsNumber(input)
        checkStartsWithZero(input)
        checkIsInRange(input)
    }

    fun checkMoveDirection(input: String) {
        checkIsNotBlank(input)
        checkIsUpOrDown(input)
    }

    private fun checkIsNotBlank(input: String) {
        if (input.isBlank()) throwException(NO_INPUT)
    }

    private fun checkIsNumber(input: String) {
        input.map {
            if (!(it.isDigit())) throwException(INCLUDE_CHARACTER)
        }
    }

    private fun checkStartsWithZero(input: String) {
        if (input[0] == '0') throwException(START_WITH_ZERO)
    }

    private fun checkIsInRange(input: String) {
        if (input.toInt() !in (RANGE_LOWER_BOUND..RANGE_UPPER_BOUND))
            throwException(NOT_IN_RANGE)
    }

    private fun checkIsUpOrDown(direction: String) {
        if (!(listOf(UP, DOWN).contains(direction))) throwException(ENTER_U_OR_D)
    }
}