package bridge

fun main() {
    try {
        val bridgeNumbers = generateBridge()
    } catch (e: IllegalArgumentException) {
        return
    }
}

fun generateBridge(): MutableList<Int> {
    OutputView.printStart()
    val bridgeSize = InputView().readBridgeSize()
    val bridgeNumbers = mutableListOf<Int>()
    for (i in 0 until bridgeSize) {
        bridgeNumbers.add(BridgeRandomNumberGenerator().generate())
    }
    return bridgeNumbers
}

