package bridge.domain.engine

import bridge.BridgeRandomNumberGenerator
import bridge.domain.game.BridgeGame
import bridge.view.View

class BridgeGameEngine {

    private lateinit var game: BridgeGame

    fun init() {
        val bridgeSize = View.requestBridgeSize()

        game = BridgeGame.Builder()
            .size(bridgeSize)
            .generator(BridgeRandomNumberGenerator())
            .build()
    }

    fun run() {
        View.printStartGame()

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
}