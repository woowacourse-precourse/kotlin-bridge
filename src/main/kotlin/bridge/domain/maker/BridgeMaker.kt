package bridge.domain.maker

import bridge.common.BRIDGE_NUMBER_DOWN
import bridge.common.BRIDGE_NUMBER_UP
import bridge.common.MOVING_DOWN_CODE
import bridge.common.MOVING_UP_CODE
import bridge.domain.generator.BridgeNumberGenerator

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()

        repeat(size) {
            val number = bridgeNumberGenerator.generate()

            if (number == BRIDGE_NUMBER_DOWN) bridge.add(MOVING_DOWN_CODE)
            if (number == BRIDGE_NUMBER_UP) bridge.add(MOVING_UP_CODE)
        }

        return bridge
    }
}
