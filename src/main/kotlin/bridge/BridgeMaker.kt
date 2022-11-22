package bridge

class BridgeMaker(private val bridgeNumberGenerator: BridgeNumberGenerator) {
    fun makeBridge(size: Int): List<String> {
        val numberList = mutableListOf<String>()
        var number: Int
        for(i in 0 until size) {
            number = bridgeNumberGenerator.generate()
            if (number == 0) numberList.add("D")
            if (number == 1) numberList.add("U")
        }
        return numberList
    }
}