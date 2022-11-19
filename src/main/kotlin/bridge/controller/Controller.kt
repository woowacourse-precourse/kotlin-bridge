package bridge.controller

import bridge.domain.BridgeGame
import bridge.util.BridgeNumberGenerator
import bridge.view.InputView
import bridge.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run(bridgeNumberGenerator: BridgeNumberGenerator) {
        inputView.readStartGame()
        val bridgeGame = BridgeGame(bridgeNumberGenerator, inputView.readBridgeSize())
        do {
            playGame(bridgeGame)
            if (bridgeGame.isDone()) break
        } while (bridgeGame.retry(inputView.readGameCommand()))
        outputView.printResult(bridgeGame)
    }

    private fun playGame(bridgeGame: BridgeGame) {
        do {
            bridgeGame.move(inputView.readMoving())
            println(bridgeGame.getBridge())
            outputView.printMap(bridgeGame)
            if (bridgeGame.isDone()) break
        } while (bridgeGame.isFail().not())
    }
}
