package bridge.domain

import bridge.BridgeGame
import bridge.ui.InputView
import bridge.ui.OutputView

class BridgeState {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    private var playerMoves = mutableListOf<List<String>>()
    fun compare(bridge: Bridge): Boolean {
        for (index in 0 until bridge.getSize()) {
            val upOrDown = inputView.readMoving()
            val alive = bridge.crossable(index, upOrDown)
            insertMove(upOrDown, alive)
            if (!alive) return false
        }
        outputView.printResult(playerMoves)
        return true
    }

    private fun insertMove(upOrDown: String, alive: Boolean) {
        playerMoves = bridgeGame.move(playerMoves, upOrDown, alive)
        outputView.printMap(playerMoves)
    }
}