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
class BridgeGameController {
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

        val bridgeGame = runUntilValid { readSizeAndMakeBridgeGame() }
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

    private fun readBridgeSize(): Int {
        outputView.printRequestBridgeSize()
        return inputView.readBridgeSize()
    }

    private fun readSizeAndMakeBridgeGame(): BridgeGame {
        val size = readBridgeSize()
        val bridge = Bridge.generateRandomBridge(size)
        return BridgeGame(bridge)
    }

    private fun playBridgeGame(bridgeGame: BridgeGame) {
        while (bridgeGame.isOnGoing()) {
            runUntilValid { readMovingAndMove(bridgeGame) }
            outputView.printMap(bridgeGame)
            if (bridgeGame.isFailed()) {
                runUntilValid { readCommandAndRetry(bridgeGame) }
            }
        }
    }

    private fun readMoving(): String {
        outputView.printRequestMoving()
        return inputView.readMoving()
    }

    private fun readMovingAndMove(bridgeGame: BridgeGame) {
        val moving = readMoving()
        bridgeGame.move(moving)
    }

    private fun readGameCommand(): String {
        outputView.printRequestGameCommand()
        return inputView.readGameCommand()
    }

    private fun readCommandAndRetry(bridgeGame: BridgeGame) {
        val command = readGameCommand()
        bridgeGame.retry(command)
    }
}
