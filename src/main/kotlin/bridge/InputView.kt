package bridge

import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val input = Console.readLine().trim()
        this.numberChecker(input)
        this.numberRangeChecker(input)

        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        val input = Console.readLine().trim()
        this.lengthChecker(input)
        this.stringChecker(input)
        this.stringRangeChecker(input, MOVING_RANGE)

        return input.uppercase()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input = Console.readLine().trim()
        this.lengthChecker(input)
        this.stringChecker(input)
        this.stringRangeChecker(input, COMMAND_RANGE)

        return input.uppercase()
    }

    private fun lengthChecker(input: String) {
        if (input.length != 1) {
            throw IllegalArgumentException(NOT_ALLOWED_STRING_RANGE_INPUT)
        }
    }

    private fun numberChecker(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(NOT_ALLOWED_NUMBER_INPUT)
        }
    }

    private fun stringChecker(input: String) {
        if (input.toIntOrNull() != null) {
            throw IllegalArgumentException(NOT_ALLOWED_STRING_INPUT)
        }
    }

    private fun numberRangeChecker(input: String) {
        if (input.toInt() !in MIN_BRIDGE_SIZE..MAX_BRIDGE_SIZE) {
            throw IllegalArgumentException(NOT_ALLOWED_NUMBER_RANGE_INPUT)
        }
    }

    private fun stringRangeChecker(input: String, range: List<String>) {
        if (input !in range) {
            when (range) {
                COMMAND_RANGE -> throw IllegalArgumentException(NOT_ALLOWED_COMMAND_RANGE)
                MOVING_RANGE -> throw IllegalArgumentException(NOT_ALLOWED_MOVING_RANGE)
            }
        }
    }

    companion object {
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
        const val COMMAND_UP = "U"
        const val COMMAND_DOWN = "D"
        const val COMMAND_RESTART = "R"
        const val COMMAND_QUIT = "Q"
        const val NOT_ALLOWED_NUMBER_INPUT = "[ERROR] 입력이 올바르지 않습니다(HINT: 숫자 입력)."
        const val NOT_ALLOWED_STRING_INPUT = "[ERROR] 입력이 올바르지 않습니다(HINT: 문자 입력)."
        const val NOT_ALLOWED_NUMBER_RANGE_INPUT =
            "[ERROR] 허용된 입력 범위가 아닙니다(HINT: $MIN_BRIDGE_SIZE ~ $MAX_BRIDGE_SIZE 사이 숫자입력)."
        const val NOT_ALLOWED_STRING_RANGE_INPUT = "[ERROR] 허용된 입력 범위가 아닙니다(HINT: 하나의 문자만 입력)"
        val COMMAND_RANGE = listOf(COMMAND_RESTART, COMMAND_QUIT)
        val MOVING_RANGE = listOf(COMMAND_UP, COMMAND_DOWN)
        const val NOT_ALLOWED_COMMAND_RANGE = "[ERROR] 허용된 입력 범위가 아닙니다(HINT: $COMMAND_RESTART, $COMMAND_QUIT 중 하나 입력)"
        const val NOT_ALLOWED_MOVING_RANGE = "[ERROR] 허용된 입력 범위가 아닙니다(HINT: $COMMAND_UP, $COMMAND_DOWN 중 하나 입력)"
    }

}
