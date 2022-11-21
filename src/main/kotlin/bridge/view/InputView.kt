package bridge.view

import bridge.common.GameCommand
import bridge.common.UpDown
import camp.nextstep.edu.missionutils.Console.readLine

private const val NUMBER_NOT_IN_RANGE = "[ERROR] 다리 길이가 범위 밖입니다."
private const val NOT_NUMBER = "[ERROR] 숫자가 아닙니다."
private const val INVALID_DIRECTION = "[ERROR] 잘못된 방향입니다"

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val bridgeSize = readLine()
        checkBridgeSizeInputValid(bridgeSize)
        return bridgeSize.toInt()
    }

    private fun checkBridgeSizeInputValid(input: String) {
        isNumber(input)
        isNumberInRange(input.toInt())
    }

    private fun isNumber(input: String) {
        if (!input.all { Character.isDigit(it) }) {
            throwException(NOT_NUMBER)
        }
    }

    private fun isNumberInRange(number: Int) {
        if (number !in 3..20) {
            throwException(NUMBER_NOT_IN_RANGE)
        }
    }

    private fun throwException(message: String) {
        throw IllegalArgumentException(message)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val direction = readLine()
        checkMovingInputValid(direction)
        return direction
    }

    private fun checkMovingInputValid(input: String) {
        UpDown.values().forEach {
            if (input == it.name) return
        }
        throwException(INVALID_DIRECTION)
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): GameCommand {
        val command = readLine()
        return checkGameCommandValid(command)
    }

    private fun checkGameCommandValid(input: String): GameCommand {
        return GameCommand.inGameCommand(input)
    }
}
