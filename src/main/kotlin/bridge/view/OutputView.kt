package bridge.view

import bridge.model.BridgeResult

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(bridgeMap: String) {
        println(bridgeMap)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * @param bridgeResult 다리를 건넜을 때 결과 enum class
     * @param totalCount 총 시도 횟수
     */
    fun printResult(bridgeResult: BridgeResult, totalCount: Int) {
        val result = when (bridgeResult) {
            BridgeResult.FINISH -> "성공"
            BridgeResult.FAIL -> "실패"
            else -> throw IllegalArgumentException("게임 안끝남")
        }
        println("게임 성공 여부: $result\n총 시도한 횟수 : $totalCount")
    }
}
