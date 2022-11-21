package bridge

import bridge.BridgeGameRule.BRIDGE_MAXIMUM_LENGTH
import bridge.BridgeGameRule.BRIDGE_MINIMUM_LENGTH
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_TYPE_ERROR
import bridge.BridgePhrases.INPUT_IS_NOT_ALPHABET_ERROR
import bridge.BridgePhrases.MOVING_CODE_INCORRECT_ERROR
import camp.nextstep.edu.missionutils.Console.*
import java.util.regex.Pattern

class InputView {
    fun readBridgeSize(): String = readLine()

    fun getValidateBridgeSize(userInput: String): Int {
        require(isNumber(userInput)) { BRIDGE_SIZE_INPUT_TYPE_ERROR }
        val processedUserInput = convertToInt(userInput)
        require(checkInValidRange(processedUserInput)) { BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR }
        return processedUserInput
    }

    private fun isNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

    private fun checkInValidRange(input: Int): Boolean = input in BRIDGE_MINIMUM_LENGTH..BRIDGE_MAXIMUM_LENGTH

    private fun convertToInt(input: String): Int = input.toInt()

    fun readMoving(): String = readLine()

    fun getValidateMovingCode(userInput: String): String {
        require(isAlphabet(userInput)) { INPUT_IS_NOT_ALPHABET_ERROR }
        val processedUserInput = userInput.uppercase()
        require(checkCorrectMovingCode(processedUserInput)) { MOVING_CODE_INCORRECT_ERROR }
        return processedUserInput
    }

    private fun checkCorrectMovingCode(input: String): Boolean =
        input == BridgeType.UP.charCode.toString() || input == BridgeType.DOWN.charCode.toString()

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    private fun isAlphabet(input: String): Boolean = Pattern.matches("^[a-z|A-Z]+$", input)
}
