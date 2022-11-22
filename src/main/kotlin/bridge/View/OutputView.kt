package bridge.View

import bridge.util.Constant.BRIDGE_SELECT
import bridge.util.Constant.BRIDGE_SIZE
import bridge.util.Constant.FINAL_RESULT
import bridge.util.Constant.GAME_OVER
import bridge.util.Constant.GAME_START
import bridge.util.Constant.SUCCESS_OR_FAIL
import bridge.util.Constant.TOTAL_TRY


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStart() {
        println(GAME_START)
        println()
    }

    fun printBridgeSize() {
        println(BRIDGE_SIZE)
    }

    fun printBridgeSelect() {
        println()
        println(BRIDGE_SELECT)
    }

    fun printGameOver() {
        println()
        println(GAME_OVER)
    }

    fun printFinalResult() {
        println()
        println(FINAL_RESULT)
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(upResult: List<String>, downResult: List<String>) {
        println(upResult.joinToString(separator = " | ", prefix = "[ ", postfix = " ]"))
        println(downResult.joinToString(separator = " | ", prefix = "[ ", postfix = " ]"))
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(finalResult: String, tryCnt: Int) {
        println()
        println("${SUCCESS_OR_FAIL}${finalResult}")
        println("${TOTAL_TRY}${tryCnt}")
    }
}
