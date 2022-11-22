package bridge

import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private lateinit var inputView: InputView
private lateinit var outputView: OutputView
private lateinit var bridgeMaker: BridgeMaker
private lateinit var bridgeNumberGenerator: BridgeNumberGenerator
private lateinit var movingEventManager: MovingEventManager
private lateinit var quitEventManager: QuitEventManager
private lateinit var bridgeGame: BridgeGame

fun main() {
    config()
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)
    bridgeGame.start(bridge)
    while(bridgeGame.running())
        bridgeGame.move(inputView.askMovingToUser())
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
    bridgeNumberGenerator = BridgeRandomNumberGenerator()
    bridgeMaker = BridgeMaker(bridgeNumberGenerator)
}

private fun setEventManager() {
    movingEventManager = MovingEventManager()
    movingEventManager.subscribe(outputView)
    quitEventManager = QuitEventManager()
    quitEventManager.subscribe(outputView)
    bridgeGame = BridgeGame(movingEventManager, quitEventManager)
}
