package bridge

import bridge.controller.BridgeGame
import bridge.util.ERROR_INVALID_INPUT_MESSAGE
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeGame = BridgeGame(bridgeMaker, OutputView(), InputView())
    try {
        bridgeGame.start()
    } catch (e: NullPointerException) {
        println(ERROR_INVALID_INPUT_MESSAGE)
    }
}
