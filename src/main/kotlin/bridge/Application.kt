package bridge

import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private val inputView: InputView = InputView()
private val outputView: OutputView = OutputView()
private lateinit var bridgeMaker: BridgeMaker
private val movingEventManager: MovingEventManager = MovingEventManager()
private val quitEventManager: QuitEventManager = QuitEventManager()
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
    initBridgeMaker()
    initSubscribe()
    initBridgeGame()
}

private fun initBridgeMaker() {
    bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
}

private fun initSubscribe() {
    movingEventManager.subscribe(outputView)
    quitEventManager.subscribe(outputView)
}

private fun initBridgeGame() {
    bridgeGame = BridgeGame(movingEventManager, quitEventManager)
}
