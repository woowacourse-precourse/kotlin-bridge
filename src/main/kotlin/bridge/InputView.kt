package bridge

import bridge.BridgeGameRule.BRIDGE_MAXIMUM_LENGTH
import bridge.BridgeGameRule.BRIDGE_MINIMUM_LENGTH
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_TYPE_ERROR
import java.util.regex.Pattern

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val userInput = camp.nextstep.edu.missionutils.Console.readLine()
        require(isInputTypeNumber(userInput)) { BRIDGE_SIZE_INPUT_TYPE_ERROR }
        val processedUserInput = convertToInt(userInput)
        require(checkInValidRange(processedUserInput)) { BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR }
        return processedUserInput
    }

    private fun isInputTypeNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

    private fun checkInValidRange(input: Int): Boolean = input in BRIDGE_MINIMUM_LENGTH..BRIDGE_MAXIMUM_LENGTH

    private fun convertToInt(input: String): Int = input.toInt()

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        return ""
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }
}
