package bridge.domain.engine

import bridge.BridgeRandomNumberGenerator
import bridge.domain.game.BridgeGame
import bridge.view.View

class BridgeGameEngine {

    fun run() {
        View.printStartGame()

        val game = makeGame()
        startGame(game)

        View.printResult(game.result)
    }

    private fun makeGame(): BridgeGame {
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