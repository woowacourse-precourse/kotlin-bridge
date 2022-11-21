package ui

import bridge.BridgeGame

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
        println(gameProgress[0].joinToString(" | ", "[ ", " ]"))
        println(gameProgress[1].joinToString(" | ", "[ ", " ]"))
        println()
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame) {
        println("최종 게임 결과")
        printMap(bridgeGame.getGameProgress())

        println("게임 성공 여부: ${if (bridgeGame.isSuccess()) "성공" else "실패"}")
        println("총 시도한 횟수: ${bridgeGame.getTryCount()}")
    }
}
