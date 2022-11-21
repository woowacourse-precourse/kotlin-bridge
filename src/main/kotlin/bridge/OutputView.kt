package bridge

import bridge.BridgePhrases.BRIDGE_SIZE_PHRASE
import bridge.BridgePhrases.GAME_START_PHRASE
import bridge.BridgePhrases.MOVING_BRIDGE_SELECT_PHRASE
import bridge.BridgePhrases.RESTART_OR_QUIT_SELECT_PHRASE

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

    fun printGameStartPhrase() {
        println(GAME_START_PHRASE)
    }

    fun printBridgeSizePhrase() {
        println(BRIDGE_SIZE_PHRASE)
    }

    fun printMovingBridgeSelectPhrase() {
        println(MOVING_BRIDGE_SELECT_PHRASE)
    }

    fun printRestartOrQuitSelectPhrase() {
        println(RESTART_OR_QUIT_SELECT_PHRASE)
    }
}
