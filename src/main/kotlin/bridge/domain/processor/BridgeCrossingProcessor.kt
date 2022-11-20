package bridge.domain.processor

import bridge.common.*
import bridge.domain.moving.MovingInfo

/**
 * 유저가 다리를 건널 때 결과를 처리하는 클래스
 */
object BridgeCrossingProcessor {
    private val bridgeCrossingInfo = mutableListOf<Pair<MovingInfo, Boolean>>()
    private val currentMapInfo = mutableListOf<String>()
    private val bridgeIndexInfo = hashMapOf(0 to BRIDGE_NUMBER_UP, 1 to BRIDGE_NUMBER_DOWN)

    fun getCurrentMap(): List<String> {
        currentMapInfo.clear()

        repeat(BRIDGE_ROW_SIZE) { bridgeIndex ->
            currentMapInfo.add(createCurrentMap(bridgeIndexInfo[bridgeIndex]!!))
        }
        return currentMapInfo
    }

    private fun createCurrentMap(bridgeNumber: Int): String {
        var currentMap = ""
        val round = bridgeCrossingInfo.size - 1

        currentMap += "[ "
        bridgeCrossingInfo.forEachIndexed { curRound, (moving, isCrossed) ->
            currentMap += getCrossingResult(movingInfo = moving, bridgeNumber = bridgeNumber, isCrossed = isCrossed)
            currentMap += if (curRound == round) " ]\n" else " | "
        }
        return currentMap
    }

    private fun getCrossingResult(movingInfo: MovingInfo, bridgeNumber: Int, isCrossed: Boolean): String {
        return if (movingInfo.bridgeNumber == bridgeNumber) {
            if (isCrossed) CROSSED_SUCCESS_RESULT
            else CROSSED_FAIL_RESULT
        } else " "
    }

    fun isCrossingFail(): Boolean = bridgeCrossingInfo.any { (_, isCrossed) -> !isCrossed }

    fun updateBridgeCrossingInfo(userMovingInfo: MovingInfo, isCrossed: Boolean) =
        bridgeCrossingInfo.add(userMovingInfo to isCrossed)

    fun clearBridgeCrossingInfo() = bridgeCrossingInfo.clear()
}
