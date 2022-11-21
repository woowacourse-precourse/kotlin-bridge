package bridge.Controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.bridgeSize
import bridge.Model.BridgeData.isPlay
import bridge.Model.BridgeData.resetData
import bridge.Model.BridgeData.roundResult
import bridge.Model.BridgeGame
import bridge.Model.BridgeGame.Companion.downResult
import bridge.Model.BridgeGame.Companion.finalResult
import bridge.Model.BridgeGame.Companion.tryCount
import bridge.Model.BridgeGame.Companion.upResult
import bridge.Model.BridgeResult
import bridge.Model.Referee
import bridge.View.InputView
import bridge.View.OutputView

class BridgeController {
    private var inputView = InputView()
    private var outputView = OutputView()
    private var bridgeGame = BridgeGame()
    private var bridgeSelect = ""

    fun startGame() {
        outputView.printStart()
        getBridgeSize()
        makeBridge()
        processGame()
    }

    fun processGame() {
        while (isPlay) {
            checkLastRound()
            bridgeSelect = getBridgeSelect()
            moveBridge()
            outputView.printMap(upResult, downResult)
        }
        getGameCommand()
    }

    fun getBridgeSize() {
        outputView.printBridgeSize()
        bridgeSize = inputView.readBridgeSize()
    }

    fun makeBridge() {
        var bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        var bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        bridgeShape = bridgeMaker.makeBridge(bridgeSize)
        println(bridgeShape) //삭제
    }

    fun getBridgeSelect(): String {
        outputView.printBridgeSelect()
        return inputView.readMoving()
    }

    fun moveBridge() {
        val result = compareBridge()
        if (result == BridgeResult.UP_WIN || result == BridgeResult.DOWN_WIN) {
            bridgeGame.move()
        } else {
            bridgeGame.miss()
            isPlay = false
        }
        bridgeGame.makeUpDownResult(result)
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
            printFinalResult()
            isPlay = false
        }
    }

    fun getGameCommand() {
        outputView.printGameOver()
        var command = inputView.readGameCommand()
        when (command) {
            "R" -> {
                bridgeGame.retry()
                gameRetry()
                isPlay = true
                processGame()
            }
            "Q" -> {
                printFinalResult()
            }
        }
    }

    fun gameRetry() {
        bridgeGame.retry()
        resetData()
    }

    fun printFinalResult() {
        outputView.printFinalResult()
        outputView.printMap(upResult, downResult)
        outputView.printResult(finalResult, tryCount)
    }

}