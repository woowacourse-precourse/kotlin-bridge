package bridge

import bridge.BridgeGame.Companion.GAME_COMMAND_RESTART

class Player(
    private val gameView: GameView,
    private val bridgeGame: BridgeGame,
) {

    private var bridgeSize = 0

    fun startGame() {
        bridgeSize = gameView.readBridgeSize()
        bridgeGame.start(bridgeSize)
        playGame(bridgeSize)
    }

    private fun playGame(bridgeSize: Int) {
        for (turn in 0 until bridgeSize) {
            val (moveResult, moveDirect) = bridgeGame.move(turn, gameView.readMoving())
            gameView.writeMap(turn, moveResult, moveDirect)
            if (moveResult == 'X') break
        }
        if (gameView.readGameCommand() == GAME_COMMAND_RESTART) reStart()
        else finish()
    }

    private fun reStart() {
        bridgeGame.retry()
        playGame(bridgeSize)
    }

    private fun finish() {
        println("종료")
    }
}