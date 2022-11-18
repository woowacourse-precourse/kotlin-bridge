package bridge.controller

import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class BridgeController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        try {
            runUtil()
        } catch (e: IllegalArgumentException) {
            outputView.printException(e)
        } catch (e: IllegalStateException) {
            outputView.printException(e)
        }
    }

    private fun runUtil() {
        outputView.printStartText()

        val bridgeGame = makeBridgeGame(requireBridgeSize())
        playBridgeGame(bridgeGame)

        outputView.printResult(bridgeGame)
    }

    private fun requireBridgeSize(): Int {
        outputView.printRequireBridgeSize()
        return inputView.readBridgeSize()
    }

    private fun makeBridgeGame(size: Int): BridgeGame {
        val bridge = Bridge.generateRandomBridge(size)
        return BridgeGame(bridge)
    }

    private fun playBridgeGame(bridgeGame: BridgeGame) {
        while (bridgeGame.isOnGoing()) {
            bridgeGame.move(requireMoving())
            outputView.printMap(bridgeGame)

            if (bridgeGame.isFail()) {
                bridgeGame.retry(requireGameCommand())
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
