package bridge.controller

import bridge.domain.BridgeGame
import bridge.domain.Player
import bridge.BridgeNumberGenerator
import bridge.domain.Bridge
import bridge.view.InputView
import bridge.view.OutputView

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run(bridgeNumberGenerator: BridgeNumberGenerator) {
        inputView.readStartGame()
        val player = Player()
        val bridge = Bridge(bridgeNumberGenerator, inputView.readBridgeSize())
        val bridgeGame = BridgeGame(player, bridge)
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
