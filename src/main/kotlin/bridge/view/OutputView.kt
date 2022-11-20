package bridge.view

import bridge.INPUT_BRIDGE_LENGTH
import bridge.START_BRIDGE_GAME
import java.lang.IllegalArgumentException

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
object OutputView {
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

    fun startGame() {
        println(START_BRIDGE_GAME)
        println()
    }

    fun inputLength() {
        println(INPUT_BRIDGE_LENGTH)
    }


    fun throwException(errorMessage: String) {
        throw IllegalArgumentException(errorMessage)
    }

}
