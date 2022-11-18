package bridge

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.util.DOWN
import bridge.util.UP

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> = arrayListOf<String>().apply {
        while (this.size < size) addRandomDirection()
    }

    private fun ArrayList<String>.addRandomDirection() {
        when (bridgeNumberGenerator.generate()) {
            RANDOM_UPPER_INCLUSIVE -> add(UP)
            RANDOM_LOWER_INCLUSIVE -> add(DOWN)
        }
    }
}
