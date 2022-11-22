package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.domain.Flag
import bridge.views.InputView
import bridge.views.OutputView

class BridgeGameController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private val bridgeMaker = BridgeMaker(bridgeNumberGenerator)

    var process = mutableListOf<MutableList<String>>()
    var upLine = mutableListOf<String>()
    var downLine = mutableListOf<String>()
    var flag = Flag.PLAYING
    var index = 0
    var tryCount = 0

    fun play() {
        do {
            tryCount++
            playBridgeGame()
        } while (flag == Flag.FAIL && queryGameRetry())
        outputView.printResult(tryCount, process, flag)
    }

    fun playBridgeGame() {
        val bridge = init()
        do {
            continueBridgeGame(index, bridge)
            process.add(upLine)
            process.add(downLine)
            flag = changeGameFlag(index, bridge)
            index++
        } while (flag == Flag.PLAYING)
    }

    fun init(): List<String> {
        outputView.printStart()
        outputView.printInputBridgeLength()
        val length = inputView.readBridgeLength()
        return bridgeMaker.makeBridge(length)
    }

    fun continueBridgeGame(index: Int, bridge: List<String>) {
        outputView.printInputMoving()
        val moving = inputView.readMoving()
        if (moving == "U") {
            bridgeGame.move(upLine, moving, bridge[index])
            downLine.add(" ")
        }
        bridgeGame.move(downLine, moving, bridge[index])
        upLine.add(" ")
    }

    fun changeGameFlag(index: Int, bridge: List<String>): Flag {
        if (judgeGameFailed(index)) {
            return Flag.FAIL
        }
        if (judgeGameClear(index, bridge)) {
            return Flag.CLEAR
        }
        return Flag.PLAYING
    }

    fun queryGameRetry(): Boolean {
        outputView.printInputRetry()
        return bridgeGame.retry(inputView.readGameRetry())
    }

    fun judgeGameFailed(index: Int): Boolean {
        if (upLine[index] == "X" || downLine[index] == "X") {
            return true
        }
        return false
    }

    fun judgeGameClear(index: Int, bridge: List<String>): Boolean {
        if (index == bridge.size - 1) {
            return true
        }
        return true
    }

}