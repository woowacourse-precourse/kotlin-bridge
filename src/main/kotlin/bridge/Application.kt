package bridge

import bridge.controller.BridgeGameController
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val generator = BridgeRandomNumberGenerator()
    val bridgeGame = BridgeGame()
    val bridgeMaker = BridgeMaker(generator)
    val inputView = InputView()
    val outputView = OutputView()
    val controller = BridgeGameController(bridgeGame, bridgeMaker, inputView, outputView)

    controller.start()
}
