package bridge

import bridge.util.BridgeMoving

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (number in 1..size) bridge.add(convertBridgeNumberToString(bridgeNumberGenerator.generate()))
        return bridge
    }

    private fun convertBridgeNumberToString(bridgeNumber: Int): String {
        if (bridgeNumber == BridgeMoving.UP.number) return BridgeMoving.UP.character
        return BridgeMoving.DOWN.character
    }
}
