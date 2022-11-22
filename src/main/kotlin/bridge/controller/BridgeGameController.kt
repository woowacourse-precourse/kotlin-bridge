package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.*
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController {
    fun start() {
        val bridgeSize = inputBridgeSize()
        val bridge = BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(bridgeSize)
        val player = Player(Bridge(bridge))
        val game = BridgeGame(player)
        bridgeProgress(game)
        OutputView().printResult(game)
    }

    private fun inputBridgeSize(): Int {
        while (true) {
            try {
                return InputView().readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputMoving(): String {
        while (true) {
            try {
                return InputView().readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputGameCommand(): String {
        while (true) {
            try {
                return InputView().readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun bridgeProgress(bridgeGame: BridgeGame) {
        while (!bridgeGame.isClear()) {
            if (moving(bridgeGame)) {
                continue
            }
            if (!retry(bridgeGame)) {
                break
            }
        }
    }

    private fun moving(bridgeGame: BridgeGame): Boolean {
        val inputMove = inputMoving()
        val successOrFail = bridgeGame.move(inputMove)
        OutputView().printMap(bridgeGame)
        return successOrFail
    }

    private fun retry(bridgeGame: BridgeGame): Boolean {
        val inputRetryCommand = inputGameCommand()
        return bridgeGame.retry(inputRetryCommand)
    }
}