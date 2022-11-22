package bridge

import bridge.domain.BridgeGameController

private val bridgeGameController = BridgeGameController()

fun main() {
    bridgeGameController.start()
    bridgeGameController.play()
}