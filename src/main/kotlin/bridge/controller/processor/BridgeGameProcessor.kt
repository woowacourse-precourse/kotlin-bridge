package bridge.controller.processor

import bridge.util.*

object BridgeGameProcessor {
    /*
    * Pair 두 가지 값을 반환할 수 있음
    * 현재까지 온 출력 보여줌
    * 현재 위치 정보 맵 키, value 지정하여 비교
    * */
    private val bridgePassInfo = mutableListOf<Pair<Moving, Boolean>>()
    private val bridgeLocationInfo =
        hashMapOf(UP_BRIDGE to UP_INT_NUMBER_ONE, DOWN_BRIDGE to DOWN_INT_NUMBER_ZERO)
    private val currentMapPrint = mutableListOf<String>()

    /*
    * deleteBridgePassInfo: 지나간 정보를 비움
    * updateFail: 지나갈 수 없음, 안에 false 하나라도 존재하면 true 반환
    * updateBridgePassInfo: 다리 이동 가능한지 표기
    * */

    fun deleteBridgePassInfo() = bridgePassInfo.clear()

    fun updateFail(): Boolean = bridgePassInfo.any { (_, hasPassed) -> !hasPassed }

    fun updateBridgePassInfo(moving: Moving, hasPassed: Boolean) =
        bridgePassInfo.add(moving to hasPassed)


    // 통과 했으면 O, 통과 못하면 X 출력해줌
    private fun updatePassed(moving: Moving, bridgeNumber: Int, hasPassed: Boolean): String {
        val passedResult = when (moving.bridgeNumber) {
            bridgeNumber -> {
                if (hasPassed) return PASS_POSSIBLE_EXPRESSION
                return PASS_IMPOSSIBLE_EXPRESSION
            }
            else -> EMPTY_EXPRESSION
        }
        return passedResult
    }

    /*
    * 현재 맵을 출력
    * [,O, X,] 추가
    * */
    private fun createMapPrint(bridgeNumber: Int): String {
        var mapPrint = EMPTY_EXPRESSION
        val round = bridgePassInfo.size - 1

        mapPrint += OPEN_BRACKET
        bridgePassInfo.forEachIndexed { index, (moving, hasPassed) ->
            mapPrint += updatePassed(moving, bridgeNumber, hasPassed)
            mapPrint += if (index == round) CLOSE_BRACKET else VERTICAL_LINE
        }
        return mapPrint
    }


    /*
     2번 반복 -> 위, 아래 다리 비교하여 리스트로 출력
    *
    * */

    fun updateMapList(): List<String> {
        currentMapPrint.clear()
        repeat(TWO_BRIDGE) { twoBridge -> currentMapPrint.add(createMapPrint(bridgeLocationInfo[twoBridge]!!)) }
        return currentMapPrint
    }
}
