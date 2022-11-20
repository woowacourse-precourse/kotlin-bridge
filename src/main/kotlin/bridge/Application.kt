package bridge

import bridge.controller.GameController

import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator

import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeController = initController()
    bridgeController.start()
}
private fun initController(): GameController {
    val inputView = InputView()
    val outputView = OutputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return GameController(inputView, outputView, bridgeMaker)
}
