package bridge

import bridge.game.Bridge
import bridge.game.BridgeGame
import bridge.game.Status
import bridge.io.InputView
import bridge.io.OutputView
import bridge.resources.GAME_INTRO

fun main() {
    println(GAME_INTRO)
    val maker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridgePath = maker.makeBridge(InputView().readBridgeSize())
    val gameManager = BridgeGame(bridgePath, Bridge(mutableListOf(), InputView(), OutputView()), Status())

    println()
    gameManager.play()
}
