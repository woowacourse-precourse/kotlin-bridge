package bridge

fun main() {
    OutputView().printGameStartMessage()
    val size = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    BridgeGame(bridge).move(0,1)
}
