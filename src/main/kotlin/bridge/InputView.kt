package bridge

import bridge.BridgeGameRule.BRIDGE_MAXIMUM_LENGTH
import bridge.BridgeGameRule.BRIDGE_MINIMUM_LENGTH
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR
import bridge.BridgePhrases.BRIDGE_SIZE_INPUT_TYPE_ERROR
import bridge.BridgePhrases.GAME_COMMEND_CODE_INCORRECT_ERROR
import bridge.BridgePhrases.INPUT_IS_NOT_ALPHABET_ERROR
import bridge.BridgePhrases.MOVING_CODE_INCORRECT_ERROR
import camp.nextstep.edu.missionutils.Console.*
import java.util.regex.Pattern

class InputView {
    fun readBridgeSize(): Int = getValidateBridgeSize(readLine())

    fun getValidateBridgeSize(userInput: String): Int {
        require(isNumber(userInput)) { BRIDGE_SIZE_INPUT_TYPE_ERROR }
        val processedUserInput = convertToInt(userInput)
        require(checkInValidRange(processedUserInput)) { BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR }
        return processedUserInput
    }

    private fun isNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

    private fun checkInValidRange(input: Int): Boolean = input in BRIDGE_MINIMUM_LENGTH..BRIDGE_MAXIMUM_LENGTH

    private fun convertToInt(input: String): Int = input.toInt()

    fun readMoving(): String = getValidateMovingCode(readLine())

    fun getValidateMovingCode(userInput: String): String {
        require(isAlphabet(userInput)) { INPUT_IS_NOT_ALPHABET_ERROR }
        val processedUserInput = userInput.uppercase()
        require(checkCorrectMovingCode(processedUserInput)) { MOVING_CODE_INCORRECT_ERROR }
        return processedUserInput
    }

    private fun checkCorrectMovingCode(input: String): Boolean =
        input == BridgeType.UP.charCode.toString() || input == BridgeType.DOWN.charCode.toString()

    fun readGameCommand(): String = getValidateGameCommend(readMoving())

    fun getValidateGameCommend(userInput: String): String {
        require(isAlphabet(userInput)) { INPUT_IS_NOT_ALPHABET_ERROR }
        val processedUserInput = userInput.uppercase()
        require(checkCorrectGameCommendCode(processedUserInput)) { GAME_COMMEND_CODE_INCORRECT_ERROR }
        return processedUserInput
    }

    private fun checkCorrectGameCommendCode(input: String): Boolean =
        input == GameState.RESTART.charCode.toString() || input == GameState.QUIT.charCode.toString()

    private fun isAlphabet(input: String): Boolean = Pattern.matches("^[a-z|A-Z]+$", input)
}
