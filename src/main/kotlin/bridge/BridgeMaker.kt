package bridge

import constant.Symbol

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()
        for (i in 1..size) {
            val number = bridgeNumberGenerator.generate()
            val answer = if (number == 0) Symbol.DOWN.symbol else Symbol.UP.symbol
            bridge.add(answer)
        }
        return bridge
    }
}
