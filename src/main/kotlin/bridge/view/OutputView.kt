package bridge.view

import bridge.domain.BridgeGame
import bridge.util.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 출력값에 맞게 리스트를 변경한다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        bridgeGame.userMove.forEach { result ->
            println(result.joinToString(SEPARATOR, PREFIX, POSTFIX))
        }
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame, success: Boolean) {
        println(RESULT_GAME)
        printMap(bridgeGame)
        println(SUCCESS_OR_FAILURE + if (success) "성공" else "실패")
        println(GAME_COUNT + bridgeGame.gameCount)
    }
}
