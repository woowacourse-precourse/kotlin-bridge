package bridge

fun main() {
    try {
        val bridge = generateBridge()
        print(bridge)

    } catch (e: IllegalArgumentException) {
        return
    }
}

fun generateBridge(): List<String> {
    OutputView.printStart()
    val bridgeSize = InputView().readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return bridgeMaker.makeBridge(bridgeSize)
}


