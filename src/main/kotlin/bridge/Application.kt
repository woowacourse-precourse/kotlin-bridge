package bridge

fun main() {
    val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeSize: Int = InputView().readBridgeSize()
    val bridge: List<String> = bridgeMaker.makeBridge(bridgeSize)
    val bridgeGame: BridgeGame = BridgeGame(bridge)
}
