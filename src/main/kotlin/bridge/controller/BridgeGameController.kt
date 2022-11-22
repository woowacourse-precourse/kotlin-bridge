package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.constants.Constant.Companion.START_COUNT
import bridge.constants.Constant.Companion.START_INDEX
import bridge.constants.String.Companion.STRING_BLANK
import bridge.constants.String.Companion.STRING_UP
import bridge.constants.String.Companion.STRING_WRONG
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

    var upLine = mutableListOf<String>()
    var downLine = mutableListOf<String>()
    var process = mutableListOf<MutableList<String>>()
    var flag = Flag.PLAYING
    var index = START_INDEX
    var tryCount = START_COUNT

    fun play() {
        do {
            tryCount++
            initProcess()
            playBridgeGame()
        } while (flag == Flag.FAIL && queryGameRetry())
        outputView.printResult(tryCount, process, flag)
    }

    fun playBridgeGame() {
        val bridge = init()
        do {
            continueBridgeGame(bridge)
            outputView.printMap(process)
            flag = changeGameFlag(bridge)
            index++
        } while (flag == Flag.PLAYING)
    }

    fun init(): List<String> {
        outputView.printStart()
        val length = inputView.readBridgeLength()
        return bridgeMaker.makeBridge(length)
    }

    fun initProcess() {
        process.add(upLine)
        process.add(downLine)
    }

    fun continueBridgeGame(bridge: List<String>) {
        val moving = inputView.readMoving()
        if (moving == STRING_UP) {
            upLine.add(bridgeGame.move(moving, bridge[index]))
            downLine.add(STRING_BLANK)
            return
        }
        downLine.add(bridgeGame.move(moving, bridge[index]))
        upLine.add(STRING_BLANK)
    }

    fun changeGameFlag(bridge: List<String>): Flag {
        if (judgeGameFailed()) {
            return Flag.FAIL
        }
        if (judgeGameClear(bridge)) {
            return Flag.CLEAR
        }
        return Flag.PLAYING
    }

    fun queryGameRetry(): Boolean {
        return bridgeGame.retry(inputView.readGameRetry())
    }

    fun judgeGameFailed(): Boolean {
        if (upLine[index] == STRING_WRONG || downLine[index] == STRING_WRONG) {
            return true
        }
        return false
    }

    fun judgeGameClear(bridge: List<String>): Boolean {
        if (index == bridge.size - 1) {
            return true
        }
        return false
    }

}