package bridge.controller

import bridge.BridgeRandomNumberGenerator
import bridge.domain.*
import bridge.sentence.InputSentence
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun play() {
        try {
            InputSentence.START.print()
            val bridgeGame = makeBridgeGame()
            startBridgeGame(bridgeGame)
            outputView.printResult(bridgeGame.getPlayer())
        } catch (exception: IllegalArgumentException) {
            println(exception.message)
        }
    }

    private fun startBridgeGame(bridgeGame: BridgeGame) {
        var inProgress = true
        while (inProgress) {
            val moveResult = bridgeGame.move(inputView.readMoving())
            outputView.printMap(moveResult)
            if (!bridgeGame.canContinue()) {
                inProgress = conductByGameCommand(bridgeGame, inputView.readGameCommand())
            }
            inProgress = !bridgeGame.isCompleted()
        }
    }

    private fun conductByGameCommand(bridgeGame: BridgeGame, gameCommand: GameCommand): Boolean =
        when (gameCommand) {
            GameCommand.RESTART -> {
                bridgeGame.retry()
                true
            }
            GameCommand.QUIT ->
                false
        }


    private fun makeBridgeGame(): BridgeGame {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridge = Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()))
        return BridgeGame(bridge, Player())
    }


}