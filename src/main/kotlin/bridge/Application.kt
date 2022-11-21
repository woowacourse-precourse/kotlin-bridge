package bridge

import bridge.model.BridgeResult
import bridge.view.InputView
import bridge.view.OutputView


fun main() {
    val bridgeGame = BridgeGame()
    val inputView = InputView()
    val outputView = OutputView()

    initBridgeGame(inputView, bridgeGame)
    with(bridgeGame) {
        play(inputView, outputView)
    }
}

private fun BridgeGame.play(inputView: InputView, outputView: OutputView) {
    do {
        val result = move(inputView.readMoving())
        outputView.printMap()
        calResult(result, outputView, inputView)
    } while (true)
}

private fun BridgeGame.calResult(
    result: BridgeResult,
    outputView: OutputView,
    inputView: InputView
) {
    when (result) {
        BridgeResult.FINISH -> outputView.printResult()
        BridgeResult.SUCCESS -> return
        BridgeResult.FAIL -> retry(inputView.readGameCommand())
    }
}

private fun initBridgeGame(inputView: InputView, bridgeGame: BridgeGame) {
    inputView.gameStart()
    bridgeGame.setBridge(bridgeGame.generateRandomBridge(inputView.readBridgeSize()))
}
