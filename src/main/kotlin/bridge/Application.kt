package bridge

import bridge.resources.INPUT_BRIDGE_GAME_START
import bridge.view.*

fun main() {
    println(INPUT_BRIDGE_GAME_START)
    val bridgeLength = InputView().readBridgeSize()
    val b = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeLength)
    OutputView().printMap(b, 4, false)
    // BridgeGame의 인스턴스로 넣자.

}
