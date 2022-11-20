package bridge.view

import bridge.domain.BridgeGame

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(gameResult: BridgeGame) {
        printUpperMap(gameResult.getUpBridge())
        printLowerMap(gameResult.getDownBridge())
    }

    private fun printUpperMap(gameResult: List<String>) {
        print("[ ${gameResult.joinToString(SEPARATOR)} ]\n")
    }

    private fun printLowerMap(gameResult: List<String>) {
        print("[ ${gameResult.joinToString(SEPARATOR)} ]\n")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGameResult: BridgeGame) {
        println("\n최종 게임 결과")
        printMap(bridgeGameResult)
        println("\n게임 성공 여부: " + isClearGame(bridgeGameResult.isClear()))
        println("총 시도한 횟수: " + bridgeGameResult.getTryNumber())
    }

    private fun isClearGame(isClear: Boolean): String {
        if (isClear) {
            return "성공"
        }
        return "실패"
    }

    companion object {
        const val SEPARATOR = " | "
    }
}
