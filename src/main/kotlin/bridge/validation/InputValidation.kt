package bridge.validation

import bridge.util.BridgeMoving

class InputValidation {

    fun checkInputInteger(input: String) {
        try {
            input.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ErrorType.NOT_INTEGER_ERROR.message)
        }
    }

    fun checkBridgeSizeRange(size: Int) {
        if (size < MIN_BRIDGE_SIZE || size > MAX_BRIDGE_SIZE) throw IllegalArgumentException(ErrorType.BRIDGE_SIZE_RANGE_ERROR.message)
    }

    fun checkInputLength(input: String) {
        if (input.length != CORRECT_INPUT_LENGTH) throw IllegalArgumentException(ErrorType.INCORRECT_INPUT_LENGTH_ERROR.message)
    }

    fun checkUserMovingValidation(input: String) {
        if (!(input == BridgeMoving.UP.character || input == BridgeMoving.DOWN.character)) throw IllegalArgumentException(
            ErrorType.INCORRECT_MOVING_INPUT_ERROR.message
        )
    }

    fun checkUserRestartValidation(input: String) {
        if (!(input == RESTART || input == QUIT)) throw IllegalArgumentException(ErrorType.INCORRECT_RESTART_INPUT_ERROR.message)
    }

    enum class ErrorType(val message: String) {
        NOT_INTEGER_ERROR("$INITIAL_ERROR_MESSAGE 정수가 아닌 수가 포함되어 있습니다(공백포함). 정수만 입력해 주세요."),
        BRIDGE_SIZE_RANGE_ERROR("$INITIAL_ERROR_MESSAGE 올바르지 않은 숫자입니다. 3이상 20이하의 숫자만 입력해주세요."),
        INCORRECT_INPUT_LENGTH_ERROR("$INITIAL_ERROR_MESSAGE 올바르지 않은 입력값 길이입니다. 입력값의 길이는 1이어야 합니다(공백포함)."),
        INCORRECT_MOVING_INPUT_ERROR(
            "$INITIAL_ERROR_MESSAGE 올바르지 않은 입력값 입니다. 이동할 칸의 입력은 " +
                    "\"${BridgeMoving.UP.character}\" 또는 \"${BridgeMoving.DOWN.character}\" 만 가능합니다."
        ),
        INCORRECT_RESTART_INPUT_ERROR("$INITIAL_ERROR_MESSAGE 올바르지 않은 입력값 입니다. 게임 재시도를 원하시면 $RESTART 게임 종료를 원하시면 ${QUIT}를 입력해 주세요.")
    }

    companion object {
        const val INITIAL_ERROR_MESSAGE = "[ERROR]"
        const val MIN_BRIDGE_SIZE = 3
        const val MAX_BRIDGE_SIZE = 20
        const val CORRECT_INPUT_LENGTH = 1
        const val RESTART = "R"
        const val QUIT = "Q"
    }
}