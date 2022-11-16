package bridge

import bridge.resources.INPUT_BRIDGE_GAME_START
import bridge.view.*

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    val bridgeLength = InputView().readBridgeSize()
    println(bridgeLength)
    val b = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    println(b)
}
