package bridge

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    outputView.printGameStart()

    outputView.printInputBridgeSize()
    val bridgeSize = inputView.readBridgeSize()
    val bridge = makeBridge(bridgeSize)
}

private fun makeBridge(bridgeSize: Int): List<String> {
    val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    return bridgeMaker.makeBridge(bridgeSize)
}