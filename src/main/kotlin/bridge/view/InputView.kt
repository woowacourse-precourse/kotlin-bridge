package bridge.view

import bridge.BridgeType
import bridge.GameState
import bridge.constants.BridgeGameRule.BRIDGE_MAXIMUM_LENGTH
import bridge.constants.BridgeGameRule.BRIDGE_MINIMUM_LENGTH
import bridge.constants.BridgePhrases.BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR
import bridge.constants.BridgePhrases.BRIDGE_SIZE_INPUT_TYPE_ERROR
import bridge.constants.BridgePhrases.GAME_COMMEND_CODE_INCORRECT_ERROR
import bridge.constants.BridgePhrases.INPUT_IS_NOT_ALPHABET_ERROR
import bridge.constants.BridgePhrases.MOVING_CODE_INCORRECT_ERROR
import camp.nextstep.edu.missionutils.Console.*
import java.util.regex.Pattern

class InputView {
    fun readBridgeSize(): Int {
        return try {
            getValidateBridgeSize(readLine())
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readBridgeSize()
        }
    }

    fun getValidateBridgeSize(userInput: String): Int {
        require(isNumber(userInput)) { BRIDGE_SIZE_INPUT_TYPE_ERROR }
        val processedUserInput = convertToInt(userInput)
        require(checkInValidRange(processedUserInput)) { BRIDGE_SIZE_INPUT_NOT_IN_CORRECT_RANGE_ERROR }
        return processedUserInput
    }

    private fun isNumber(input: String): Boolean = Pattern.matches("^[-]?[0-9]+$", input)

    private fun checkInValidRange(input: Int): Boolean = input in BRIDGE_MINIMUM_LENGTH..BRIDGE_MAXIMUM_LENGTH

    private fun convertToInt(input: String): Int = input.toInt()

    fun readMoving(): String {
        return try {
            getValidateMovingCode(readLine())
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readMoving()
        }
    }

    fun getValidateMovingCode(userInput: String): String {
        require(isAlphabet(userInput)) { INPUT_IS_NOT_ALPHABET_ERROR }
        val processedUserInput = userInput.uppercase()
        require(checkCorrectMovingCode(processedUserInput)) { MOVING_CODE_INCORRECT_ERROR }
        return processedUserInput
    }

    private fun checkCorrectMovingCode(input: String): Boolean =
        input == BridgeType.UP.stringCode || input == BridgeType.DOWN.stringCode

    fun readGameCommand(): String {
        return try {
            getValidateGameCommend(readLine())
        } catch (error: IllegalArgumentException) {
            println(error.message)
            readGameCommand()
        }
    }

    fun getValidateGameCommend(userInput: String): String {
        require(isAlphabet(userInput)) { INPUT_IS_NOT_ALPHABET_ERROR }
        val processedUserInput = userInput.uppercase()
        require(checkCorrectGameCommendCode(processedUserInput)) { GAME_COMMEND_CODE_INCORRECT_ERROR }
        return processedUserInput
    }

    private fun checkCorrectGameCommendCode(input: String): Boolean =
        input == GameState.RESTART.stringCode || input == GameState.QUIT.stringCode

    private fun isAlphabet(input: String): Boolean = Pattern.matches("^[a-z|A-Z]+$", input)
}
