package bridge.view

import bridge.common.GameCommand
import bridge.common.UpDown

private const val RANGE_STARTING_POINT = 3
private const val RANGE_END_POINT = 20

class InputValidator {
    fun checkBridgeSizeInputValid(input: String) {
        isNumber(input)
        isNumberInRange(input.toInt())
    }

    private fun isNumber(input: String) {
        if (!input.all { Character.isDigit(it) }) {
            throwException(NOT_NUMBER)
        }
    }

    private fun isNumberInRange(number: Int) {
        if (number !in RANGE_STARTING_POINT..RANGE_END_POINT) {
            throwException(NUMBER_NOT_IN_RANGE)
        }
    }

    private fun throwException(message: String) {
        throw IllegalArgumentException(message)
    }

    fun checkMovingInputValid(input: String) {
        UpDown.values().forEach {
            if (input == it.name) return
        }
        throwException(INVALID_DIRECTION)
    }

    fun checkGameCommandValid(input: String): GameCommand {
        return GameCommand.inGameCommand(input)
    }

    companion object {
        const val NUMBER_NOT_IN_RANGE = "[ERROR] 다리 길이가 범위 밖입니다."
        const val NOT_NUMBER = "[ERROR] 숫자가 아닙니다."
        const val INVALID_DIRECTION = "[ERROR] 잘못된 방향입니다"
    }
}
