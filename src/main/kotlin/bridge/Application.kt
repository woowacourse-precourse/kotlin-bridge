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

    while (true) {
        val moveDirection = checkInput.checkMoveDirection(showInputView.readMoving())
        if(!bridgeGame.move(moveDirection, bridge)){
            var gameOver = showInputView.readGameCommand()

        }

    }
}
