package bridge

import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private lateinit var inputView: InputView
private lateinit var outputView: OutputView
private lateinit var bridgeMaker: BridgeMaker
private lateinit var bridgeGame: BridgeGame

fun main() {
    config()
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    bridgeGame.start(bridge)
    while(true) {
        bridgeGame.move(inputView.askMovingToUser())
        if (bridgeGame.successed())
            break
        if (!bridgeGame.running()) {
            if (inputView.askRetryToUser())
                bridgeGame.retry()
            else {
                bridgeGame.quit()
                break
            }
        }
    }
}

private fun config() {
    setView()
    setBridgeMaker()
    setEventManager()
}

private fun setView() {
    inputView = InputView()
    outputView = OutputView()
}

private fun setBridgeMaker() {
    bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
}

private fun setEventManager() {
    val movingEventManager = MovingEventManager()
    movingEventManager.subscribe(outputView)
    val quitEventManager = QuitEventManager()
    quitEventManager.subscribe(outputView)
    bridgeGame = BridgeGame(movingEventManager, quitEventManager)
}
