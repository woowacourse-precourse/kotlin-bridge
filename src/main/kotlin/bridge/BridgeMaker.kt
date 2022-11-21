package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        var randomBridge = mutableListOf<String>()
        var upOrDown = ""
        for(index in 0 until size){
            val number = bridgeNumberGenerator.generate()
            if(number == BridgeRandomNumberGenerator.RANDOM_LOWER_INCLUSIVE) upOrDown = "D"
            else if (number == BridgeRandomNumberGenerator.RANDOM_UPPER_INCLUSIVE) upOrDown = "U"
            randomBridge.add(upOrDown)
        }
        return randomBridge
    }
}
