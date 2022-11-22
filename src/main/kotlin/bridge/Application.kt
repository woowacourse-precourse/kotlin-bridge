package bridge

import bridge.controller.BridgeGameController

private val bridgeGameController = BridgeGameController()

fun main() {
    bridgeGameController.start()
    bridgeGameController.play()
}
