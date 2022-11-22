package bridge.domain

import bridge.BridgeRandomNumberGenerator
import bridge.view.View

class BridgeGameEngine {

    fun run() {
        View.printStartGame()

        val game = createGame()
        startGame(game)

        View.printResult(game.result)
    }

    private fun createGame(): BridgeGame {
        val bridgeSize = View.requestBridgeSize()

        return BridgeGame.Builder()
            .size(bridgeSize)
            .generator(BridgeRandomNumberGenerator())
            .build()
    }

    private tailrec fun startGame(game: BridgeGame) {
        progressByRound(game)

        if (!game.isCompleted && View.requestRetryGame()) {
            game.retry()
            startGame(game)
        }
    }

    private fun progressByRound(game: BridgeGame) {
        do {
            game.move(View.requestNextFloor())

            View.printMap(game.lastHistory)

        } while (game.isRunning)
    }
}