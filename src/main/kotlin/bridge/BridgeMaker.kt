package bridge

import bridge.domain.Direction
import bridge.sentence.ErrorSentence

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> {
        validateBridgeLength(size)
        val result = mutableListOf<String>()
        for (i in 0 until size) {
            val direction = Direction.getDirection(bridgeNumberGenerator.generate())
            result.add(direction.hotKey())
        }
        return result
    }

    private fun validateBridgeLength(size: Int) {
        if (size !in BRIDGE_LENGTH_MIN..BRIDGE_LENGTH_MAX)
            throw IllegalArgumentException(ErrorSentence.BRIDGE_LENGTH.sentence())
    }

    companion object {
        const val BRIDGE_LENGTH_MIN = 3
        const val BRIDGE_LENGTH_MAX = 20
    }
}
