package bridge

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGame: BridgeGame) {
        val upperBridge = bridgeGame.upperBridge.toList()
        val downBridge = bridgeGame.downBridge.toList()
        println("[ ${upperBridge.joinToString(" | ")} ]")
        println("[ ${downBridge.joinToString(" | ")} ]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGame: BridgeGame, isSuccess: Boolean, tryCounter: Int) {
        println("최종 게임 결과")
        this.printMap(bridgeGame)
        when (isSuccess) {
            true -> println("게임 성공 여부: 성공")
            false -> println("게임 성공 여부: 실패")
        }
        println("총 시도한 횟수: $tryCounter")
    }
}
