package bridge.Controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.Model.BridgeData.bridgeLocation
import bridge.Model.BridgeData.bridgeShape
import bridge.Model.BridgeData.isPlay
import bridge.Model.BridgeData.resetData
import bridge.Model.BridgeGame
import bridge.Model.BridgeGame.Companion.downResult
import bridge.Model.BridgeGame.Companion.finalResult
import bridge.Model.BridgeGame.Companion.tryCount
import bridge.Model.BridgeGame.Companion.upResult
import bridge.Model.BridgeResult
import bridge.Model.Referee
import bridge.View.InputView
import bridge.View.OutputView
import bridge.util.Constant.LOSE
import bridge.util.Constant.QUIT
import bridge.util.Constant.RETRY

class BridgeController {
    private var inputView = InputView()
    private var outputView = OutputView()
    private var bridgeGame = BridgeGame()
    private var bridgeSelect = ""

    fun startGame() {
        outputView.printStart()
        var size = getBridgeSize()
        makeBridge(size)
        processGame()
    }

    fun processGame() {
        while (isPlay) {
            if (checkLastRound()) {
                break
            }
            bridgeSelect = getBridgeSelect()
            moveBridge(bridgeSelect)
        }
        if (finalResult == LOSE) {
            getGameCommand()
        }
    }

    fun getBridgeSize(): Int {
        outputView.printBridgeSize()
        return inputView.readBridgeSize()
    }

    fun makeBridge(size: Int) {
        var bridgeRandomNumberGenerator = BridgeRandomNumberGenerator()
        var bridgeMaker = BridgeMaker(bridgeRandomNumberGenerator)
        bridgeShape = bridgeMaker.makeBridge(size)
    }

    fun getBridgeSelect(): String {
        outputView.printBridgeSelect()
        return inputView.readMoving()
    }

    fun moveBridge(select: String) {
        val result = bridgeGame.compareState(select)
        if (result == BridgeResult.UP_WIN || result == BridgeResult.DOWN_WIN) {
            bridgeGame.move()
        } else {
            bridgeGame.miss()
            isPlay = false
        }
        printRoundResult(result)
    }

    fun printRoundResult(result: BridgeResult) {
        bridgeGame.makeUpDownResult(result)
        outputView.printMap(upResult, downResult)
    }

    fun checkLastRound(): Boolean {
        var referee = Referee()
        if (referee.judgeLastBridge(bridgeLocation)) {
            printFinalResult()
            return true
        }
        return false
    }

    fun getGameCommand() {
        outputView.printGameOver()
        var command = inputView.readGameCommand()
        runCommand(command)
    }

    fun runCommand(command: String) {
        when (command) {
            RETRY -> {
                retryGame()
                processGame()
            }

            QUIT -> {
                printFinalResult()
            }
        }
    }

    fun retryGame() {
        bridgeGame.retry()
        resetData()
        isPlay = true
    }

    fun printFinalResult() {
        outputView.printFinalResult()
        outputView.printMap(upResult, downResult)
        outputView.printResult(finalResult, tryCount)
    }
}