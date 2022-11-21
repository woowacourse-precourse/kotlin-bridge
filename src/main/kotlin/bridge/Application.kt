package bridge

import bridge.domain.BridgeMaker
import bridge.domain.BridgeRandomNumberGenerator
import bridge.domain.BridgeChecker
import bridge.ui.InputView
import bridge.utils.GAME_START_MSG
import bridge.utils.SIZE_INPUT_MSG

fun main() {
    println(GAME_START_MSG)
    val inputView = InputView()

    println(SIZE_INPUT_MSG)
    val bridgeSize = inputView.readBridgeSize()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    println(bridge)

    val checker = BridgeChecker(bridge)
    checker.checkBridge()
}