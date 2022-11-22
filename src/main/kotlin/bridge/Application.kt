package bridge

private val inputView = InputView()
private val outputView = OutputView()

fun main() {
    outputView.printStartMessage()
    val bridgeSize = getBridgeSize()
    val bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize))
    val bridgeGame = BridgeGame(inputView, outputView, bridge)
    bridgeGame.start()
}

private fun getBridgeSize(): Int {
    while (true) {
        try {
            return inputView.readBridgeSize()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}