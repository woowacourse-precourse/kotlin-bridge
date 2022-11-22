package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeUpDownBridge(size: Int): List<String> {
        val upDownBridge = mutableListOf<String>()

        repeat(size) {
            val bridgeNumber = bridgeNumberGenerator.generate()

            if (bridgeNumber == 0) {
                upDownBridge.add(DOWN)
            } else if (bridgeNumber == 1) {
                upDownBridge.add(UP)
            }
        }
        return upDownBridge
    }

    companion object {
        const val UP = "U"
        const val DOWN = "D"
    }
}
