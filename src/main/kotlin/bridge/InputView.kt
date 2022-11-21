package bridge

import bridge.BridgeGameRule.BRIDGE_MAXIMUM_LENGTH
import bridge.BridgeGameRule.BRIDGE_MINIMUM_LENGTH
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_TYPE_ERROR
import java.util.regex.Pattern

class InputView {
    fun readBridgeSize(): String = camp.nextstep.edu.missionutils.Console.readLine()

    fun getValidateBridgeSize(userInput: String): Int {
        require(isNumber(userInput)) { BRIDGE_SIZE_INPUT_TYPE_ERROR }
        val processedUserInput = convertToInt(userInput)
        require(checkInValidRange(processedUserInput)) { BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR }
        return processedUserInput
    }

    private fun isNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

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
