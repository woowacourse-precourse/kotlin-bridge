package bridge

fun main() {
    OutputView().printStartGame()
    val bridgeSize = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    OutputView().printGetMoving()
    val bridgeMoving = InputView().readMoving()
}
