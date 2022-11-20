package bridge.controller

import bridge.ERROR
import bridge.ZERO
import bridge.model.Bridge
import bridge.view.InputView
import bridge.view.OutputView

class GameController {

    private val bridge = Bridge()
    private var size = ZERO

    init {
        OutputView.startGame()
        getBridgeLength()
        println()
        bridge.getBridge(size)
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