package view

import util.BridgeMessage.FAIL
import util.BridgeMessage.FAIL_ENGLISH
import util.BridgeMessage.FINAL_GAME_RESULT
import util.BridgeMessage.GAME_START_NOTIFICATION
import util.BridgeMessage.IS_SUCCESS
import util.BridgeMessage.LEFT_SQUARE_BRACKETS
import util.BridgeMessage.REST
import util.BridgeMessage.RIGHT_SQUARE_BRACKETS
import util.BridgeMessage.SEPARATOR
import util.BridgeMessage.SUCCESS
import util.BridgeMessage.TOTAL_ATTEMPT

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {

    fun printGameStartNotification() {
        println(GAME_START_NOTIFICATION)
    }

    fun printMap(ox: List<MutableList<String>>) {
        printGameResult(ox)
    }

    fun printResult(ox: List<MutableList<String>>, count: Int, isSuccesss: String) {
        var isSuccess = SUCCESS
        if (isSuccesss == FAIL_ENGLISH) {
            isSuccess = FAIL
        }
        println(FINAL_GAME_RESULT)
        printGameResult(ox)
        println("$IS_SUCCESS $isSuccess")
        println("$TOTAL_ATTEMPT $count")
    }

    private fun printGameResult(ox: List<MutableList<String>>) {
        for (i in 0..1) {
            print("$LEFT_SQUARE_BRACKETS ")
            print(ox[i].toString().replace(REST, SEPARATOR).removePrefix(LEFT_SQUARE_BRACKETS).removeSuffix(RIGHT_SQUARE_BRACKETS))
            print(" $RIGHT_SQUARE_BRACKETS")
            println()
        }
        println()
    }
}
