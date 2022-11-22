package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val shapeOfBridge = mutableListOf<String>()
        for (i in 0 until size) {
            if (bridgeNumberGenerator.generate() == 1) {
                shapeOfBridge.add("U")
            } else {
                shapeOfBridge.add("D")
            }
        }
        return shapeOfBridge
    }
}
