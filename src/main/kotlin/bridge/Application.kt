package bridge

import bridge.domain.BridgeGame
import bridge.domain.BridgeGameManager
import bridge.domain.BridgeMaker
import bridge.view.InputView
import bridge.view.OutputView

fun main() {
    try {
        val gameManager = BridgeGameManager(InputView(), OutputView())
        val bridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
        val bridgeGame = BridgeGame(gameManager, bridgeMaker)
        bridgeGame.runGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
