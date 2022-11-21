package bridge.domain

import bridge.util.BridgeNumberGenerator

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        while (bridge.size < size) {
            val path = Path.valueOf(bridgeNumberGenerator.generate())
            bridge.add(path)
        }
        return bridge.toList()
    }
}
