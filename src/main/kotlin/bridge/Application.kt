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

private fun progressStage(bridgeCurrentPosition: Int, bridge: List<String>): String {
    outputView.printMovingBridgeSelectPhrase()
    val userInput = inputView.readMoving()
    printStageMap(bridgeCurrentPosition, bridge, userInput)
    println()
    return userInput
}

private fun printStageMap(bridgeCurrentPosition: Int, bridge: List<String>, userInput: String) {
    outputView.printMap(
        bridgeGame.move(userInput, bridgeCurrentPosition, bridge),
        bridgeCurrentPosition,
        bridge
    )
}

private fun getProperGameState(): GameState {
    outputView.printRestartOrQuitSelectPhrase()
    return bridgeGame.retry(inputView.readGameCommand())
}

private fun printGameResultMap(bridgeCurrentPosition: Int, bridge: List<String>, lastUserInput: String) {
    outputView.printFinalGamsResultPhrase()
    printStageMap(bridgeCurrentPosition, bridge, lastUserInput)
    println()
}
