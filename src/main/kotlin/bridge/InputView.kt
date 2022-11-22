package bridge

import bridge.domain.InputCheck
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
class InputView {
    val bridgeInputCheck = InputCheck()

    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): String {
        println(BRIDGE_GAME_START_MESSAGE)
        println(INPUT_BRIDGE_LENGTH_MESSAGE)
        return Console.readLine()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(INPUT_MOVE_DIRECTION_MESSAGE)
        return Console.readLine()
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        println(INPUT_RETRY_MESSAGE)
        return Console.readLine()
    }
}
