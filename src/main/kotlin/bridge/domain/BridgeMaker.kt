package bridge.domain

import bridge.data.DOWN
import bridge.data.ONE
import bridge.data.UP
import bridge.data.ZERO

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        repeat(size) {
            when (bridgeNumberGenerator.generate()) {
                ZERO -> bridge.add(DOWN)
                ONE -> bridge.add(UP)
            }
        }
        return bridge
    }
}
