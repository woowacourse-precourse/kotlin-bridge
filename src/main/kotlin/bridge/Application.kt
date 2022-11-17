package bridge

import bridge.resources.INPUT_BRIDGE_GAME_START
import bridge.view.*
import java.lang.IllegalArgumentException

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    try {
    val bridgeLength = InputView().readBridgeSize()
    val bridgeGame = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    BridgeGame(bridgeGame, 1).move(0) } catch (_: IllegalArgumentException){
    }

}
