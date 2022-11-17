package bridge.view

import bridge.resources.ERROR_INPUT_ALLOWED_KEYS
import bridge.resources.INPUT_BRIDGE_SIZE
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
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료: Q)")
        return Console.readLine()
    }

    companion object {
        private val UP_AND_DOWN_KEYS = listOf("U", "D")
    }
}
