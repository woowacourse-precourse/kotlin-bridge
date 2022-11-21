package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.*

class BridgeChecker(private val bridge: List<String>) {
    private val bridgeGame = BridgeGame()
    private var map = listOf<String>()
    private var result = ""

    fun compare() {
        val outputView = OutputView()

        for ((column, actual) in bridge.withIndex()) {
            val predict = askDirection()
            map = outputView.printMap(column, actual, predict)
            println(map[0])
            println(map[1])
            if (!bridgeGame.move(actual, predict)) {
                result = FAIL
                handleIncorrectCase() // todo: 여기서 retry를 호출하면 무한 재귀 호출이 되는 건가..??
            }
        }

        if(result != FAIL){
            outputView.printResult(map, SUCCESS, bridgeGame.getTryNumber())
            return
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

    private fun handleIncorrectCase() {
        val outputView = OutputView()
        if(askGameCommand() == RESTART){
            outputView.initMap()
            bridgeGame.retry(bridge)
        }else {
            outputView.printResult(map, FAIL, bridgeGame.getTryNumber())
        }
    }
}