package bridge.controller

import bridge.BridgeMaker
import bridge.domain.BridgeGame
import bridge.model.BridgeDTO
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val bridgeGame: BridgeGame,
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

    private fun setUp() {
        val bridgeSize = getBridgeSize()

        val bridge = bridgeMaker.makeBridge(bridgeSize)

        val bridgeDTO = BridgeDTO(bridge)
        bridgeGame.setBridge(bridgeDTO)

        outputView.printStepInterval()

        play()
    }

    private fun getBridgeSize(): Int {
        var input: String
        do {
            input = inputView.askBridgeSize()
            val isValid = validatorController.validateBridgeSize(input)
        } while (!isValid)

        return input.toInt()
    }

    private fun play() {}

    private fun getMovement(): String {
        var input: String
        do {
            input = inputView.askMovement()
            val isValid = validatorController.validateMovement(input)
        } while (!isValid)

        return input
    }

    private fun stop() {}

    private fun getGameCommand(): String {
        return ""
    }

    private fun restart() {}

    private fun finish() {}
}