package bridge

import bridge.domain.game.Bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        return List(size) { 
            requireNotNull(
                Bridge.Floor.parse(bridgeNumberGenerator.generate())
            ).value
        }
    }
}
