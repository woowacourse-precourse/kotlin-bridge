package bridge

import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val showInputView = InputView()
    val outputView = OutputView()
    val bridgeGame = BridgeGame()
    val bridgeSize = showInputView.readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    playGame(showInputView,bridgeGame,bridge)

    outputView.printResult(bridgeGame.userBridge, bridge)
    outputView.printSuccess(bridgeGame.gameSuccess)
    outputView.printTryGameNumber(bridgeGame.tryNumber)
}

fun playGame(showInputView: InputView, bridgeGame: BridgeGame, bridge: List<String>) {
    var gameOver = true
    while (gameOver) {
        val moveDirection = showInputView.readMoving()
        if (!bridgeGame.move(moveDirection, bridge))
            gameOver = bridgeGame.retry(showInputView.readGameCommand())
        if (bridge.size == bridgeGame.userBridge.size) {
            gameOver = false
            bridgeGame.gameSuccess = true
        }
    }
}
