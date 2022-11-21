package bridge

import bridge.controller.BridgeGameController
import bridge.domain.Direction
import bridge.domain.Player
import bridge.domain.PlayerBlock
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeGameController = BridgeGameController(InputView(), OutputView())
    bridgeGameController.play()
}
