package bridge

import bridge.controller.BridgeGameController
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeGame = BridgeGame()
    val generator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(generator)
    val inputView = InputView()
    val outputView = OutputView()
    val controller = BridgeGameController(bridgeGame, bridgeMaker, inputView, outputView)

    controller.start()
}
