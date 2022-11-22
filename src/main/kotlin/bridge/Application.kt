package bridge

fun main() {
    // TODO: 프로그램 구현
    val gen = BridgeRandomNumberGenerator()
    val newBridge = BridgeMaker(gen)
    newBridge.makeBridge(InputView().readBridgeSize())
    val newBridgeGame = BridgeGame()

    newBridgeGame.move(newBridge, InputView().readMoving())
    newBridgeGame.retry(InputView().readGameCommand())

}
