package controller

import view.InputView

class BridgeGameController {
    private val inputView = InputView()

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
