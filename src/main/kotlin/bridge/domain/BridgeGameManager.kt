package bridge.domain

import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameManager(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun startGame() {
        outputView.printStart()
    }

    fun getBridgeSize(): Int {
        while (true) {
            try {
                return inputView.readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }

    fun getMovement(): String {
        while (true) {
            try {
                return inputView.readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        }
    }
}