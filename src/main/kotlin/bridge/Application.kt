package bridge

import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private lateinit var inputView: InputView
private lateinit var outputView: OutputView
private lateinit var bridgeMaker: BridgeMaker
private lateinit var bridgeNumberGenerator: BridgeNumberGenerator
private lateinit var movingEventManager: MovingEventManager
private lateinit var bridgeGame: BridgeGame

fun main() {
    config()
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    bridgeGame.start(bridge)
    val moving = inputView.askMovingToUser()
    bridgeGame.move(moving)
}

private fun config() {
    inputView = InputView()
    outputView = OutputView()
    bridgeNumberGenerator = BridgeRandomNumberGenerator()
    bridgeMaker = BridgeMaker(bridgeNumberGenerator)
    movingEventManager = MovingEventManager()
    movingEventManager.subscribe(outputView)
    bridgeGame = BridgeGame(movingEventManager)
}
