package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        var bridge = mutableListOf<String>()
        for(i in 0 until size) {
            when (bridgeNumberGenerator.generate()) {
                1 -> bridge.add("U")
                0 -> bridge.add("D")
            }
        }
        return bridge
    }
}
