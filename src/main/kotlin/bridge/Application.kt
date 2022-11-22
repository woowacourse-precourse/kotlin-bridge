package bridge

import bridge.Controller.BridgeController

fun main() {
    try {
        var bridgeController = BridgeController()
        bridgeController.startGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

}
