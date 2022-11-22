package bridge

import bridge.Constans.DOWN
import bridge.Constans.ENTER_R_OR_Q
import bridge.Constans.ENTER_U_OR_D
import bridge.Constans.INCLUDE_CHARACTER
import bridge.Constans.NOT_IN_RANGE
import bridge.Constans.NO_INPUT
import bridge.Constans.QUIT
import bridge.Constans.RANGE_LOWER_BOUND
import bridge.Constans.RANGE_UPPER_BOUND
import bridge.Constans.RETRY
import bridge.Constans.START_WITH_ZERO
import bridge.Constans.UP
import bridge.view.OutputView.throwIllegalException
import bridge.view.OutputView.throwNumberException

object InputValidator {
    fun checkBridgeLength(input: String) {
        checkIsNotBlank(input)
        checkIsNumber(input)
        checkIsInRange(input)
        checkStartsWithZero(input)
    }

    fun checkMoveDirection(input: String) {
        checkIsNotBlank(input)
        checkIsUpOrDown(input)
    }

    fun checkRetryOrQuit(command: String) {
        checkIsNotBlank(command)
        checkIsRetryOrQuit(command)
    }

    private fun checkIsNotBlank(input: String) {
        if (input.isBlank()) throwIllegalException(NO_INPUT)
    }

    private fun checkIsNumber(input: String) {
        input.map {
            if (!(it.isDigit())) throwNumberException(INCLUDE_CHARACTER)
        }
    }

    private fun checkStartsWithZero(input: String) {
        if (input[0] == '0') throwIllegalException(START_WITH_ZERO)
    }

    private fun checkIsInRange(input: String) {
        if (input.toInt() !in (RANGE_LOWER_BOUND..RANGE_UPPER_BOUND))
            throwIllegalException(NOT_IN_RANGE)
    }

    private fun checkIsUpOrDown(direction: String) {
        if (!(listOf(UP, DOWN).contains(direction))) throwIllegalException(ENTER_U_OR_D)
    }

    private fun checkIsRetryOrQuit(command: String) {
        if (!(listOf(QUIT, RETRY).contains(command))) throwIllegalException(ENTER_R_OR_Q)
    }
}