package bridge

import bridge.model.BridgeGame
import bridge.view.InputView

private lateinit var inputView: InputView
private lateinit var bridgeMaker: BridgeMaker
private lateinit var bridgeNumberGenerator: BridgeNumberGenerator

fun main() {
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)
    val moving = inputView.askMovingToUser()
}

private fun config() {
    inputView = InputView()
    bridgeNumberGenerator = BridgeRandomNumberGenerator()
    bridgeMaker = BridgeMaker(bridgeNumberGenerator)
}
