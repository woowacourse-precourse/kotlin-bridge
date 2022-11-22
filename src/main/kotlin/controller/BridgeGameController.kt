package controller

import bridge.BridgeGame
import view.InputView
import view.OutputView

class BridgeGameController {
    private lateinit var bridgeGame: BridgeGame
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeLength: Int = 0

    fun startBridgeGame() {
        outputView.printGameStartNotification()
        bridgeLength = inputBridgeSize()
        bridgeGame = BridgeGame(bridgeLength)
        startGame()
    }

    private fun startGame() {
        while (bridgeGame.getRestartGame()) {
            bridgeGame.initStartGame()
            if (judgePlayerSelected(bridgeLength) == bridgeLength) {
                outputView.printResult(bridgeGame.getOXBridge(), bridgeGame.getTotalAttempts(), SUCCESS)
                bridgeGame.setRestartGame(false)
            }
        }
    }

    private fun judgePlayerSelected(bridgeLength: Int): Int {
        for (index in 0 until bridgeLength) {
            val move = inputPlayerUpDownMove()
            bridgeGame.move(move, index)
            outputView.printMap(bridgeGame.getOXBridge())
            if (checkBridgeContainX()) break
        }
        return bridgeGame.getCorrectNum()
    }

    private fun checkBridgeContainX(): Boolean {
        if (bridgeGame.getOXBridge()[0].contains(WRONG) || bridgeGame.getOXBridge()[1].contains(WRONG)) {
            checkRetryQuitCommand()
            return true
        }
        return false
    }

    private fun checkRetryQuitCommand() {
        if (bridgeGame.retry(inputRetryQuitCommand())) {
            if (bridgeGame.getShowBridgeResult()) {
                outputView.printResult(
                    bridgeGame.getOXBridge(),
                    bridgeGame.getTotalAttempts(),
                    FAIL
                )
            }
        }
    }

    private fun inputBridgeSize(): Int {
        return inputView.inputValidBridgeSize()
    }

    private fun inputPlayerUpDownMove(): String {
        return inputView.inputValidMove()
    }

    private fun inputRetryQuitCommand(): String {
        return inputView.inputValidCommand()
    }

    companion object {
        const val WRONG = "X"
        const val SUCCESS = "SUCCESS"
        const val FAIL = "FAIL"
    }
}
