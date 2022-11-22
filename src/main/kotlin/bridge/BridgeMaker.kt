package bridge

import service.ExceptionHandler

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        ExceptionHandler.checkValidRangeLength(size)
        val bridge = mutableListOf<String>()
        for (i in 0 until size) {
            val number = bridgeNumberGenerator.generate()
            ExceptionHandler.checkValidState(number)
            bridge.add(if (number == 1) "U" else "D")
        }
        return bridge
    }
}
