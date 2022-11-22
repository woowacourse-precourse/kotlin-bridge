package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeUpDownBridge(size: Int): List<String> {
        val upDownBridge = mutableListOf<String>()

        repeat(size) {
            val bridgeNumber = bridgeNumberGenerator.generate()

            if (bridgeNumber == 0) {
                upDownBridge.add("D")
            } else if (bridgeNumber == 1) {
                upDownBridge.add("U")
            }
        }
        return upDownBridge
    }
}
