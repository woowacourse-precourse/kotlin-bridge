package bridge.controller

import bridge.domain.BridgeGame
import bridge.domain.Player
import bridge.util.BridgeNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run(bridgeNumberGenerator: BridgeNumberGenerator) {
        inputView.readStartGame()
        val player = Player()
        val bridgeGame = BridgeGame(bridgeNumberGenerator, inputView.readBridgeSize(), player)
        do {
            playGame(bridgeGame)
            if (bridgeGame.isDone()) break
        } while (bridgeGame.retry(inputView.readGameCommand()))
        outputView.printResult(bridgeGame)
    }

    private fun playGame(bridgeGame: BridgeGame) {
        do {
            bridgeGame.move(inputView.readMoving())
            outputView.printMap(bridgeGame)
            if (bridgeGame.isDone()) break
        } while (bridgeGame.isFail().not())
    }
}
