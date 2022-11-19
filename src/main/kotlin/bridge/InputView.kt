package bridge

import bridge.util.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.util.SELECT_GAME_COMMAND_MESSAGE
import bridge.util.SELECT_MOVE_INPUT_MESSAGE
import bridge.validator.InputValidator

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE_MESSAGE)
        return InputValidator.validateBridgeSize()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(SELECT_MOVE_INPUT_MESSAGE)
        return InputValidator.validateMoveInput()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(SELECT_GAME_COMMAND_MESSAGE)
        return InputValidator.validateGameCommand()
    }
}

