package bridge.ui.view

import bridge.common.*
import bridge.domain.moving.MOVING


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(bridgeCrossingInfo: List<Pair<MOVING, Boolean>>) {
        repeat(BRIDGE_ROW_SIZE) { bridgeIndex ->
            checkBridge(bridgeCrossingInfo, bridgeIndexInfo[bridgeIndex]!!)
        }
    }

    private fun checkBridge(bridgeCrossingInfo: List<Pair<MOVING, Boolean>>, bridgeNumber: Int) {
        val round = bridgeCrossingInfo.size - 1

        print("[ ")
        bridgeCrossingInfo.forEachIndexed { curRound, (moving, isCrossed) ->
            if (moving.bridgeNumber == bridgeNumber) {
                printCrossingResult(isCrossed = isCrossed)
            }

            else print(" ")

            if (curRound == round) print(" ]\n")
            else print(" | ")
        }
    }

    private fun printCrossingResult(isCrossed: Boolean) {
        if (isCrossed) print(CROSSED_SUCCESS_RESULT)
        else print(CROSSED_FAIL_RESULT)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    fun printMessage(message: String) = print(message)

    companion object {
        private val bridgeIndexInfo = hashMapOf(0 to BRIDGE_NUMBER_UP, 1 to BRIDGE_NUMBER_DOWN)
    }
}
