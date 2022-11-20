package bridge.Controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.bridgeSize
import bridge.Model.BridgeData.isOver
import bridge.Model.BridgeData.roundResult
import bridge.Model.BridgeGame
import bridge.Model.BridgeResult
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
        while (!isOver) {
            checkLastRound()
            bridgeSelect = getBridgeSelect()
            moveBridge()
        }
    }

    fun getBridgeSize() {
        outputView.printBridgeSize()
        bridgeSize = inputView.readBridgeSize()
    }

    fun makeBridge() {
        var bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        var bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        bridgeShape = bridgeMaker.makeBridge(bridgeSize)
        println(bridgeShape)
    }

    fun getBridgeSelect(): String {
        outputView.printBridgeSelect()
        return inputView.readMoving()
    }

    fun moveBridge() {
        val result = compareBridge()
        var bridgeGame = BridgeGame()
        if (result == BridgeResult.UP_WIN || result == BridgeResult.DOWN_WIN) {
            bridgeGame.move()
        } else {
            isOver = true
            bridgeGame.gameOver()
        }
    }

    fun compareBridge(): BridgeResult {
        var referee = Referee()
        var result = referee.judgeMove(bridgeSelect)
        roundResult.add(result)
        return result
    }

    fun checkLastRound() {
        var referee = Referee()
        if (referee.judgeLastBridge(bridgeLocation)) {
            isOver = true
        }
    }
}