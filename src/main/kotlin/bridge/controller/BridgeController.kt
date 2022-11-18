package bridge.controller

import bridge.model.Bridge
import bridge.model.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

/**
 * 모델과 뷰를 연결해 게임을 진행하는 역활을 한다.
 *
 * 상황과 순서에 맞는 메서드 호출에 대한 책임을 가진다.
 * 잘못된 입력시 재입력 요구에 대한 책임을 가진다.
 */
class BridgeController {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun startGame() {
        try {
            startGameUtil()
        } catch (e: IllegalStateException) {
            outputView.printException(e)
        }
    }

    private fun startGameUtil() {
        outputView.printStartText()

        val bridgeGame = runUntilValid { makeBridgeGame() }
        playBridgeGame(bridgeGame)

        outputView.printResult(bridgeGame)
    }

    private fun <T> runUntilValid(method: () -> T): T {
        while (true) {
            try {
                return method()
            } catch (e: IllegalArgumentException) {
                outputView.printException(e)
            }
        }
    }

    private fun requireBridgeSize(): Int {
        outputView.printRequireBridgeSize()
        return inputView.readBridgeSize()
    }

    private fun makeBridgeGame(): BridgeGame {
        val size = requireBridgeSize()
        val bridge = Bridge.generateRandomBridge(size)
        return BridgeGame(bridge)
    }

    private fun playBridgeGame(bridgeGame: BridgeGame) {
        while (bridgeGame.isOnGoing()) {
            runUntilValid { move(bridgeGame) }
            outputView.printMap(bridgeGame)
            if (bridgeGame.isFailed()) {
                runUntilValid { retry(bridgeGame) }
            }
        }
    }

    private fun requireMoving(): String {
        outputView.printRequireMoving()
        return inputView.readMoving()
    }

    private fun move(bridgeGame: BridgeGame) {
        val moving = requireMoving()
        bridgeGame.move(moving)
    }

    private fun requireGameCommand(): String {
        outputView.printRequireGameCommand()
        return inputView.readGameCommand()
    }

    private fun retry(bridgeGame: BridgeGame) {
        val command = requireGameCommand()
        bridgeGame.retry(command)
    }
}
