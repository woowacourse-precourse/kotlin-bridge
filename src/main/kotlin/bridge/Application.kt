package bridge

import bridge.controller.BridgeGameController
import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.InputView
import bridge.enums.Status
import bridge.ui.OutputView
import bridge.util.BridgeRandomNumberGenerator



fun main() {
    val bridgeGameController = BridgeGameController()
    bridgeGameController.play()
}