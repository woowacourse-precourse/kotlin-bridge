package bridge

object BridgeCalculate {

    fun bridgeMaking(size: Int): List<Int> {
        val bridge = mutableListOf<Int>()
        val randomizer = BridgeRandomNumberGenerator()
        for (number: Int in 0..size)
            bridge.add(randomizer.generate())

        return bridge.toList()
    }

    fun bridgeMoving(bridge: List<Int>, count: Int): Boolean {
        OutputView.getBridgeMoving()
        return bridge[count] == InputView.readMoving()
    }

    fun bridgemapPrint(bridge: List<Int>, record: List<Boolean>) {

    }

}