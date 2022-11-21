package bridge.controller

import bridge.BridgeGameStatus
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

    private fun play() {
        do {
            val movement = getMovement()

            val metadata = bridgeGame.move(movement)

            outputView.printMap(metadata)
            outputView.printStepInterval()

            goToNextStep(metadata.getGameStatus())
        } while (metadata.getGameStatus() == BridgeGameStatus.CONTINUE)
    }

    private fun getMovement(): String {
        var input: String
        do {
            input = inputView.askMovement()
            val isValid = validatorController.validateMovement(input)
        } while (!isValid)

        return input
    }

    private fun goToNextStep(gameStatus: BridgeGameStatus) {
        if (gameStatus == BridgeGameStatus.FAILURE) {
            stop()
        }

        if (gameStatus == BridgeGameStatus.SUCCESS) {
            finish()
        }
    }

    private fun stop() {}

    private fun getGameCommand(): String {
        var input: String
        do {
            input = inputView.askGameCommand()
            val isValid = validatorController.validateGameCommand(input)
        } while (!isValid)

        return input
    }

    private fun restart() {}

    private fun finish() {}
}