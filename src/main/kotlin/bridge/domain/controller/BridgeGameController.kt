package bridge.domain.controller

import bridge.data.GameResult
import bridge.data.InputDataSource.bridgeState
import bridge.data.InputDataSource.gameCommand
import bridge.data.InputDataSource.initAllDataSource
import bridge.data.InputDataSource.movingCommands
import bridge.domain.validator.*
import bridge.ui.InputView.Companion.INPUT_BRIDGE_LENGTH
import bridge.ui.InputView.Companion.INPUT_RETRY_OR_QUIT
import bridge.ui.InputView.Companion.INPUT_UP_OR_DOWN
import bridge.ui.OutputView.Companion.PRINT_START_GAME
import bridge.ui.Views

class BridgeGameController(
    private val validateUseCase: ValidateUseCase = ValidateUseCase(),
    private val bridgeGame: BridgeGame = BridgeGame(),
    private val views: Views = Views()
) {
    init {
        initAllDataSource()
        println(PRINT_START_GAME)
    }

    fun startGame() {
        processBridgeSize()
        bridgeGame.generateBridge()
        processMoving()
        if (!isSuccess()) {
            processGameCommand()
        }
    }

    private fun retryGame() {
        bridgeGame.retry()
        processMoving()
        if (!isSuccess()) {
            processGameCommand()
        }
    }

    private fun processBridgeSize() {
        println(INPUT_BRIDGE_LENGTH)
        validateUseCase.validateBridgeSize()
    }

    private fun processMoving() {
        do {
            println(INPUT_UP_OR_DOWN)
            validateUseCase.validateMoving()
            if (movingCommands == bridgeState) {
                views.outputView.printResult(GameResult.Success)
                break
            }
        } while (isSurvive())
    }

    private fun processGameCommand() {
        println(INPUT_RETRY_OR_QUIT)
        validateUseCase.validateGameCommand()
        when (gameCommand) {
            RETRY -> retryGame()
            QUIT -> views.outputView.printResult(judgeGameResult())
        }
    }

    private fun judgeGameResult(): GameResult {
        return if (isSurvive()) GameResult.Success else GameResult.Failure
    }

    private fun isSurvive(): Boolean {
        return movingCommands.last() == bridgeState[movingCommands.size - 1]
    }

    private fun isSuccess(): Boolean {
        return movingCommands == bridgeState
    }

    companion object {
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}