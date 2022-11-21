package bridge

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.model.Bridge

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        require(size in BRIDGE_MIN_LENGTH..BRIDGE_MaX_LENGTH)
        return List(size) {
            if (bridgeNumberGenerator.generate() == RANDOM_UPPER_INCLUSIVE) "U" else "D"
        }
    }

    companion object {
        private const val BRIDGE_MIN_LENGTH = 3
        private const val BRIDGE_MaX_LENGTH = 20
    }

}
