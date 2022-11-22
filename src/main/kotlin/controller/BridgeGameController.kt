package controller

import bridge.BridgeGame
import view.InputView
import view.OutputView

class BridgeGameController {
    private lateinit var bridgeGame: BridgeGame
    private val inputView = InputView()
    private val outputView = OutputView()
    private var bridgeSize: Int = 0

    fun startBridgeGame() {
        outputView.printGameStartNotification()
        bridgeSize = inputBridgeSize()
        bridgeGame = BridgeGame(bridgeSize)
        startGame()
    }

    private fun startGame() {
        while (bridgeGame.getRestart()) {
            bridgeGame.initStartGame()
            if (judgePlayerSelected(bridgeSize) == bridgeSize) {
                OutputView().printResult(bridgeGame.getOXBridge(), bridgeGame.getTotalAttempts(), "SUCCESS")
                bridgeGame.setRestart(false)
            }
        }
    }

    private fun judgePlayerSelected(bridgeLength: Int): Int {
        for (index in 0 until bridgeLength) {
            val move = inputMove()
            bridgeGame.move(move, index)
            OutputView().printMap(bridgeGame.getOXBridge())
        }
        return bridgeGame.getCorrectDirection()
    }

    private fun inputBridgeSize(): Int {
        return inputView.inputValidBridgeSize()
    }

    private fun inputMove(): String {
        return inputView.inputValidMove()
    }

    private fun inputCommand(): String {
        return inputView.inputValidCommand()
    }
}
