package bridge.controller

import bridge.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val bridgeMaker: BridgeMaker,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private val validatorController = ValidatorController(outputView)

    fun start() {
        outputView.printStartGame()
        outputView.printStepInterval()
        setUp()
    }

    private fun setUp() {}

    fun getBridgeSize(): Int {
        var input: String
        do {
            input = inputView.readBridgeSize()
            val isValid = validatorController.validateBridgeSize(input)
        } while (!isValid)

        return input.toInt()
    }

    private fun play() {}

    private fun getMovement(): String {
        return ""
    }

    private fun stop() {}

    private fun getGameCommand(): String {
        return ""
    }

    private fun restart() {}

    private fun finish() {}
}