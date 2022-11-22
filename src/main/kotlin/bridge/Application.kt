package bridge

import bridge.view.InputView
import bridge.view.OutputView

val outputView = OutputView()
val inputView = InputView()

fun main() {
    startGame()
    val bridge = makeBridge()
}

private fun startGame() {
    outputView.printGameStartPhrase()
    println()
}

private fun makeBridge(): List<String> {
    outputView.printBridgeSizePhrase()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(inputView.readBridgeSize())
    println()
    return bridge
}

