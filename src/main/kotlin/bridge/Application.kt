package bridge

import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private lateinit var inputView: InputView
private lateinit var outputView: OutputView
private lateinit var bridgeMaker: BridgeMaker
private lateinit var movingEventManager: MovingEventManager
private lateinit var quitEventManager: QuitEventManager
private lateinit var bridgeGame: BridgeGame

fun main() {
    initApplication()
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    bridgeGame.start(bridge)
    playGame()
}

private fun playGame() {
    while (!bridgeGame.succeeded() && !bridgeGame.failed())
        bridgeGame.move(inputView.askMovingToUser())
    if (bridgeGame.succeeded()) {
        bridgeGame.quit()
        return
    }
    decideRetry()
}

private fun decideRetry() {
    when (inputView.askRetryToUser()) {
        true -> {
            bridgeGame.retry()
            playGame()
        }

        false -> bridgeGame.quit()
    }
}

private fun initApplication() {
    setInputView(InputView())
    setOutputView(OutputView())
    setBridgeMaker(BridgeMaker(BridgeRandomNumberGenerator()))
    setMovingEventManager(MovingEventManager())
    setQuitEventManager(QuitEventManager())
    initBridgeGame()
}

private fun setInputView(view: InputView) {
    inputView = view
}

private fun setOutputView(view: OutputView) {
    outputView = view
}

private fun setBridgeMaker(maker: BridgeMaker) {
    bridgeMaker = maker
}

private fun setMovingEventManager(manager: MovingEventManager) {
    movingEventManager = manager
}

private fun setQuitEventManager(manager: QuitEventManager) {
    quitEventManager = manager
}

private fun initBridgeGame() {
    bridgeGame = BridgeGame(movingEventManager, quitEventManager)
}
