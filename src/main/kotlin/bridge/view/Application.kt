package bridge.view

import bridge.BridgeRandomNumberGenerator
import bridge.controller.BridgeGame
import bridge.model.BridgeMaker
import bridge.util.ERROR_INVALID_INPUT_MESSAGE

fun main() {
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgeGame = BridgeGame(bridgeMaker, OutputView(), InputView())
    try {
        bridgeGame.start()
    } catch (e: NullPointerException) {
        println(ERROR_INVALID_INPUT_MESSAGE)
    }
}
