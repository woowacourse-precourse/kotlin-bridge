package bridge

import bridge.view.InputView
import bridge.view.OutputView

val outputView = OutputView()
val inputView = InputView()
val bridgeGame = BridgeGame()

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

private fun progressStage(bridgeCurrentPosition: Int, bridge: List<String>) {
    outputView.printMovingBridgeSelectPhrase()
    outputView.printMap(
        bridgeGame.move(inputView.readMoving(), bridgeCurrentPosition, bridge),
        bridgeCurrentPosition,
        bridge
    )
    println()
}

private fun getProperGameState(): GameState {
    outputView.printRestartOrQuitSelectPhrase()
    return bridgeGame.retry(inputView.readGameCommand())
}
