package bridge.domain

import bridge.view.View

class BridgeGameEngine {

    private lateinit var game: BridgeGame

    fun run() {
        View.printStartGame()

        init()
        startGame()
    }

    private fun init() {
        val bridgeSize = View.requestBridgeSize()

        game = BridgeGame.Builder()
            .size(bridgeSize)
            .generator(BridgeRandomNumberGenerator())
            .build()
    }

    private tailrec fun startGame() {
        progressByRound()

        if (!game.isCompleted && View.requestRetryGame()) {
            game.retry()
            startGame()
        } else {
            View.printResult(game.result)
        }
    }

    private fun progressByRound() {
        do {
            if (!game.move(View.requestNextFloor())) {
                View.printMap(game.lastHistory)
                return
            }
            View.printMap(game.lastHistory)

        } while (game.isRunning)
    }
}