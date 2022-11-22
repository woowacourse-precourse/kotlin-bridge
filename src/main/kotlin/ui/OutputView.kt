package ui

import bridge.BridgeGame
import values.Inform
import values.Moving

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(gameProgress: List<List<String>>) {
        println(gameProgress[Moving.UP.index].joinToString(" | ", "[ ", " ]"))
        println(gameProgress[Moving.DOWN.index].joinToString(" | ", "[ ", " ]"))
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame) {
        println(Inform.RESULT.message)
        printMap(bridgeGame.getGameProgress())

        println("${Inform.SUCCESS_OR_FAILURE.message}: ${if (bridgeGame.isSuccess()) "성공" else "실패"}")
        println("${Inform.TRY_NUMBER.message}: ${bridgeGame.getTryCount()}")
    }
}
