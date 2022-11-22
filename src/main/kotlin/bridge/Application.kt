package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeMaker
import bridge.domain.InputCheck

fun main() {
    val checkInput = InputCheck()
    val showInputView = InputView()
    val bridgeGame = BridgeGame()

    val bridgeSize = checkInput.checkBridgeSize(showInputView.readBridgeSize())
    val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
    var gameOver = true
    while (gameOver) {
        val moveDirection = checkInput.checkMoveDirection(showInputView.readMoving())
        if (!bridgeGame.move(moveDirection, bridge))
            gameOver = bridgeGame.retry(checkInput.checkRetry(showInputView.readGameCommand()))
    }
    OutputView().printResult(bridgeGame.userBridge, bridge)
}
