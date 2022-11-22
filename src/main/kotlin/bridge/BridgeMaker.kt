package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        var bridge = mutableListOf<String>()
        for(i in 0 until size){
            val randomNum = bridgeNumberGenerator.generate()
            if(randomNum == 0){
                bridge.add("D")
                continue
            }
            bridge.add("U")
        }
        return bridge
    }
}
