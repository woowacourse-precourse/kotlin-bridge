package bridge

import bridge.domain.Command

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        while (bridge.size < size) {
            val path = Command.valueOf(bridgeNumberGenerator.generate())
            bridge.add(path)
        }
        return bridge.toList()
    }
}
