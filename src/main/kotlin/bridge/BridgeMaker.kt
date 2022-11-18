package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {

    fun makeBridge(size: Int): List<String> {
        var bridge = mutableListOf<String>()
        for (i in 1..size){
            val number = bridgeNumberGenerator.generate()
            if (number == 0){ bridge.add("D") }
            if (number == 1){ bridge.add("U") }
        }
        return bridge
    }
}
