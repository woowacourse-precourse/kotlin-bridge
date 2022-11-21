package bridge

fun main() {
    OutputView().printStart()
    println()

    val bridgeSize = InputView().readBridgeSize()
    if (bridgeSize == 0) return Unit
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)

    BridgeGame(bridge)
}