package bridge.domain

import bridge.data.Bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        return List(size) {
            Bridge.Floor[bridgeNumberGenerator.generate()].command
        }
    }
}
