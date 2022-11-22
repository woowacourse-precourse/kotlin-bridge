package bridge

import bridge.BridgeNumberGenerator
import bridge.data.Bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        return List(size) {
            Bridge.Floor.indexOf(bridgeNumberGenerator.generate()).command
        }
    }
}
