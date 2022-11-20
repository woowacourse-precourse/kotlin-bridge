package bridge.view

import bridge.BridgeMaker.Companion.UP_AND_DOWN_KEYS
import bridge.resources.ERROR_INPUT_ALLOWED_KEYS
import bridge.resources.INPUT_BRIDGE_SIZE
import bridge.resources.INPUT_GAME_COMMAND
import bridge.resources.INPUT_MOVING
import bridge.utils.isInListOrError
import bridge.utils.toIntOrError
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE)
        return Console.readLine().toIntOrError()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(INPUT_MOVING)
        return Console.readLine().isInListOrError(UP_AND_DOWN_KEYS, ERROR_INPUT_ALLOWED_KEYS)
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(INPUT_GAME_COMMAND)
        return Console.readLine().isInListOrError(GAME_COMMAND_KEYS, ERROR_INPUT_ALLOWED_KEYS)
    }

    companion object {
        private val GAME_COMMAND_KEYS = listOf("R", "Q")
    }
}
