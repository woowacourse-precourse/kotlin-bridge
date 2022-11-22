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
        InputSentence.START.print()
        val bridgeGame = makeBridgeGame()
        startBridgeGame(bridgeGame)
        outputView.printResult(bridgeGame.getPlayer())
    }

    private fun startBridgeGame(bridgeGame: BridgeGame) {
        var inProgress = true
        while (inProgress) {
            val moveResult = getMoveResult(bridgeGame)
            outputView.printMap(moveResult)
            if (!bridgeGame.canContinue())
                inProgress = gameCommandResult(bridgeGame)
            inProgress = !bridgeGame.isCompleted()
        }
    }

    private fun conductByGameCommand(bridgeGame: BridgeGame, gameCommand: GameCommand): Boolean =
        when (gameCommand) {
            GameCommand.RESTART -> {
                bridgeGame.retry()
                true
            }
            GameCommand.QUIT -> false
        }

    private fun makeBridgeGame(): BridgeGame {
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        var bridge: Bridge = makeBridge(bridgeMaker)
        return BridgeGame(bridge, Player())
    }

    private fun makeBridge(bridgeMaker: BridgeMaker): Bridge {
        var bridge: Bridge
        while (true) {
            try {
                bridge = Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()))
                break
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            }
        }
        return bridge
    }

    private fun getMoveResult(bridgeGame: BridgeGame): List<PlayerBlock> {
        var moveResult: List<PlayerBlock>
        while (true) {
            try {
                moveResult = bridgeGame.move(inputView.readMoving())
                break
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            }
        }
        return moveResult
    }

    private fun gameCommandResult(bridgeGame: BridgeGame): Boolean {
        var gameCommandResult: Boolean
        while (true) {
            try {
                gameCommandResult = conductByGameCommand(bridgeGame, inputView.readGameCommand())
                break
            } catch (exception: IllegalArgumentException) {
                println(exception.message)
            }
        }
        return gameCommandResult
    }
}