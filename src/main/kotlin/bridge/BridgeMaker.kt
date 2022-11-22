package bridge

import bridge.BridgeStep.Companion.convertBridgeNumberToString

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val list = mutableListOf<String>()
        repeat(size) {
            list.add(convertBridgeNumberToString(bridgeNumberGenerator.generate()))
        }
        return list
    }
}
