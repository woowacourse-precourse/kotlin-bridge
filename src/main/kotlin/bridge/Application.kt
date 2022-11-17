package bridge

import bridge.resources.INPUT_BRIDGE_GAME_START
import bridge.resources.START_LOCATION
import bridge.resources.START_TRY
import bridge.view.InputView
import java.lang.IllegalArgumentException

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    try {
    val bridgeLength = InputView().readBridgeSize()
    val bridgeGame = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    println(bridgeGame)
    BridgeGame(bridgeGame, START_TRY).move(START_LOCATION) } catch (_: IllegalArgumentException){
    }

}
