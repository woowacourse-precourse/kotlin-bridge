package bridge

import java.lang.IllegalArgumentException

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> =
        (1..size).map { createBridgeElement(bridgeNumberGenerator.generate()) }.toList()

    private fun createBridgeElement(bridgeNumber: Int): String {
        return when (bridgeNumber) {
            LOWER_INCLUSIVE -> "D"
            UPPER_INCLUSIVE -> "U"
            else -> {
                throw IllegalArgumentException("다리의 칸을 생성하려면 0또는 1만 가능합니다.")
            }
        }
    }

    companion object {
        private const val LOWER_INCLUSIVE = 0
        private const val UPPER_INCLUSIVE = 1
        private const val UP = "U"
        private const val DOWN = "D"
    }
}
