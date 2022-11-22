package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val resultBridge: MutableList<String> = mutableListOf()
        var bridgeRandomNumber: Int
        for(i in 0 until size){
            bridgeRandomNumber = bridgeNumberGenerator.generate()
            if(bridgeRandomNumber == 1){
                resultBridge.add("U")
            } else {
                resultBridge.add("D")
            }
        }
        return resultBridge.toList()
    }
}
