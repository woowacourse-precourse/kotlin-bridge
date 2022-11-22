package bridge

import bridge.controller.BridgeGameController

fun main() {
    val bridgeGameController = BridgeGameController()
    try {
        bridgeGameController.play()
    } catch (e: IllegalArgumentException) {
    }
}
