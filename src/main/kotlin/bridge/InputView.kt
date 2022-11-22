package bridge

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    private val validation = ValidationInput()
    /**
     * 다리의 길이를 입력받는다.
     */
    private fun readInput(readValueNumber: Int): String {
        when (readValueNumber) {
            1 -> println(INPUT_SIZE_MESSAGE)
            2 -> println(INPUT_DIRECTION_MESSAGE)
            3 -> println(INPUT_COMMAND_MESSAGE)
        }
        return Console.readLine()
    }

    fun readBridgeSize(): Int {
        var size = readInput(1)

        while (true) {
            try {
                validation.validateSizeValue(size)
                break
            } catch (e: IllegalArgumentException) {
                size = readInput(1)
            }
        }

        return size.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        var direction = readInput(2)

        while (true) {
            try {
                validation.validateDirectionValue(direction)
                break
            } catch (e: IllegalArgumentException) {
                println(INPUT_DIRECTION_MESSAGE)
                direction = readInput(2)
            }
        }

        return direction.uppercase()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        var command = readInput(3)

        while (true) {
            try {
                validation.validateCommandValue(command)
                break
            } catch (e: IllegalArgumentException) {
                command = readInput(3)
            }
        }

        return command.uppercase()
    }

    companion object {
        const val INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        const val INPUT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
        const val INPUT_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"
    }
}
