package bridge.app.processor

import bridge.util.*

object BridgeGameProcessor {
    /*
    * Pair 두 가지 값을 반환할 수 있음
    * 현재까지 온 출력 보여줌
    * 현재 위치 정보 맵 키, value 지정하여 비교
    * */
    private val bridgePassInfo = mutableListOf<Pair<Moving, Boolean>>()
    private val currentMapPrint = mutableListOf<String>()
    private val bridgeLocationInfo =
        hashMapOf(DOWN_INT_NUMBER_ZERO to DOWN_DIRECTION, UP_INT_NUMBER_ONE to UP_DIRECTION)

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
    fun updatePassed(moving: Moving, bridgeNumber: Int, hasPassed: Boolean): String {
        val passedResult = when (moving.bridgeNumber) {
            bridgeNumber -> {
                if (hasPassed) return UP_DIRECTION
                return DOWN_DIRECTION
            }
            else -> " "
        }
        return passedResult
    }

    /*
    * 현재 맵을 출력
    * [,O, X,] 추가
    * */
    fun createMapPrint(bridgeNumber: Int): String {
        var mapPrint = ""
        val round = bridgePassInfo.size - 1

        mapPrint += "[ "
        bridgePassInfo.forEachIndexed { index, (moving, hasPassed) ->
            mapPrint += updatePassed(moving, bridgeNumber, hasPassed)
            mapPrint += if (index == round) " ]\n" else  " | "
        }
        return mapPrint
    }
}
