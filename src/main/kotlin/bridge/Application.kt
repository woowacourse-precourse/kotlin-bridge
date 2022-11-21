package bridge

fun main() {
    OutputView().printStartGame()
    val bridgeSize = InputView().readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)
    while (true) {
        OutputView().printGetMoving()
        val bridgeMoving = InputView().readMoving()
        bridgeGame.move(bridgeMoving)
        OutputView().printMap(bridgeGame)
    }
}
