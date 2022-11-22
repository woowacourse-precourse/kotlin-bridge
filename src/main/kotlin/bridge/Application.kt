package bridge

import bridge.game.Bridge
import bridge.game.BridgeGame
import bridge.game.Status
import bridge.io.InputView
import bridge.io.OutputView
import bridge.resources.GAME_INTRO

fun main() {
    println(GAME_INTRO)
    val input = InputView()
    val maker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = maker.makeBridge(input.readBridgeSize())
    val gameManager = BridgeGame(bridge, Bridge(mutableListOf<String>(), InputView(), OutputView()), Status())
    println(bridge)
    println()
    gameManager.play()
}
