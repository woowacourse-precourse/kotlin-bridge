package bridge

import bridge.view.InputView
import bridge.view.OutputView
import bridge.domain.BridgeGameController

private val inputView = InputView()
private val outputView = OutputView()
private val bridgeGameController = BridgeGameController()

fun main() {
    outputView.printStartMent()
    val bridge = generateBridge(readBridgeSize())
private fun generateBridge(size: Int): List<String> {
    val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
    return bridgeMaker.makeBridge(size)
}
