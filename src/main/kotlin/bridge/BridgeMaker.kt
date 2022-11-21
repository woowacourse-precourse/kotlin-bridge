package bridge

import bridge.util.*

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridgeNumberList: MutableList<String> = mutableListOf()
        for (number in 0 until size) {
            val bridgeNumber = bridgeNumberGenerator.generate()
            if (bridgeNumber == UP_INT_NUMBER_ONE) bridgeNumberList.add(UP_DIRECTION)
            if (bridgeNumber == DOWN_INT_NUMBER_ZERO) bridgeNumberList.add(DOWN_DIRECTION)
        }

        return bridgeNumberList
    }
}

