package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.GAME_CMD_INPUT_MSG
import bridge.utils.MOVE_INPUT_MSG
import bridge.utils.RESTART

class BridgeChecker(private val bridge: List<String>) {
    private val bridgeGame = BridgeGame()
    private val outputView = OutputView()
    private var map = listOf<String>()
    private var resultFlag = ""

    fun checkBridge() {
        for ((index, actual) in bridge.withIndex()) {
            val predict = startGuessing(index, actual)
            if (!checkMovable(actual, predict)) break
        }
        if (resultFlag == FAIL) askRestartOrQuit()
        else outputView.printResult(map, SUCCESS, bridgeGame.getTryNumber())
    }

    private fun startGuessing(index: Int, actual: String): String {
        val predict = askDirection()
        map = outputView.printMap(index, actual, predict)
        println(map[0])
        println(map[1])
        return predict
    }

    private fun checkMovable(actual: String, predict: String): Boolean {
        if(!bridgeGame.move(actual, predict)){
            resultFlag = FAIL
            return false
        }
        return true
    }

    private fun askRestartOrQuit() {
        if (askGameCommand() == RESTART) {
            resultFlag = ""
            outputView.initMap() // 맵 초기화
            bridgeGame.retry() // 시도 횟수 증가
            checkBridge() // 동일한 다리로 재시도
        } else {
            outputView.printResult(map, FAIL, bridgeGame.getTryNumber())
        }
    }

    private fun askDirection(): String {
        println(MOVE_INPUT_MSG)
        return InputView().readMoving()
    }

    private fun askGameCommand(): String {
        println(GAME_CMD_INPUT_MSG)
        return InputView().readGameCommand()
    }

    companion object {
        const val SUCCESS = "성공"
        const val FAIL = "실패"
    }
}