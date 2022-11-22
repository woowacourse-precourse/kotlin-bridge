package bridge

import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_LOWER_INCLUSIVE
import bridge.BridgeRandomNumberGenerator.Companion.RANDOM_UPPER_INCLUSIVE
import bridge.domain.resource.*

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()

        for (index in 0 until size) {
            bridge.add(getMovementFromRandom(bridgeNumberGenerator.generate()))
        }

        return bridge
    }

    private fun getMovementFromRandom(value: Int): String {
        return when (value) {
            RANDOM_LOWER_INCLUSIVE -> MOVE_DOWN
            RANDOM_UPPER_INCLUSIVE -> MOVE_UP
            else -> value.toString()
        }
    }
}
