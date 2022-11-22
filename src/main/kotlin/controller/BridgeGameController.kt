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
