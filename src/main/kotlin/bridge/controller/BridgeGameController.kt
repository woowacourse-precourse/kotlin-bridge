package bridge.controller

import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.view.InputView

class BridgeGameController {
    fun start() {
        val bridgeSize = inputBridgeSize()
        val madeBridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
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