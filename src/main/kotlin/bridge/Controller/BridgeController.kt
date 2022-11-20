package bridge.Controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.bridgeSize
import bridge.Model.BridgeGame
import bridge.Model.Referee
import bridge.View.InputView
import bridge.View.OutputView

class BridgeController {
    private var inputView = InputView()
    private var outputView = OutputView()
    private var bridgeSelect = ""

    fun startGame() {
        outputView.printStart()
        getBridgeSize()
        makeBridge()
        bridgeSelect = getBridgeSelect()
        moveBridge()
    }

    fun getBridgeSize() {
        outputView.printBridgeSize()
        bridgeSize = inputView.readBridgeSize()
    }

    fun makeBridge() {
        var bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        var bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        bridgeShape = bridgeMaker.makeBridge(bridgeSize)
    }

    fun getBridgeSelect(): String {
        outputView.printBridgeSelect()
        return inputView.readMoving()
    }

    fun moveBridge() {
        val result = compareBridge()
        var bridgeGame = BridgeGame()
        when (result) {
            "O" -> bridgeGame.move()
            "X" -> bridgeGame.gameOver()
        }
    }

    fun compareBridge(): String {
        var referee = Referee(bridgeShape, bridgeLocation)
        return referee.judgeMove(bridgeSelect)
    }
}