package bridge

import bridge.util.*

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size   다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     * TODO: else 없애야 하는데 ?
     */
    fun makeBridge(size: Int): List<String> {
        val bridgeNumberList = List(size) { index -> bridgeNumberGenerator.generate() }
        println(bridgeNumberList)
        val bridge =bridgeNumberList.map { number ->
            val bridgeNumber = number.toString()
            when (number) {
                UP_INT_NUMBER_ONE -> bridgeNumber.replace(UP_STRING_NUMBER_ONE, UP_DIRECTION)
                else -> bridgeNumber.replace(DOWN_STRING_NUMBER_ZERO, DOWN_DIRECTION)
            }
        }
        println(bridge)
        return bridge
    }
}

