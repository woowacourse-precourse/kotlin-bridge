package bridge

import bridge.controller.BridgeGameController
import bridge.view.InputView
import bridge.view.OutputView
import java.lang.Exception

fun main() {
    try {
        val bridgeGameController = BridgeGameController(
            bridgeGame = BridgeGame(),
            inputView = InputView(),
            outputView = OutputView()
        )
        bridgeGameController.play()
    } catch (error: Exception) {
        println(error.message)
    }
}

