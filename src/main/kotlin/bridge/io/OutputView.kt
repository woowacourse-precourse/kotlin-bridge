package bridge.io

import bridge.resources.FINAL_RESULT
import bridge.resources.SUCCESS_OR_NOT
import bridge.resources.TOTAL_TRY

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    fun printMap(topRow: List<String>, BotRow: List<String>) {
        printLine(topRow)
        printLine(BotRow)
        println()
    }

    private fun printLine(line: List<String>) { // 한줄 출력
        println("[ " + line.joinToString(" | ") + " ]")
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    fun printResultTitle() {
        println(FINAL_RESULT)
    }

    fun printResultStatus(result: String, tryCount: Int) {
        println(SUCCESS_OR_NOT + result)
        println(TOTAL_TRY + tryCount)
    }
}
