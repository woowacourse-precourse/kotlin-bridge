package bridge

import bridge.constants.Constants.DOWN_BRIDGE_STRING
import bridge.constants.Constants.QUIT_COMMAND
import bridge.constants.Constants.RETRY_COMMAND
import bridge.constants.Constants.UP_BRIDGE_STRING

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
            throw IllegalArgumentException("[ERROR] 다리 크기는 숫자여야 합니다.")
    }

    private fun throwBridgeSizeRangeException(userInput: String) {
        if (userInput.toInt() !in 3..20)
            throw IllegalArgumentException("[ERROR] 다리 크기는 3부터 20 사이의 숫자여야 합니다.")
    }

    fun throwMovingException(userInput: String) {
        if (userInput != UP_BRIDGE_STRING && userInput != DOWN_BRIDGE_STRING)
            throw IllegalArgumentException("[ERROR] U 또는 D만 입력해야 합니다.")
    }

    fun throwGameCommandException(userInput: String) {
        if (userInput != RETRY_COMMAND && userInput != QUIT_COMMAND)
            throw IllegalArgumentException("[ERROR] R 또는 Q만 입력해야 합니다.")
    }
}
