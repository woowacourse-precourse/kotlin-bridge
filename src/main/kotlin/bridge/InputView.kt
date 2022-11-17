package bridge

import bridge.Constant.ERROR_MESSAGE
import bridge.Constant.GAME_COMMAND_INPUT_TYPE_ERROR_MESSAGE
import bridge.Constant.INPUT_BRIDGE_SIZE_MESSAGE
import bridge.Constant.MOVING_INPUT_TYPE_ERROR_MESSAGE
import bridge.Constant.SELECT_MOVE_MESSAGE
import bridge.Constant.SELECT_RESTART_MESSAGE
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        return try {
            println(INPUT_BRIDGE_SIZE_MESSAGE)
            Console.readLine()!!.bridgeSizeInputTypeException()
        } catch (e: IllegalArgumentException) {
            println(ERROR_MESSAGE)
            readBridgeSize()
        }
    }

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
