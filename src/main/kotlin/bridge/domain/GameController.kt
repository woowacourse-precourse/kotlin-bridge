package bridge.domain

import bridge.ui.OutputView

class GameController() {
    private val outputView = OutputView()

    fun initGame() {
        outputView.printOpening()
    }
}