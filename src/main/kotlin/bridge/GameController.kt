package bridge

import bridge.common.GameCommand
import bridge.common.GameResult
import bridge.common.GameState
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

private const val INVALID_ERROR = "[ERROR] 예상된 에러 메시지가 넘어오지 않았습니다."

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var bridgeGame: BridgeGame
    private lateinit var gameState: GameState
    private var tryCount: Int = 1

    fun standByPhase(bridgeMaker: BridgeMaker) {
        val bridgeSize = enterBridgeSize()
        outputView.printBlank()
        bridgeGame = BridgeGame(bridgeMaker.makeBridge(bridgeSize))
        gameState = GameState.IN_GAME
    }

    private fun enterBridgeSize(): Int {
        return try {
            outputView.printGameStart()
            inputView.readBridgeSize()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message ?: INVALID_ERROR)
            enterBridgeSize()
        }
    }

    fun mainPhase() {
        while (gameState == GameState.IN_GAME) {
            play()
            checkRetry()
        }
    }

    fun endPhase() {
        val gameResult = GameResult(
            bridgeGame.currentUpperBridge,
            bridgeGame.currentDownerBridge,
            gameState,
            tryCount
        )
        outputView.printResult(gameResult)
    }

    private fun play() {
        gameState = bridgeGame.move(enterUserDirection())
        outputView.printMap(bridgeGame.currentUpperBridge, bridgeGame.currentDownerBridge)
    }

    private fun enterUserDirection(): String {
        return try {
            outputView.printUpDownRequest()
            inputView.readMoving()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message ?: INVALID_ERROR)
            enterUserDirection()
        }
    }

    private fun checkRetry() {
        if (gameState != GameState.FAILURE) return
        if (enterRetryOrEnd() == GameCommand.R) {
            retryGame()
        }
    }

    private fun enterRetryOrEnd(): GameCommand {
        return try {
            outputView.printRetryRequest()
            inputView.readGameCommand()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message ?: INVALID_ERROR)
            enterRetryOrEnd()
        }
    }

    private fun retryGame() {
        bridgeGame.retry()
        gameState = GameState.IN_GAME
        tryCount++
    }
}
