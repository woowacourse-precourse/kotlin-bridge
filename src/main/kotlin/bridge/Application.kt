package bridge

import bridge.utils.Print
import bridge.view.InputView

fun main() {
    Print.showStartMessage()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(InputView().readBridgeSize())
    MoveBridge(bridge).moveStair()
}