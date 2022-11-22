package bridge.domain.calculator

import bridge.common.*
import bridge.domain.moving.Moving

/**
 * 사용자가 다리를 건넌 후 결과를 계산하는 역할을 한다.
 */
object BridgeCrossingCalculator {
    private val bridgeCrossingHistory = mutableListOf<Pair<Moving, Boolean>>()
    private val currentMap = mutableListOf<String>()
    private val bridgeIndexInfo = hashMapOf(0 to BRIDGE_NUMBER_UP, 1 to BRIDGE_NUMBER_DOWN)

    fun getCurrentMap(): List<String> {
        currentMap.clear()

        repeat(BRIDGE_ROW_SIZE) { bridgeIndex ->
            currentMap.add(createCurrentBridgeMap(bridgeIndexInfo[bridgeIndex]!!))
        }
        return currentMap
    }

    /**
     * @param bridgeNumber 다리의 번호, 위쪽 다리는 1, 아래쪽 다리는 0으로 표현
     */
    private fun createCurrentBridgeMap(bridgeNumber: Int): String {
        var currentBridgeMap = ""
        val round = bridgeCrossingHistory.size - 1

        currentBridgeMap += MAP_BOUNDARY_START
        bridgeCrossingHistory.forEachIndexed { curRound, history ->
            currentBridgeMap += calculateCrossingResult(bridgeNumber = bridgeNumber, history = history)
            currentBridgeMap += if (curRound == round) MAP_BOUNDARY_END else MAP_SEPARATOR
        }
        return currentBridgeMap
    }

    private fun calculateCrossingResult(bridgeNumber: Int, history: Pair<Moving, Boolean>): String {
        val (moving, isCrossed) = history

        return if (moving.bridgeNumber == bridgeNumber) {
            if (isCrossed) MAP_CROSSED_SUCCESS_RESULT
            else MAP_CROSSED_FAIL_RESULT
        } else MAP_EMPTY_RESULT
    }

    fun calculateFinalGameResult(): String =
        if (isCrossingFail()) FINAL_FAIL_RESULT else FINAL_SUCCESS_RESULT

    fun isCrossingFail(): Boolean = bridgeCrossingHistory.any { (_, isCrossed) -> !isCrossed }

    fun updateBridgeCrossingInfo(userMoving: Moving, isCrossed: Boolean) =
        bridgeCrossingHistory.add(userMoving to isCrossed)

    fun clearBridgeCrossingInfo() = bridgeCrossingHistory.clear()
}
