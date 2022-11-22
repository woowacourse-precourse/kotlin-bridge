package bridge

import bridge.constants.Constant.Companion.START_INDEX
import bridge.constants.String.Companion.STRING_DOWN
import bridge.constants.String.Companion.STRING_UP

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (count in START_INDEX until size) {
            when (bridgeNumberGenerator.generate()) {
                0 -> bridge.add(STRING_DOWN)
                1 -> bridge.add(STRING_UP)
            }
        }
        return bridge
    }
}
