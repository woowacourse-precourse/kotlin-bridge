package bridge

import bridge.resources.BRIDGE_MAX_LENGTH
import bridge.resources.BRIDGE_MIN_LENGTH
import bridge.resources.ERROR_INPUT_NUMBER_IN_RANGE

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        require(size in BRIDGE_MIN_LENGTH..BRIDGE_MAX_LENGTH) { ERROR_INPUT_NUMBER_IN_RANGE }
        return 0.until(size).map { generateKey() }
    }

    private fun generateKey() = UP_AND_DOWN_KEYS[bridgeNumberGenerator.generate()]

    companion object {
        val UP_AND_DOWN_KEYS = listOf("D", "U")
    }
}
