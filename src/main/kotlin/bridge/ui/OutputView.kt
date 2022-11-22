package bridge.ui

import bridge.data.ENTER_BRIDGE_SIZE
import bridge.data.ENTER_DIRECTION
import bridge.data.ENTER_GAME_RETRY
import bridge.data.GAME_START

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printOpening() {
        println(GAME_START)
        println(ENTER_BRIDGE_SIZE)
    }

    fun printRequestDirection() {
        println(ENTER_DIRECTION)
    }

    fun printAskRetry() {
        println(ENTER_GAME_RETRY)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(Bridge: String) {
        println(Bridge)
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}
}
