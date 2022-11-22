package bridge.controller

import bridge.BridgeGameStatus
import bridge.BridgeMaker
import bridge.domain.BridgeGame
import bridge.model.BridgeDTO
import bridge.model.BridgeGameMetadataDTO
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
        val bridgeDTO = makeBridge()
        bridgeGame.setBridge(bridgeDTO)

        outputView.printStepInterval()

        play()
    }

    private fun makeBridge(): BridgeDTO {
        val bridgeSize = getBridgeSize()
        val bridge = bridgeMaker.makeBridge(bridgeSize)
        return BridgeDTO(bridge)
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
            val metadata = move()
            outputView.printMap(metadata)

            outputView.printStepInterval()

            goToNextStep(metadata)
        } while (metadata.getGameStatus() == BridgeGameStatus.CONTINUE)
    }

    private fun move(): BridgeGameMetadataDTO {
        val movement = getMovement()
        return bridgeGame.move(movement)
    }

    private fun getMovement(): String {
        var input: String
        do {
            input = inputView.askMovement()
            val isValid = validatorController.validateMovement(input)
        } while (!isValid)

        return input
    }

    private fun goToNextStep(metadata: BridgeGameMetadataDTO) {
        val gameStatus = metadata.getGameStatus()
        if (gameStatus == BridgeGameStatus.FAILURE) {
            stop(metadata)
        }

        if (gameStatus == BridgeGameStatus.SUCCESS) {
            finish(metadata)
        }
    }

    private fun stop(metadata: BridgeGameMetadataDTO) {
        val command = getGameCommand()
        if (command == "R") {
            restart()
            return
        }
        finish(metadata)
    }

    private fun getGameCommand(): String {
        var input: String
        do {
            input = inputView.askGameCommand()
            val isValid = validatorController.validateGameCommand(input)
        } while (!isValid)

        return input
    }

    private fun restart() {
        bridgeGame.retry()

        play()
    }

    private fun finish(metadata: BridgeGameMetadataDTO) {
        outputView.printResult(metadata)
    }
}