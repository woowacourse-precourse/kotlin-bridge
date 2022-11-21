package bridge

import java.lang.IllegalArgumentException

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    fun makeBridge(size: Int): List<String> =
        (1..size).map { createBridgeElement(bridgeNumberGenerator.generate()) }.toList()

    private fun createBridgeElement(bridgeNumber: Int): String {
        return when (bridgeNumber) {
            RANDOM_LOWER_INCLUSIVE -> "D"
            RANDOM_UPPER_INCLUSIVE -> "U"
            else -> {
                throw IllegalArgumentException("다리의 칸을 생성하려면 0또는 1만 가능합니다.")
            }
        }
    }

    companion object {
        private const val RANDOM_LOWER_INCLUSIVE = 0
        private const val RANDOM_UPPER_INCLUSIVE = 1
    }
}
