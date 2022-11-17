package bridge

fun main() {
    start()
}

private fun start() {
    OutputView().printStart()
    val inputReadBridgeSize: Int = InputView().readBridgeSize()
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(inputReadBridgeSize)
}
