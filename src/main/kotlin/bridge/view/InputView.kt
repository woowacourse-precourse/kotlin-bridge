package bridge.view

import bridge.utils.*
import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    fun gameStart() {
        println(BRIDGE_GAME_START)
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(CHOOSE_BRIDGE_LENGTH)
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException(ERR_BRIDGE_LENGTH)
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(CHOOSE_BRIDGE_DIRECTION)
        return Console.readLine()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(CHOOSE_RETRY)
        return Console.readLine()
    }


}
