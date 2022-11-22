package bridge

import bridge.controller.BridgeGameController

fun main() {
    try {
        val bridgeGameController = BridgeGameController()
        bridgeGameController.run()
    } catch (except: IllegalArgumentException) {
        println(except.message)
    }
}
