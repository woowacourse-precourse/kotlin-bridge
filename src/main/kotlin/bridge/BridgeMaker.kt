package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        val bridge = mutableListOf<String>()

        repeat(size) {
            val number = bridgeNumberGenerator.generate()

            if (number == 0) {
                bridge.add("D")
            } else if (number == 1) {
                bridge.add("U")
            }
        }
        return bridge
    }
}
