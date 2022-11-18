package bridge

fun main() {
    OutputView().printStart()
    println()
    val bridgeSize = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    val moving = InputView().readMoving()
}
