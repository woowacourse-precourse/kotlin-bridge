package bridge.controller

import bridge.ERROR
import bridge.ZERO
import bridge.view.InputView
import bridge.view.OutputView

class GameController {

    private var size = ZERO
    init {
        OutputView.startGame()
        getBridgeLength()
    }

    fun start() {
    }

    private fun getBridgeLength() {
        while (true) {
            try {
                OutputView.inputLength()
                size = InputView.readBridgeSize()
                break
            } catch (e: Exception) {
                println("$ERROR ${e.message}\n")
            }
        }
    }
}