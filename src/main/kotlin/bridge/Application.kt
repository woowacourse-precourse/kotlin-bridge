package bridge

import bridge.domain.BridgeMaker
import bridge.domain.InputView
import bridge.ui.OutputView

val outputView = OutputView()
val inputView = InputView()

fun main() {
    play()
}

fun play() {
    outputView.printStart()
    val bridgeSize = inputView.retryReadBridgeSize()



}