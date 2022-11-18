package bridge.controller

import bridge.view.InputView

class BridgeGameController {
    fun start() {
        val bridgeSize = inputBridgeSize()
    }

    private fun inputBridgeSize(): Int {
        while (true) {
            try {
                return InputView().readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}