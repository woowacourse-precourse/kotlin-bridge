package bridge

import bridge.util.*

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size   다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridgeNumberList = MutableList(size) { index -> bridgeNumberGenerator.generate() }
        val bridge = bridgeNumberList.map { index ->
            val bridgeNumber = bridgeNumberList[index].toString()
            when (bridgeNumberList[index]) {
                UP_INT_NUMBER_ONE -> bridgeNumber.replace(UP_STRING_NUMBER_ONE, UP_SIDE_EXPRESSION)
                else -> bridgeNumber.replace(DOWN_STRING_NUMBER_ZERO, DOWN_SIDE_EXPRESSION)
            }
        }
        return bridge
    }
}

