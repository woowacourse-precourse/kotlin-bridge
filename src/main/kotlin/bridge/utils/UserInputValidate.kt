package bridge.utils

class UserInputValidate {
    fun validateBridgeSize(inputBridgeSize: String): Int {
        isValidType(inputBridgeSize)
        isValidInputRange(inputBridgeSize.toInt())
        return inputBridgeSize.toInt()
    }

    private fun isNumber(s: String?): Boolean {
        return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
    }

    private fun isValidType(bridgeSize: String) {
        if (!isNumber(bridgeSize)) {
            throw IllegalArgumentException(BRIDGE_SIZE_TYPE_ERROR_MESSAGE)
        }
    }

    private fun isValidInputRange(bridgeSize: Int) {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize) {
            throw IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR_MESSAGE)
        }
    }

    fun validateMoving(inputMoving: String): String {
        isValidMovingInput(inputMoving)
        return inputMoving
    }

    private fun isValidMovingInput(inputMoving: String) {
        if (inputMoving.length != INPUT_MOVING_LENGTH || !inputMoving.contains(MOVING_UP) && !inputMoving.contains(MOVING_DOWN)) {
            throw IllegalArgumentException(INPUT_MOVING_ERROR_MESSAGE)
        }
    }

    fun validateGameCommand(inputMoving: String): String {
        isValidGameCommand(inputMoving)
        return inputMoving
    }

    private fun isValidGameCommand(inputMoving: String) {
        if (inputMoving.length != INPUT_GAME_COMMAND_LENGTH || !inputMoving.contains(QUIT_GAME) && !inputMoving.contains(RETRY_GAME)) {
            throw IllegalArgumentException(INPUT_GAME_COMMAND_ERROR_MESSAGE)
        }
    }

    companion object {
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
        const val INPUT_MOVING_LENGTH = 1
        const val INPUT_GAME_COMMAND_LENGTH = 1
        const val MOVING_UP = "U"
        const val MOVING_DOWN = "D"
        const val QUIT_GAME = "Q"
        const val RETRY_GAME = "R"
        const val BRIDGE_SIZE_TYPE_ERROR_MESSAGE = "[ERROR]: 다리의 길이는 숫자로만 입력되어야 합니다."
        const val BRIDGE_SIZE_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."
        const val INPUT_MOVING_ERROR_MESSAGE = "[ERROR] 이동할 칸의 입력은 U(위 칸)와 D(아래 칸) 중 하나여야 합니다."
        const val INPUT_GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 게임 재시작/종료 여부 입력은 R(재시작)과 Q(종료) 중 하나여야 합니다."
    }
}