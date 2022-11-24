package bridge.domain.engine

import bridge.BridgeRandomNumberGenerator
import bridge.domain.game.BridgeGame
import bridge.view.View

class BridgeGameEngine {

    private lateinit var game: BridgeGame

    fun run() {
        View.printStartGame()

        game = makeBridgeGame(View.requestBridgeSize())

        startGameRecursively()

        View.printResult(game.getResult())
    }

    private fun makeBridgeGame(bridgeSize: Int): BridgeGame {
        return BridgeGame.Builder()
            .size(bridgeSize)
            .generator(BridgeRandomNumberGenerator())
            .build()
    }

    private tailrec fun startGameRecursively() {
        crossBridgeOneCycle()

        if (game.isFailure && View.requestRetryGame()) {
            game.retry()
            startGameRecursively()
        }
    }

    private fun crossBridgeOneCycle() {
        do {
            game.move(View.requestNextFloor())

            View.printMap(game.crossingMap)

        } while (game.isRunning)
    }
}