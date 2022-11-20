package bridge.Controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Model.BridgeData.bridgeSize
import bridge.View.InputView
import bridge.View.OutputView

class BridgeController {
    var inputView = InputView()
    var outputView = OutputView()

    fun startGame() {
        outputView.printStart()
        getBridgeSize()
        makeBridge()
        getBridgeSelect()
    }

    fun getBridgeSize() {
        outputView.printBridgeSize()
        bridgeSize = inputView.readBridgeSize()
    }

    fun makeBridge() {
        var bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        var bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        bridgeMaker.makeBridge(bridgeSize)
    }

    fun getBridgeSelect() {
        outputView.printBridgeSelect()
        var move = inputView.readMoving()
    }
}