package bridge

import bridge.controller.BridgeGameController
import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeGameController = initBridgeGameController()
    bridgeGameController.startGame()
}

private fun initBridgeGameController(): BridgeGameController {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return BridgeGameController(inputView, outputView, bridgeMaker)
}
