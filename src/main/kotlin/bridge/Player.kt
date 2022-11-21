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
        var gameSuccess = false
        for (turn in 0 until bridgeSize) {
            val (moveResult, moveDirect) = bridgeGame.move(turn, gameView.readMoving())
            gameView.writeMap(turn, moveResult, moveDirect)
            gameSuccess = moveResult == 'O'
            if (moveResult == 'X') break
        }
        if (!gameSuccess && gameView.readGameCommand() == GAME_COMMAND_RESTART) reStart()
        else finish(bridgeGame.getPlayCount(), gameSuccess)
    }

    private fun reStart() {
        bridgeGame.retry()
        playGame(bridgeSize)
    }

    private fun finish(playCount: Int, gameSuccess: Boolean) {
        gameView.writeResult(playCount, gameSuccess)
    }
}