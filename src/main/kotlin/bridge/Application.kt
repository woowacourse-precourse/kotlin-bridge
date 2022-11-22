package bridge

import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    val showInputView = InputView()
    val bridgeGame = BridgeGame()

    val bridgeSize = showInputView.readBridgeSize()
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
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
    OutputView().printResult(bridgeGame.userBridge, bridge)
    OutputView().printSuccess(bridgeGame.gameSuccess)
    OutputView().printTryGameNumber(bridgeGame.tryNumber)
}
