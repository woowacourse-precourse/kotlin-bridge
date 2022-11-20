package bridge.domain

import bridge.ui.InputView
import bridge.ui.OutputView
import bridge.utils.*

class Checker(private val bridge: List<String>) {
    fun judgeUserInput() {
        val inputView = InputView()
        val outputView = OutputView()
        val bridgeGame = BridgeGame()
        var map = listOf<String>()

        for ((column, actual) in bridge.withIndex()) {
            println(MOVE_INPUT_MSG)
            val predict = inputView.readMoving()

            map = outputView.printMap(column, actual, predict)
            println(map[0])
            println(map[1])

            if (!bridgeGame.move(actual, predict)) {
                println(GAME_CMD_INPUT_MSG)
                if(inputView.readGameCommand() == RESTART){ // 실패 후 재시작
                    outputView.initMap()
                    //bridgeGame.retry(bridge)
                    //judgeUserInput()
                }else { // 실패 후 종료
                    outputView.printResult(map, FAIL, bridgeGame.getTryNumber())
                    return
                }
            }
        }

        // 끝까지 다리를 건넌 경우
        outputView.printResult(map, SUCCESS, bridgeGame.getTryNumber())
        return
    }
}