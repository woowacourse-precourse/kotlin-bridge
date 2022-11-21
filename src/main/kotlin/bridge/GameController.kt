package bridge

import bridge.common.GameCommand
import bridge.common.GameResult
import bridge.common.GameState
import bridge.domain.BridgeGame
import bridge.domain.constructor.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

class GameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private lateinit var bridgeGame: BridgeGame
    private lateinit var gameState: GameState
    private var tryCount: Int = 1

    fun standByPhase(bridgeMaker: BridgeMaker) {
        outputView.printGameStart()
        val bridgeSize = inputView.readBridgeSize()
        outputView.printBlank()
        bridgeGame = BridgeGame(bridgeMaker.makeBridge(bridgeSize))
        gameState = GameState.IN_GAME
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
        outputView.printUpDownRequest()
        gameState = bridgeGame.move(inputView.readMoving())
        outputView.printMap(bridgeGame.currentUpperBridge, bridgeGame.currentDownerBridge)
    }

    private fun checkRetry() {
        if (gameState != GameState.FAILURE) return
        outputView.printRetryRequest()
        if (inputView.readGameCommand() == GameCommand.R) {
            retryGame()
        }
    }

    private fun retryGame() {
        bridgeGame.retry()
        gameState = GameState.IN_GAME
        tryCount++
    }
}
