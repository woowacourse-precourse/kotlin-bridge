package bridge

import view.InputView
import view.OutputView

class BridgeState {

    private val inputView = InputView()
    private val outputView = OutputView()

    private var _bridgeLength = 0

    fun inputBridgeLengthPart() {
        outputView.printStartGame()
        println()
        outputView.printInputBridgeLength()
        _bridgeLength = inputView.readBridgeSize()
    }

}
