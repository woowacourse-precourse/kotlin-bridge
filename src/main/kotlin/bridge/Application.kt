package bridge

fun main() {
    val input = InputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeSize = input.readBridgeSize()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)
    BridgeGameProgress().bridgeGameProgress(bridge)
}
