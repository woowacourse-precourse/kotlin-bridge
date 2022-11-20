package bridge.view

import bridge.domain.BridgeGameInfo
import bridge.resources.*

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeGameInfo: BridgeGameInfo) {
        println(OUTPUT_BRIDGE_MAP.format(bridgeGameInfo.getUpBridge().joinToString(" | ")))
        println(OUTPUT_BRIDGE_MAP.format(bridgeGameInfo.getDownBridge().joinToString(" | ")))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(bridgeGameInfo: BridgeGameInfo) {
        bridgeGameInfo.apply {
            println(OUTPUT_RESULT_NOTATION)
            printMap(bridgeGameInfo)
            println(OUTPUT_RESULT_STATUS.format(if (bridge.size == stage.size) OUTPUT_SUCCESS else OUTPUT_FAILURE))
            println(OUTPUT_RESULT_COUNT_OF_TRY.format(bridgeGameInfo.countOfTry))
        }
    }
}
