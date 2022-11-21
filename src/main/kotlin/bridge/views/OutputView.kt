package bridge.views

import bridge.constants.String.Companion.STRING_INPUT_LENGTH
import bridge.constants.String.Companion.STRING_INPUT_MOVING
import bridge.constants.String.Companion.STRING_INPUT_RETRY
import bridge.constants.String.Companion.STRING_START_GAME

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap() {}

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    fun printStart() {
        println(STRING_START_GAME)
    }

    fun printInputBridgeLength() {
        println(STRING_INPUT_LENGTH)
    }

    fun printInputMoving() {
        println(STRING_INPUT_MOVING)
    }

    fun printInputRetry() {
        println(STRING_INPUT_RETRY)
    }
}
