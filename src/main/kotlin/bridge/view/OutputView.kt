package bridge.view

import bridge.model.BridgeStatus
import bridge.utils.*

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
     * @param bridgeStatus 다리를 건넜을 때 결과 enum class
     * @param totalCount 총 시도 횟수
     */
    fun printResult(bridgeStatus: BridgeStatus, totalCount: Int) {
        val result = when (bridgeStatus) {
            is BridgeStatus.FINISH -> SUCCESS_TEXT
            is BridgeStatus.FAIL -> FAIL_TEXT
            else -> throw IllegalArgumentException(ERR_GAME_NOT_ENDED)
        }
        println(GAME_IS_SUCCESS + result + "\n" + TOTAL_TRY_COUNT_TEXT + totalCount)
    }

    fun printEndMessage() {
        println(FINAL_GAME_RESULT)
    }
}
