package bridge.Controller

import bridge.View.InputView
import bridge.View.OutputView

class BridgeController {
    var inputView = InputView()
    var outputView = OutputView()

    fun startGame() {
        outputView.printStart()
        getBridgeSize()
    }

    fun getBridgeSize() {
        outputView.printBridgeSize()
        inputView.readBridgeSize()
    }
}