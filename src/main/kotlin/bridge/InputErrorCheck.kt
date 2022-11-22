package bridge

import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.QUIT_COMMAND
import bridge.constants.Constants.RETRY_COMMAND
import bridge.constants.Constants.UP_BRIDGE_STRING
import bridge.constants.ErrorMessage.BRIDGE_SIZE_RANGE_ERROR
import bridge.constants.ErrorMessage.GAME_COMMAND_ERROR
import bridge.constants.ErrorMessage.IS_BRIDGE_SIZE_NUMBER_ERROR
import bridge.constants.ErrorMessage.MOVING_ERROR

class InputErrorCheck {
    fun checkValidBridgeSize(userInput: String) {
        throwIsBridgeSizeNumberException(userInput)
        throwBridgeSizeRangeException(userInput)
    }

    private fun throwIsBridgeSizeNumberException(userInput: String) {
        val numbers = userInput.toCharArray().filter { number ->
            number in '0'..'9'
        }
        if (numbers.size != userInput.length)
            throw IllegalArgumentException(IS_BRIDGE_SIZE_NUMBER_ERROR)
    }

    private fun throwBridgeSizeRangeException(userInput: String) {
        if (userInput.toInt() !in 3..20)
            throw IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR)
    }

    fun throwMovingException(userInput: String) {
        if (userInput != UP_BRIDGE_STRING && userInput != DOWN_BRIDGE_STRING)
            throw IllegalArgumentException(MOVING_ERROR)
    }

    fun throwGameCommandException(userInput: String) {
        if (userInput != RETRY_COMMAND && userInput != QUIT_COMMAND)
            throw IllegalArgumentException(GAME_COMMAND_ERROR)
    }
}
