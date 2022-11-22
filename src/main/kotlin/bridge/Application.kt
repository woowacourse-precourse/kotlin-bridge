package bridge

import bridge.controller.BridgeGameProgress
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    OutputView().printGameStart()
    val input = InputView()
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    OutputView().printInputBridgeLength()
    val bridgeSize = input.readBridgeSize()
    val bridge = bridgeMaker.makeBridge(bridgeSize)
    BridgeGameProgress().bridgeGameProgress(bridge)
}