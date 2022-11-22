package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView

class GameController() {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var size = 0

    fun initGame() {
        outputView.printOpening()
        size = inputView.readBridgeSize()
    }

}