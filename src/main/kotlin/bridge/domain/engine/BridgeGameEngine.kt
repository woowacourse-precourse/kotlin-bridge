package bridge.domain.engine

import bridge.BridgeRandomNumberGenerator
import bridge.domain.game.BridgeGame
import bridge.view.View

class BridgeGameEngine {

    private lateinit var game: BridgeGame

    fun run() {
        View.printStartGame()

        game = makeBridgeGame(View.requestBridgeSize())

        startGame()

        View.printResult(game.getResult())
    }

    private tailrec fun startGame() {
        progressByRound()

        if (game.isFailure && View.requestRetryGame()) {
            game.retry()
            startGame()
        }
    }

    private fun progressByRound() {
        do {
            game.move(View.requestNextFloor())

            View.printMap(game.crossingMap)

        } while (game.isRunning)
    }

    private fun makeBridgeGame(bridgeSize: Int): BridgeGame {
        return BridgeGame.Builder()
            .size(bridgeSize)
            .generator(BridgeRandomNumberGenerator())
            .build()
    }
}