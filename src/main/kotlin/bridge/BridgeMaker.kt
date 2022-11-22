package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val shapeOfBridge = mutableListOf<String>()
        val randomNumber = bridgeNumberGenerator.generate()
        for (i in 0 until size) {
            if (randomNumber == 1) {
                shapeOfBridge.add("U")
            } else if (randomNumber == 0) {
                shapeOfBridge.add("D")
            }
        }
        return shapeOfBridge
    }
}
