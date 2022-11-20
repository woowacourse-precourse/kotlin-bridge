package bridge

import bridge.model.BridgeGame
import bridge.view.InputView

fun main() {
    val inputView = InputView()
    val bridgeSize = inputView.askBridgeSizeToUser()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    val bridgeGame = BridgeGame(bridge)
    val moving = inputView.askMovingToUser()
}
