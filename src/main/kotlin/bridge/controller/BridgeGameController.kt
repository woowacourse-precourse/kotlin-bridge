package bridge.controller

import bridge.domain.*
import bridge.view.InputView

class BridgeGameController {
    fun start() {
        val bridgeSize = inputBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        bridgeProgress(Bridge(bridge))
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

    private fun inputMoving(): String {
        while (true) {
            try {
                return InputView().readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun bridgeProgress(bridge: Bridge) {
        val player = Player()
        val bridgeGame = BridgeGame(player)
        while (!bridgeGame.isClear(bridge)) {
            val inputString = inputMoving()
            val gameProgressResult = bridgeGame.move(bridge, inputString)
        }
    }
}