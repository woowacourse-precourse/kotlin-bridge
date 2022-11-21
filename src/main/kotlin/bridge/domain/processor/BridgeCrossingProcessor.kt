package bridge.domain.processor

import bridge.common.*
import bridge.domain.moving.Moving

/**
 * 사용자가 다리를 건넌 후 결과를 처리하는 역할을 한다.
 */
object BridgeCrossingProcessor {
    private val bridgeCrossingInfo = mutableListOf<Pair<Moving, Boolean>>()
    private val currentMapInfo = mutableListOf<String>()
    private val bridgeIndexInfo = hashMapOf(0 to BRIDGE_NUMBER_UP, 1 to BRIDGE_NUMBER_DOWN)

    fun getCurrentMap(): List<String> {
        currentMapInfo.clear()

        repeat(BRIDGE_ROW_SIZE) { bridgeIndex ->
            currentMapInfo.add(createCurrentBridgeMap(bridgeIndexInfo[bridgeIndex]!!))
        }
        return currentMapInfo
    }

    /**
     * @param bridgeNumber 다리의 번호, 위쪽 다리는 1, 아래쪽 다리는 0으로 표현
     */
    private fun createCurrentBridgeMap(bridgeNumber: Int): String {
        var currentBridgeMap = ""
        val round = bridgeCrossingInfo.size - 1
        currentBridgeMap += MAP_BOUNDARY_START
        bridgeCrossingInfo.forEachIndexed { curRound, (moving, isCrossed) ->
            currentBridgeMap += getCrossingResult(
                moving = moving,
                bridgeNumber = bridgeNumber,
                isCrossed = isCrossed
            )
            currentBridgeMap += if (curRound == round) MAP_BOUNDARY_END else MAP_SEPARATOR
        }
        return currentBridgeMap
    }

    private fun getCrossingResult(moving: Moving, bridgeNumber: Int, isCrossed: Boolean): String {
        return if (moving.bridgeNumber == bridgeNumber) {
            if (isCrossed) MAP_CROSSED_SUCCESS_RESULT
            else MAP_CROSSED_FAIL_RESULT
        } else MAP_EMPTY_RESULT
    }

    fun getFinalGameResult(): String =
        if (isCrossingFail()) FINAL_FAIL_RESULT else FINAL_SUCCESS_RESULT

    fun isCrossingFail(): Boolean = bridgeCrossingInfo.any { (_, isCrossed) -> !isCrossed }

    fun updateBridgeCrossingInfo(userMoving: Moving, isCrossed: Boolean) =
        bridgeCrossingInfo.add(userMoving to isCrossed)

    fun clearBridgeCrossingInfo() = bridgeCrossingInfo.clear()
}
