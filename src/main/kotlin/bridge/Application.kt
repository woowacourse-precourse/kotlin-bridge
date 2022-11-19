package bridge

import bridge.controller.BridgeGameController
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val generator = BridgeRandomNumberGenerator()
    val bridgeMaker = BridgeMaker(generator)
    val inputView = InputView()
    val outputView = OutputView()
    val controller = BridgeGameController(bridgeMaker, inputView, outputView)

    controller.start()
}
