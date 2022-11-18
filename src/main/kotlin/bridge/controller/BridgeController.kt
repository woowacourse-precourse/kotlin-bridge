package bridge.controller

import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        outputView.printStartText()
        val size = requireBridgeSize()
        val bridgeGame = makeBridgeGame(size)
        playBridgeGame(bridgeGame)
        outputView.printResult(bridgeGame)
    }

    private fun requireBridgeSize(): Int {
        outputView.printRequireBridgeSize()
        return inputView.readBridgeSize()
    }

    private fun makeBridgeGame(size: Int): BridgeGame {
        val bridge = Bridge.generate(size)
        return BridgeGame(bridge)
    }

    private fun playBridgeGame(bridgeGame: BridgeGame) {
        while (bridgeGame.isOnGoing()) {
            val moving = requireMoving()
            bridgeGame.move(moving)
            outputView.printMap(bridgeGame)
            if (bridgeGame.isFail()) {
                val command = requireGameCommand()
                bridgeGame.retry(command)
            }
        }
    }

    private fun requireMoving(): String {
        outputView.printRequireMoving()
        return inputView.readMoving()
    }

    private fun requireGameCommand(): String {
        outputView.printRequireGameCommand()
        return inputView.readGameCommand()
    }
}