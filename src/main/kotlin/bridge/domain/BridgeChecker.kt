package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.*

class BridgeChecker(private val bridge: List<String>) {
    private val bridgeGame = BridgeGame()
    private var map = listOf<String>()
    private var resultFlag = ""

    fun checkBridge() {
        val outputView = OutputView()

        for ((index, actual) in bridge.withIndex()) {
            val predict = askDirection()
            map = outputView.printMap(index, actual, predict)
            println(map[0])
            println(map[1])

            // 이동할 수 없으면 for문 탈줄
            if(!checkMovable(actual, predict)) {
                resultFlag = FAIL
                break
            }
        }

        if(resultFlag == FAIL){
            askRetry() // 재귀 호출 가능성 있음.
        }else {
            outputView.printResult(map, SUCCESS, bridgeGame.getTryNumber())
        }
    }

    private fun checkMovable(actual: String, predict: String): Boolean {
        return bridgeGame.move(actual, predict)
    }

    private fun askRetry() {
        val outputView = OutputView()
        if(askGameCommand() == RESTART){
            resultFlag = ""
            outputView.initMap()
            bridgeGame.retry() // 시도 횟수만 증가시키기
            checkBridge() // 동일한 다리로 다시 시도!!!
        }else {
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
}